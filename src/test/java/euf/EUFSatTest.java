package euf;

import org.junit.Assert;
import org.junit.Test;
import reader.EUFReader;

import static org.junit.Assert.*;

public class EUFSatTest {
    @Test
    public void solve1() {
        boolean isSat = EUFSat.solve(EUFReader.transform("f(a, b) = a ^ f(f(a, b), b) != a"));
        Assert.assertFalse(isSat);
    }

    @Test
    public void solve2() {
        boolean isSat = EUFSat.solve(EUFReader.transform("f(a) = f(b) ^ a != b"));
        Assert.assertTrue(isSat);
    }

    @Test
    public void solve3() {
        boolean isSat = EUFSat.solve(EUFReader.transform("g(g(g(x))) = x ^ g(g(g(g(g(x))))) = x ^ g(x) != x"));
        Assert.assertFalse(isSat);
    }

    @Test
    public void solve4() {
        boolean isSat = EUFSat.solve(EUFReader.transform("a = b ^ b = c ^ f(a) != f(c)"));
        Assert.assertFalse(isSat);
    }

    @Test
    public void solve5() {
        boolean isSat = EUFSat.solve(EUFReader.transform("a = b ^ f(f(a)) != f(f(c))"));
        Assert.assertTrue(isSat);
    }
}