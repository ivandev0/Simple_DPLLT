package common;

import arrays.ArraysEquality;
import arrays.ArraysFormula;
import base.Formula;
import cnf.CNF;
import dpll.Model;
import euf.EUFEquality;
import euf.EUFFormula;
import util.IDPool;

import java.util.*;

public class CommonFormula extends Formula<CommonSymbol, CommonEquality> {
    private CNF equivalent;
    private Map<CommonEquality, Integer> pool;
    private IDPool tempVarPool = new IDPool();

    public CommonFormula(CNF equivalent, Map<CommonEquality, Integer> pool) {
        this.equivalent = equivalent;
        this.pool = pool;
    }

    public CNF getCnf() {
        return equivalent;
    }

    public Set<CommonEquality> toFOL(Model model) {
        Set<CommonEquality> equalitySet = new HashSet<>();
        pool.forEach((key, value) -> {
            if (model.containsLiteral(value)) {
                equalitySet.add(key);
            } else if (model.containsLiteral(-value)) {
                equalitySet.add((CommonEquality) key.inverse());
            }
        });
        return equalitySet;
    }

    public CommonSymbol nextVar(String symbol) {
        return new CommonSymbol("tmp" + tempVarPool.idByName(symbol), new ArrayList<>(), Kind.TMP);
    }

    public void purify(Set<CommonEquality> equalities) {
        for (CommonEquality equality : equalities) {
            equality.purify(this);
        }
    }

    public Map<Kind, Formula> separate() {
        Map<Kind, Formula> kindToFormula = new HashMap<>();
        kindToFormula.put(Kind.EUF, new EUFFormula());
        kindToFormula.put(Kind.ARRAYS, new ArraysFormula());
        for (CommonEquality equality : equalities) {
            if (equality.getLeft().getKind() == Kind.ARRAYS || equality.getRight().getKind() == Kind.ARRAYS) {
                kindToFormula.get(Kind.ARRAYS).add(equality.toArraysEquality());
            } else {
                kindToFormula.get(Kind.EUF).add(equality.toEUFEquality());
            }
        }
        return kindToFormula;
    }
}
