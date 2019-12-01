package reader;

import euf.Formula;
import org.junit.Test;

public class EUFReaderTest {
    @Test
    public void test() {
        Formula actual = EUFReader.transform("f(n) = a ^ b = d(s(a, b), e) ^ b != f(n)");
        System.out.println(actual);
    }
}
