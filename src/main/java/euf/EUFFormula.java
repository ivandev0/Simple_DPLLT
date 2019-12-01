package euf;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class EUFFormula {
    List<EUFEquality> equalities;

    public EUFFormula() {
        equalities = new ArrayList<>();
    }

    public EUFFormula(List<EUFEquality> equalities) {
        this.equalities = equalities;
        // todo check arity correctness
    }

    public void add(EUFEquality equality) {
        equalities.add(equality);
    }

    public Set<FunctionSymbol> getAllSubTerms() {
        return equalities.stream()
                .map(EUFEquality::getAllSubTerms)
                .flatMap(Set::stream)
                .collect(Collectors.toSet());
    }

    public List<EUFEquality> getEqualities(boolean isEqual) {
        return equalities.stream().filter(it -> it.isEqual() == isEqual).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return equalities.stream().map(EUFEquality::toString).collect(Collectors.joining(" ^ "));
    }
}
