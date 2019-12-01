package euf;

import base.Equality;

public class EUFEquality extends Equality<FunctionSymbol> {
    public EUFEquality(FunctionSymbol left, FunctionSymbol right, boolean isEqual) {
        super(left, right, isEqual);
    }

    @Override
    public Equality<FunctionSymbol> copy() {
        return new EUFEquality(left.copy(), right.copy(), isEqual);
    }
}
