package reader;

import arrays.ArraysEquality;
import arrays.ArraysFormula;
import arrays.ArraysSymbol;
import cnf.CNF;
import cnf.Disjunction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SatToArray {
    private static ArraysSymbol array = new ArraysSymbol("<array>", Collections.emptyList());

    public static ArraysFormula convert(CNF cnf) {
        ArraysFormula arraysFormula = new ArraysFormula();
        List<Disjunction> allDisjunctions = cnf.getAllDisjunctions();

        ArraysSymbol test = new ArraysSymbol("T", Collections.emptyList());
        ArraysSymbol trueSymbol = new ArraysSymbol("Y", Collections.emptyList());
        ArraysSymbol falseSymbol = new ArraysSymbol("N", Collections.emptyList());
        ArraysSymbol zero = new ArraysSymbol("0", Collections.emptyList());
        ArraysSymbol one = new ArraysSymbol("1", Collections.emptyList());
        arraysFormula.add(new ArraysEquality(zero, one, false));
        arraysFormula.add(new ArraysEquality(trueSymbol, falseSymbol, false));

        List<ArraysEquality> cEqualities = new ArrayList<>();
        for (int i = 0; i < allDisjunctions.size(); i++) {
            Disjunction disjunction = allDisjunctions.get(i);
            Integer[] disjunctionValues = disjunction.values.toArray(new Integer[0]);
            String literalName = disjunctionValues[0] > 0 ? "A_" : "B_";
            ArraysSymbol literalSymbol = new ArraysSymbol(literalName + Math.abs(disjunctionValues[0]), Collections.emptyList());
            ArraysSymbol cSymbol = ifThenElse(literalSymbol, test, trueSymbol, falseSymbol);

            for (int j = 1; j < disjunctionValues.length; j++) {
                literalName = disjunctionValues[j] > 0 ? "A_" : "B_";
                literalSymbol = new ArraysSymbol(literalName + Math.abs(disjunctionValues[j]), Collections.emptyList());
                cSymbol = ifThenElse(literalSymbol, test, trueSymbol, cSymbol);
            }

            cEqualities.add(new ArraysEquality(new ArraysSymbol("C_" + i, Collections.emptyList()), cSymbol, true));
        }

        ArraysSymbol d = new ArraysSymbol("D", Collections.emptyList());
        ArraysSymbol dSymbol = null;
        for (int i = 0; i < cEqualities.size(); i++) {
            ArraysEquality cEquality = cEqualities.get(i);
            dSymbol = ifThenElse(cEquality.getLeft(), falseSymbol, zero, i == 0 ? one : dSymbol);
        }

        for (Integer atom : cnf.getAtoms()) {
            ArraysSymbol aSymbol = new ArraysSymbol("A_" + atom, Collections.emptyList());
            ArraysSymbol bSymbol = new ArraysSymbol("B_" + atom, Collections.emptyList());

            dSymbol = ifThenElse(aSymbol, bSymbol, zero, dSymbol);
        }

        cEqualities.forEach(arraysFormula::add);
        arraysFormula.add(new ArraysEquality(d, dSymbol, true));
        arraysFormula.add(new ArraysEquality(d, one, true));
        return arraysFormula;
    }

    private static ArraysSymbol ifThenElse(ArraysSymbol a, ArraysSymbol b, ArraysSymbol c, ArraysSymbol d) {
        List<ArraysSymbol> innerStoreArgs = new ArrayList<ArraysSymbol>() {{
            add(array);
            add(a);
            add(d);
        }};

        List<ArraysSymbol> outerStoreArgs = new ArrayList<ArraysSymbol>() {{
            add(new ArraysSymbol("store", innerStoreArgs));
            add(b);
            add(c);
        }};

        List<ArraysSymbol> selectArgs = new ArrayList<ArraysSymbol>() {{
            add(new ArraysSymbol("store", outerStoreArgs));
            add(a);
        }};

        return new ArraysSymbol("select", selectArgs);
    }
}
