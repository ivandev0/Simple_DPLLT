package arrays;

import base.Formula;
import euf.EUFEquality;
import euf.EUFFormula;

import java.util.List;

public class ArraysFormula extends Formula<ArraysSymbol, ArraysEquality> {
    public ArraysFormula() {
        super();
    }

    public ArraysFormula(List<ArraysEquality> equalities) {
        super(equalities);
    }

    public ArraysFormula(ArraysFormula formula) {
        super(formula);
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
        boolean next = true;
        for (int i = 0; i < arraysEqualities.size() && next; i++) {
            ArraysEquality it = arraysEqualities.get(i);
            next = !it.replaceInPlaceByX1(newFormula);
        }
        return newFormula;
    }

    public ArraysFormula replaceByX2() {
        ArraysFormula newFormula = new ArraysFormula(this);
        List<ArraysEquality> arraysEqualities = newFormula.equalities;
        boolean next = true;
        for (int i = 0; i < arraysEqualities.size() && next; i++) {
            ArraysEquality it = arraysEqualities.get(i);
            next = !it.replaceInPlaceByX2(newFormula);
        }
        return newFormula;
    }
}
