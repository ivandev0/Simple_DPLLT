package common;

import arrays.ArraysEquality;
import base.Equality;
import euf.EUFEquality;

public class CommonEquality extends Equality<CommonSymbol> {
    public CommonEquality(CommonSymbol left, CommonSymbol right, boolean isEqual) {
        super(left, right, isEqual);
    }

    @Override
    public Equality<CommonSymbol> copy() {
        return new CommonEquality(left.copy(), right.copy(), isEqual);
    }

    public void purify(CommonFormula formula) {
        left.purify(formula);
        right.purify(formula);
        if (left.getKind() != right.getKind()) {
            CommonSymbol tempVar = formula.nextVar(left.toString());
            formula.add(new CommonEquality(left, tempVar, true));
            formula.add(new CommonEquality(right, tempVar, isEqual));
        } else {
            formula.add(this);
        }
    }

    public ArraysEquality toArraysEquality() {
        return new ArraysEquality(left.toArraysSymbol(), right.toArraysSymbol(), isEqual);
    }

    public EUFEquality toEUFEquality() {
        return new EUFEquality(left.toFunctionSymbol(), right.toFunctionSymbol(), isEqual);
    }
}
