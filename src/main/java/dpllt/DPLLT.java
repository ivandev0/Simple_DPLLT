package dpllt;

import arrays.ArraysFormula;
import arrays.ArraysSat;
import base.Formula;
import cnf.CNF;
import common.CommonEquality;
import common.CommonFormula;
import common.CommonSymbol;
import common.Kind;
import dpll.DPLL;
import dpll.Model;
import euf.EUFFormula;
import euf.EUFSat;
import euf.FunctionSymbol;
import reader.CommonReader;
import util.CongruentClosure;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class DPLLT {
    public static boolean solve(String formula) {
        CommonFormula commonFormula = CommonReader.transform(formula);

        return solve(commonFormula);
    }

    public static boolean solve(CommonFormula commonFormula) {
        CNF cnf = commonFormula.getCnf();

        while (true) {
            Model model = DPLL.solve(cnf);
            if (model == null) {
                return false;
            } else {
                Set<CommonEquality> equalities = commonFormula.toFOL(model);

                CommonFormula newFormula = new CommonFormula(commonFormula.getCnf(), new HashMap<>());
                newFormula.purify(equalities);
                List<FunctionSymbol> singleLiteralTerms = newFormula
                        .getAllSubTerms().stream()
                        .filter(it -> it.getArgs().isEmpty())
                        .map(CommonSymbol::toFunctionSymbol)
                        .collect(Collectors.toList());

                Map<Kind, Formula> kindToMap = newFormula.separate();
                EUFFormula eufFormula = (EUFFormula) kindToMap.get(Kind.EUF);
                ArraysFormula arraysFormula = (ArraysFormula) kindToMap.get(Kind.ARRAYS);
                while (true) {
                    int sizeEuf = eufFormula.getEqualitiesCount();
                    int sizeArrays = arraysFormula.getEqualitiesCount();

                    CongruentClosure closure;
                    closure = EUFSat.solveWithClosure(eufFormula);
                    if (closure == null) break; // unsat
                    closure.getAllCommon(singleLiteralTerms).forEach(it -> arraysFormula.add(it.toArraysEquality()));

                    closure = ArraysSat.solveWithClosure(arraysFormula);
                    if (closure == null) break; // unsat
                    closure.getAllCommon(singleLiteralTerms).forEach(it -> eufFormula.add(it.toEUFEquality()));

                    if (sizeEuf == eufFormula.getEqualitiesCount() && sizeArrays == arraysFormula.getEqualitiesCount()) {
                        return true;
                    }
                }

                // add inverse model to cnf and repeat
                cnf = cnf.addClausesAndSimplify(new CNF(model.toInverseDisjunction()));
            }
        }
    }
}
