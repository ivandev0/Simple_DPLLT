package base;

import java.util.HashSet;
import java.util.Objects;
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

    public Equality<T> inverse() {
        Equality<T> inverse = this.copy();
        inverse.isEqual = !inverse.isEqual;
        return inverse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Equality<?> equality = (Equality<?>) o;
        return isEqual == equality.isEqual &&
                left.equals(equality.left) &&
                right.equals(equality.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isEqual, left, right);
    }

    @Override
    public String toString() {
        String equal = isEqual ? " = " : " != ";
        return left + equal + right;
    }
}
