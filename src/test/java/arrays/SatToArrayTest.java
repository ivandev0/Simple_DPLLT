package arrays;

import cnf.CNF;
import cnf.Disjunction;
import org.junit.Assert;
import org.junit.Test;
import reader.SatToArray;

public class SatToArrayTest {
    @Test
    public void test1() {
        CNF cnf = new CNF(new Disjunction(1, -2, 3), new Disjunction(-1, 2, 3));
        Assert.assertTrue(ArraysSat.solve(SatToArray.convert(cnf)));
    }

    @Test
    public void unsat1() {
        CNF cnf = new CNF(new Disjunction(1), new Disjunction(-1));
        Assert.assertFalse(ArraysSat.solve(SatToArray.convert(cnf)));
    }

    @Test
    public void unsat2() {
        CNF cnf = new CNF(new Disjunction(1, 2), new Disjunction(1, -2), new Disjunction(-1, 2), new Disjunction(-1, -2));
        Assert.assertFalse(ArraysSat.solve(SatToArray.convert(cnf)));
    }

    @Test
    public void sat1() {
        CNF cnf = new CNF(new Disjunction(1), new Disjunction(-1, 2));
        Assert.assertTrue(ArraysSat.solve(SatToArray.convert(cnf)));
    }
}
