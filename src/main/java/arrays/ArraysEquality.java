package arrays;

import java.util.HashSet;
import java.util.Set;

public class ArraysEquality {
    private boolean isEqual;
    private ArraysSymbol left, right;

    public ArraysEquality(ArraysSymbol left, ArraysSymbol right, boolean isEqual) {
        this.isEqual = isEqual;
        this.left = left;
        this.right = right;
    }

    public ArraysEquality(ArraysEquality equality) {
        this.isEqual = equality.isEqual();
        this.left = new ArraysSymbol(equality.left);
        this.right = new ArraysSymbol(equality.right);
    }

    public ArraysSymbol getLeft() {
        return left;
    }

    public ArraysSymbol getRight() {
        return right;
    }

    public boolean isEqual() {
        return isEqual;
    }

    public Set<ArraysSymbol> getAllSubTerms() {
        Set<ArraysSymbol> subTerms = new HashSet<>();
        subTerms.addAll(left.getAllSubTerms());
        subTerms.addAll(right.getAllSubTerms());
        return subTerms;
    }

    public void replaceInPlaceByX1(ArraysFormula formula) {
        left.replaceInPlaceByX1(formula);
        right.replaceInPlaceByX1(formula);
    }

    public void replaceInPlaceByX2(ArraysFormula formula) {
        left.replaceInPlaceByX2(formula);
        right.replaceInPlaceByX2(formula);
    }

    @Override
    public String toString() {
        String equal = isEqual ? " = " : " != ";
        return left + equal + right;
    }
}
