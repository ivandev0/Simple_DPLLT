package arrays;

import euf.EUFSat;

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
}
