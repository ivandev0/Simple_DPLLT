package arrays;

import org.junit.Assert;
import org.junit.Test;
import reader.ArraysReader;

public class ArraysSatTest {
    @Test
    public void solve1() {
        Assert.assertFalse(
                ArraysSat.solve(
                        ArraysReader.transform(
                                "x1 = y ^ x1 != x2 ^ select(A, y) = v1 ^ select(store(store(A, x1, v1), x2, v2), y) != select(A, y)")));
    }

    @Test
    public void solve2() {
        Assert.assertTrue(ArraysSat.solve(ArraysReader.transform("x = y ^ select(A, y) = select(A, x)")));
    }

    @Test
    public void solve3() {
        Assert.assertTrue(ArraysSat.solve(ArraysReader.transform("x != y ^ select(A, y) = select(A, x)")));
    }
}
