package euf;

import util.CongruentClosure;

import java.util.Set;

public class EUFSat {
    public static boolean solve(EUFFormula formula) {
        Set<FunctionSymbol> subTerms = formula.getAllSubTerms();
        CongruentClosure closure = new CongruentClosure(subTerms);

        for (EUFEquality equality : formula.getEqualities(true)) {
            closure.newAssociation(equality.getLeft(), equality.getRight());
        }

        for (EUFEquality equality : formula.getEqualities(false)) {
            if (closure.symbolsAreEqual(equality.getLeft(), equality.getRight())) return false;
        }

        return true;
    }

    public static CongruentClosure solveWithClosure(EUFFormula formula) {
        Set<FunctionSymbol> subTerms = formula.getAllSubTerms();
        CongruentClosure closure = new CongruentClosure(subTerms);

        for (EUFEquality equality : formula.getEqualities(true)) {
            closure.newAssociation(equality.getLeft(), equality.getRight());
        }

        for (EUFEquality equality : formula.getEqualities(false)) {
            if (closure.symbolsAreEqual(equality.getLeft(), equality.getRight())) return null;
        }

        return closure;
    }
}
