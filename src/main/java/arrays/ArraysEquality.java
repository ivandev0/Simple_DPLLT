package arrays;

import base.Equality;

public class ArraysEquality extends Equality<ArraysSymbol> {
    public ArraysEquality(ArraysSymbol left, ArraysSymbol right, boolean isEqual) {
        super(left, right, isEqual);
    }

    @Override
    public Equality<ArraysSymbol> copy() {
        return new ArraysEquality(left.copy(), right.copy(), isEqual);
    }

    public void replaceInPlaceByX1(ArraysFormula formula) {
        left.replaceInPlaceByX1(formula);
        right.replaceInPlaceByX1(formula);
    }

    public void replaceInPlaceByX2(ArraysFormula formula) {
        left.replaceInPlaceByX2(formula);
        right.replaceInPlaceByX2(formula);
    }
}
