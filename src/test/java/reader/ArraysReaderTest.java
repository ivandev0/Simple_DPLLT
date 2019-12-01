package reader;

import arrays.ArraysFormula;
import org.junit.Test;

public class ArraysReaderTest {
    @Test
    public void test() {
        ArraysFormula actual = ArraysReader.transform("select(store(B, z, w), y) != v ^ select(A,select(A,select(A,select(A,select(A, x))))) = x");
        System.out.println(actual);
    }
}
