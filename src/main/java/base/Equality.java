package base;

import java.util.HashSet;
import java.util.Set;

public abstract class Equality<T extends Symbol<T>> {
    protected boolean isEqual;
    protected T left, right;

    public Equality(T left, T right, boolean isEqual) {
        this.isEqual = isEqual;
        this.left = left;
        this.right = right;
    }

    public abstract Equality<T> copy();

    public T getLeft() {
        return left;
    }

    public T getRight() {
        return right;
    }

    public boolean isEqual() {
        return isEqual;
    }

    public Set<T> getAllSubTerms() {
        Set<T> subTerms = new HashSet<>();
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
