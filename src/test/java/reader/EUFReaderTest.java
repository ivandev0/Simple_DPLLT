package reader;

import euf.EUFFormula;
import org.junit.Test;

public class EUFReaderTest {
    @Test
    public void test() {
        EUFFormula actual = EUFReader.transform("f(n) = a ^ b = d(s(a, b), e) ^ b != f(n)");
        System.out.println(actual);
    }
}
