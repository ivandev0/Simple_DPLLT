package euf;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Formula {
    List<Equality> equalities;

    public Formula() {
        equalities = new ArrayList<>();
    }

    public Formula(List<Equality> equalities) {
        this.equalities = equalities;
    }

    public void add(Equality equality) {
        equalities.add(equality);
    }

    @Override
    public String toString() {
        return equalities.stream().map(Equality::toString).collect(Collectors.joining(" ^ "));
    }
}
