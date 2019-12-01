package euf;

import base.Formula;

import java.util.List;

public class EUFFormula extends Formula<FunctionSymbol, EUFEquality> {
    public EUFFormula() {
        super();
    }

    public EUFFormula(List<EUFEquality> equalities) {
        super(equalities);
        // todo check arity correctness
    }
}
