package dpllt;

import base.Formula;
import cnf.CNF;
import common.CommonEquality;
import common.CommonFormula;
import common.Kind;
import dpll.DPLL;
import dpll.Model;
import reader.CommonReader;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DPLLT {
    public static boolean solve(String formula) {
        CommonFormula commonFormula = CommonReader.transform(formula);
        CNF cnf = commonFormula.getCnf();

        while (true) {
            Model model = DPLL.solve(cnf);
            if (model == null) {
                return false;
            } else {
                Set<CommonEquality> equalities = commonFormula.toFOL(model);

                CommonFormula newFormula = new CommonFormula(commonFormula.getCnf(), new HashMap<>());
                newFormula.purify(equalities);
                Map<Kind, Formula> kindToMap = newFormula.separate();
                kindToMap.forEach((key, value) -> {
                    switch (key) {
                        case EUF:

                            break;
                        case ARRAYS:

                            break;
                    }
                });
            }
        }


        //return false;
    }
}
