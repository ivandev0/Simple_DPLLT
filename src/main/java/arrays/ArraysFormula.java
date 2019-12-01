package arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ArraysFormula {
    List<ArraysEquality> equalities;

    public ArraysFormula() {
        equalities = new ArrayList<>();
    }

    public ArraysFormula(List<ArraysEquality> equalities) {
        this.equalities = equalities;
    }

    public void add(ArraysEquality equality) {
        equalities.add(equality);
    }

    public Set<ArraysSymbol> getAllSubTerms() {
        return equalities.stream()
                .map(ArraysEquality::getAllSubTerms)
                .flatMap(Set::stream)
                .collect(Collectors.toSet());
    }

    public List<ArraysEquality> getEqualities(boolean isEqual) {
        return equalities.stream().filter(it -> it.isEqual() == isEqual).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return equalities.stream().map(ArraysEquality::toString).collect(Collectors.joining(" ^ "));
    }
}
