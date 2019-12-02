package dpllt;

import cnf.CNF;
import cnf.Disjunction;
import common.CommonEquality;
import common.CommonFormula;
import common.CommonSymbol;
import common.Kind;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class DPLLTTest {

    @Test
    public void solveSat1() {
        Assert.assertTrue(DPLLT.solve("f(a) = select(A, f(b)) ^ a != b ^ select(store(A, x, f(u1)), u2) = a"));
    }

    @Test
    public void solveOnlyEUF() {
        Assert.assertTrue(DPLLT.solve("f(a) = f(b) ^ a != b"));
    }

    @Test
    public void solveRandomSat() {
        Assert.assertTrue(DPLLT.solve("select(A, x) = f(a) ^ x != y"));
    }

    @Test
    public void solveUnsat1() {
        List<CommonSymbol> empty = new ArrayList<>();
        CommonEquality xEy = new CommonEquality(new CommonSymbol("x", empty, Kind.EUF), new CommonSymbol("y", empty, Kind.EUF), true);

        List<CommonSymbol> storeArgs = new ArrayList<CommonSymbol>() {{
            add(new CommonSymbol("A", empty, Kind.EUF));
            add(new CommonSymbol("x", empty, Kind.EUF));
            add(new CommonSymbol("i", empty, Kind.EUF));
        }};
        CommonSymbol store = new CommonSymbol("store", storeArgs, Kind.ARRAYS);

        List<CommonSymbol> selectArgs = new ArrayList<CommonSymbol>() {{
            add(store);
            add(new CommonSymbol("y", empty, Kind.EUF));
        }};
        CommonSymbol select = new CommonSymbol("select", selectArgs, Kind.ARRAYS);

        List<CommonSymbol> selectAsList = new ArrayList<CommonSymbol>() {{ add(select); }};
        List<CommonSymbol> iArg = new ArrayList<CommonSymbol>() {{ add(new CommonSymbol("i", empty, Kind.EUF)); }};
        CommonEquality fEquality = new CommonEquality(
                new CommonSymbol("f", selectAsList, Kind.EUF),
                new CommonSymbol("f", iArg, Kind.EUF),
                false
        );

        CNF cnf = new CNF(new Disjunction(1), new Disjunction(-2));
        Map<CommonEquality, Integer> pool = new HashMap<CommonEquality, Integer>() {{
            put(xEy, 1);
            put(fEquality, -2);
        }};
        CommonFormula formula = new CommonFormula(cnf, pool);

        Assert.assertFalse(DPLLT.solve(formula));
    }

    @Test
    public void solveUnsat2() {
        Assert.assertFalse(DPLLT.solve("x = y ^ f(select(store(A, x, i), y)) != f (i)"));
    }

    @Test
    public void solveUnsat3() {
        Assert.assertFalse(DPLLT.solve("x = y ^ x != y"));
    }

    @Test
    public void solveUnsat4() {
        Assert.assertFalse(DPLLT.solve("(x = y ^ f(x) != f(y)) v (x != y ^ f(x) = f(y))"));
    }

    @Test
    public void solveUnsat5() {
        Assert.assertFalse(DPLLT.solve("select(store(A, x, f(x)), f(f(x))) != x ^ f(x) = x"));
    }
}