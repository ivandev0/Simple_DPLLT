package arrays;

import cnf.CNF;
import org.junit.Assert;
import org.junit.Test;
import reader.DimacsReader;
import reader.SatToArray;

import java.io.File;
import java.io.IOException;

public class CliqueSat {
    private String dataFolder = "clique/k2";

    private void basicTest(String fileName, boolean mustBeUnsat) throws IOException {
        CNF cnf = DimacsReader.readFromFile(new File(Thread.currentThread().getContextClassLoader().getResource(dataFolder + "/" + fileName).getFile()));

        boolean sat = ArraysSat.solve(SatToArray.convert(cnf));
        if (mustBeUnsat){
            Assert.assertTrue(sat);
        } else {
            Assert.assertFalse(sat);
        }
    }

    @Test
    public void testN3K2() throws IOException {
        basicTest("cnf_n3_k2", false);
    }

    @Test
    public void testN4K2() throws IOException {
        basicTest("cnf_n4_k2", false);
    }

    @Test
    public void testN5K2() throws IOException {
        basicTest("cnf_n5_k2", false);
    }

    @Test
    public void testN6K2() throws IOException {
        basicTest("cnf_n6_k2", true);
    }
}
