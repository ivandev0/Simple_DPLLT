package euf;

import util.CongruentClosure;

import java.util.Set;

public class EUFSat {
    public static boolean solve(Formula formula) {
        Set<FunctionSymbol> subTerms = formula.getAllSubTerms();
        CongruentClosure closure = new CongruentClosure(subTerms);

        for (Equality equality : formula.getEqualities(true)) {
            closure.newAssociation(equality.getLeft(), equality.getRight());
        }

        for (Equality equality : formula.getEqualities(false)) {
            if (closure.symbolsAreEqual(equality.getLeft(), equality.getRight())) return false;
        }

        return true;
    }
}
