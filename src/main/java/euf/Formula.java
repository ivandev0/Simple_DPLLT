package euf;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Formula {
    List<Equality> equalities;

    public Formula() {
        equalities = new ArrayList<>();
    }

    public Formula(List<Equality> equalities) {
        this.equalities = equalities;
        // todo check arity correctness
    }

    public void add(Equality equality) {
        equalities.add(equality);
    }

    public Set<FunctionSymbol> getAllSubTerms() {
        return equalities.stream()
                .map(Equality::getAllSubTerms)
                .flatMap(Set::stream)
                .collect(Collectors.toSet());
    }

    public List<Equality> getEqualities(boolean isEqual) {
        return equalities.stream().filter(it -> it.isEqual() == isEqual).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return equalities.stream().map(Equality::toString).collect(Collectors.joining(" ^ "));
    }
}
