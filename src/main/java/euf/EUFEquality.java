package euf;

import java.util.HashSet;
import java.util.Set;

public class EUFEquality {
    private boolean isEqual;
    private FunctionSymbol left, right;

    public EUFEquality(FunctionSymbol left, FunctionSymbol right, boolean isEqual) {
        this.isEqual = isEqual;
        this.left = left;
        this.right = right;
    }

    public FunctionSymbol getLeft() {
        return left;
    }

    public FunctionSymbol getRight() {
        return right;
    }

    public boolean isEqual() {
        return isEqual;
    }

    public Set<FunctionSymbol> getAllSubTerms() {
        Set<FunctionSymbol> subTerms = new HashSet<>();
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
