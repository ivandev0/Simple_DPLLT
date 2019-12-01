package arrays;

import euf.FunctionSymbol;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ArraysSymbol {
    private String name;
    private List<ArraysSymbol> args;

    public ArraysSymbol(String name, List<ArraysSymbol> args) {
        this.name = name;
        this.args = args;
    }

    public ArraysSymbol(ArraysSymbol symbol) {
        this.name = symbol.name;
        this.args = symbol.args.stream().map(ArraysSymbol::new).collect(Collectors.toList());
    }

    public String getName() {
        return name;
    }

    public List<ArraysSymbol> getArgs() {
        return args;
    }

    public Set<ArraysSymbol> getAllSubTerms() {
        Set<ArraysSymbol> subTerms = new HashSet<>();
        subTerms.add(this);
        args.forEach(it -> subTerms.addAll(it.getAllSubTerms()));
        return subTerms;
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

    @Override
    public String toString() {
        String argsCollect = args.stream().map(ArraysSymbol::toString).collect(Collectors.joining(","));
        if (args.size() != 0) {
            argsCollect = '(' + argsCollect + ')';
        }
        return name + argsCollect;
    }
}
