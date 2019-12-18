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

    public boolean replaceInPlaceByX1(ArraysFormula formula) {
        return left.replaceInPlaceByX1(formula) | right.replaceInPlaceByX1(formula);
    }

    public boolean replaceInPlaceByX2(ArraysFormula formula) {
        return left.replaceInPlaceByX2(formula) | right.replaceInPlaceByX2(formula);
    }
}
