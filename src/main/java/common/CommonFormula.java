package common;

import base.Formula;
import cnf.CNF;

import java.util.Map;

public class CommonFormula extends Formula<CommonSymbol, CommonEquality> {
    private CNF equivalent;
    private Map<CommonEquality, Integer> pool;

    public CommonFormula(CNF equivalent, Map<CommonEquality, Integer> pool) {
        this.equivalent = equivalent;
        this.pool = pool;
    }

    public CNF getCnf() {
        return equivalent;
    }
}
