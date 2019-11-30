package reader;

import euf.Formula;
import org.junit.Test;

public class EUFReaderTest {
    @Test
    public void test() {
        Formula equalities = EUFReader.transform("f(d) = a ^ b = d(s, e)");
        System.out.println(equalities);
    }
}
