package common;

import base.Equality;

public class CommonEquality extends Equality<CommonSymbol> {
    public CommonEquality(CommonSymbol left, CommonSymbol right, boolean isEqual) {
        super(left, right, isEqual);
    }

    @Override
    public Equality<CommonSymbol> copy() {
        return new CommonEquality(left.copy(), right.copy(), isEqual);
    }
}
