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

    @Override
    public String toString() {
        String equal = isEqual ? " = " : " != ";
        return left + equal + right;
    }
}
