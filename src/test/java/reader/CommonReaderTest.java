package reader;

import org.junit.Test;

import static org.junit.Assert.*;

public class CommonReaderTest {

    @Test
    public void transform() {
        System.out.println(CommonReader.transform("f(a) = d ^ b = c v (d != e ^ f(a) != d)").getCnf());
    }
}