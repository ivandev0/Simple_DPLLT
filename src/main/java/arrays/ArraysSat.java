package arrays;

import euf.EUFFormula;
import euf.EUFSat;
import util.CongruentClosure;

public class ArraysSat {
    public static boolean solve(ArraysFormula formula) {
        if (formula.getAllSubTerms().stream().noneMatch(it -> it.getName().equals("store"))) {
            return EUFSat.solve(formula.toEUF());
        }

        boolean Ax1 = solve(formula.replaceByX1());
        if (Ax1) return true;

        boolean Ax2 = solve(formula.replaceByX2());
        if (Ax2) return true;

        return false;
    }

    public static CongruentClosure solveWithClosure(ArraysFormula formula) {
        if (formula.getAllSubTerms().stream().noneMatch(it -> it.getName().equals("store"))) {
            EUFFormula eufFormula = formula.toEUF();
            return EUFSat.solveWithClosure(eufFormula);
        }

        CongruentClosure Ax1 = solveWithClosure(formula.replaceByX1());
        if (Ax1 != null) return Ax1;

        CongruentClosure Ax2 = solveWithClosure(formula.replaceByX2());
        if (Ax2 != null) return Ax2;

        return null;
    }
}
