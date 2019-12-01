package arrays;

import base.Symbol;
import euf.FunctionSymbol;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ArraysSymbol extends Symbol<ArraysSymbol> {
    public ArraysSymbol(String name, List<ArraysSymbol> args) {
        super(name, args);
    }

    @Override
    public ArraysSymbol copy() {
        return new ArraysSymbol(name, args.stream().map(ArraysSymbol::copy).collect(Collectors.toList()));
    }

    public FunctionSymbol toEUF() {
        if (name.equals("store")) {
            throw new UnsupportedOperationException("Can't convert array symbol to function symbol");
        } else if (name.equals("select")) {
            List<FunctionSymbol> newArgs = new ArrayList<>();
            newArgs.add(args.get(1).toEUF());
            return new FunctionSymbol(args.get(0).toString().trim().toUpperCase(), newArgs);
        } else {
            return new FunctionSymbol(name, new ArrayList<>());
        }
    }

    public void replaceInPlaceByX1(ArraysFormula formula) {
        if (name.equals("select")) {
            ArraysSymbol firstArg = args.get(0);
            if (firstArg.name.equals("store")) {
                formula.add(new ArraysEquality(firstArg.getArgs().get(1), args.get(1), true));
                name = firstArg.getArgs().get(2).name;
                args = new ArrayList<>();
            }
        }
        args.forEach(it -> it.replaceInPlaceByX1(formula));
    }

    public void replaceInPlaceByX2(ArraysFormula formula) {
        if (name.equals("select")) {
            ArraysSymbol firstArg = args.get(0);
            if (firstArg.name.equals("store")) {
                formula.add(new ArraysEquality(firstArg.getArgs().get(1), args.get(1), false));
                ArraysSymbol array = firstArg.getArgs().get(0);
                args.remove(firstArg);
                args.add(0, array);
            }
        }
        args.forEach(it -> it.replaceInPlaceByX1(formula));
    }
}
