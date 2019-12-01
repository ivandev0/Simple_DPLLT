package arrays;

import euf.EUFEquality;
import euf.EUFFormula;

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

    public ArraysFormula(ArraysFormula formula) {
        equalities = formula.equalities.stream().map(ArraysEquality::new).collect(Collectors.toList());
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

    public EUFFormula toEUF() {
        EUFFormula formula = new EUFFormula();
        for (ArraysEquality equality : equalities) {
            formula.add(new EUFEquality(equality.getLeft().toEUF(), equality.getRight().toEUF(), equality.isEqual()));
        }
        return formula;
    }

    public ArraysFormula replaceByX1() {
        ArraysFormula newFormula = new ArraysFormula(this);
        List<ArraysEquality> arraysEqualities = newFormula.equalities;
        for (int i = 0; i < arraysEqualities.size(); i++) {
            ArraysEquality it = arraysEqualities.get(i);
            it.replaceInPlaceByX1(newFormula);
        }
        return newFormula;
    }

    public ArraysFormula replaceByX2() {
        ArraysFormula newFormula = new ArraysFormula(this);
        List<ArraysEquality> arraysEqualities = newFormula.equalities;
        for (int i = 0; i < arraysEqualities.size(); i++) {
            ArraysEquality it = arraysEqualities.get(i);
            it.replaceInPlaceByX2(newFormula);
        }
        return newFormula;
    }

    @Override
    public String toString() {
        return equalities.stream().map(ArraysEquality::toString).collect(Collectors.joining(" ^ "));
    }
}
