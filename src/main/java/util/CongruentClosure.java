package util;

import euf.FunctionSymbol;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CongruentClosure {
    List<Set<FunctionSymbol>> closure;

    public CongruentClosure(Set<FunctionSymbol> init) {
        closure = new ArrayList<>();
        for (FunctionSymbol functionSymbol : init) {
            closure.add(new HashSet<FunctionSymbol>() {{ add(functionSymbol); }});
        }
    }

    public void newAssociation(FunctionSymbol first, FunctionSymbol second) {

    }

    private void propagation() {

    }

    public boolean symbolsAreEqual(FunctionSymbol first, FunctionSymbol second) {
        return closure.stream().anyMatch(it -> it.contains(first) && it.contains(second));
    }
}
