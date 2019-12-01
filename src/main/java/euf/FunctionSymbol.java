package euf;

import base.Symbol;

import java.util.*;
import java.util.stream.Collectors;

public class FunctionSymbol extends Symbol<FunctionSymbol> {
    public FunctionSymbol(String name, List<FunctionSymbol> args) {
        super(name, args);
    }

    @Override
    public FunctionSymbol copy() {
        return new FunctionSymbol(name, args.stream().map(FunctionSymbol::copy).collect(Collectors.toList()));
    }

    public boolean contains(FunctionSymbol symbol) {
        return getAllSubTerms().contains(symbol);
    }

    public FunctionSymbol replace(FunctionSymbol oldSymbol, FunctionSymbol newSymbol) {
        if (oldSymbol.name.equals(name)) return newSymbol;
        List<FunctionSymbol> newArgs = new ArrayList<>();
        for (FunctionSymbol arg : args) {
            if (arg.contains(oldSymbol)) {
                newArgs.add(arg.replace(oldSymbol, newSymbol));
            } else {
                newArgs.add(arg);
            }
        }
        return new FunctionSymbol(name, newArgs);
    }
}
