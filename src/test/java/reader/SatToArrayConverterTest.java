package reader;

import cnf.CNF;
import cnf.Disjunction;
import org.junit.Test;

import static org.junit.Assert.*;

public class SatToArrayConverterTest {

    @Test
    public void convert() {
        CNF cnf = new CNF(new Disjunction(1, -2, 3), new Disjunction(-1, 2, 3));
        System.out.println(SatToArray.convert(cnf));
    }
}