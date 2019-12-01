package base;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Formula<T extends Symbol<T>, E extends Equality<T>> {
    protected List<E> equalities;

    public Formula() {
        equalities = new ArrayList<>();
    }

    public Formula(List<E> equalities) {
        this.equalities = equalities;
    }

    public Formula(Formula<T, E> formula) {
        equalities = (List<E>) formula.equalities.stream().map(it -> it.copy()).collect(Collectors.toList());
    }

    public void add(E equality) {
        equalities.add(equality);
    }

    public Set<T> getAllSubTerms() {
        return equalities.stream()
                .map(Equality::getAllSubTerms)
                .flatMap(Set::stream)
                .collect(Collectors.toSet());
    }

    public List<E> getEqualities(boolean isEqual) {
        return equalities.stream().filter(it -> it.isEqual() == isEqual).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return equalities.stream().map(Equality::toString).collect(Collectors.joining(" ^ "));
    }
}
