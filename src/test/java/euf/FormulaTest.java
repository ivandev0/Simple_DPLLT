package euf;

import org.junit.Test;
import reader.EUFReader;

public class FormulaTest {
    @Test
    public void testSubTermsMethod() {
        EUFFormula actual = EUFReader.transform("f(n) = a ^ g(a, b) = b ^ h(g(a, b), b) != d");
        System.out.println(actual.getAllSubTerms());
    }
}