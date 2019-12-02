package common;

import arrays.ArraysSymbol;
import base.Symbol;
import euf.FunctionSymbol;

import java.util.List;
import java.util.stream.Collectors;

public class CommonSymbol extends Symbol<CommonSymbol> {
    private Kind kind;

    public CommonSymbol(String name, List<CommonSymbol> args, Kind kind) {
        super(name, args);
        this.kind = kind;
    }

    public Kind getKind() {
        return kind;
    }

    @Override
    public CommonSymbol copy() {
        return new CommonSymbol(name, args.stream().map(CommonSymbol::copy).collect(Collectors.toList()), kind);
    }

    public ArraysSymbol toArraysSymbol() {
        return new ArraysSymbol(name, args.stream().map(CommonSymbol::toArraysSymbol).collect(Collectors.toList()));
    }

    public FunctionSymbol toFunctionSymbol() {
        return new FunctionSymbol(name, args.stream().map(CommonSymbol::toFunctionSymbol).collect(Collectors.toList()));
    }

    public void purify(CommonFormula formula) {
        for (int i = 0; i < args.size(); i++) {
            CommonSymbol arg = args.get(i);
            if ((kind == Kind.EUF && arg.kind != Kind.EUF) ||
                    (kind == Kind.EUF && arg.kind == Kind.EUF && arg.getArgs().size() > 0) ||
                    (kind == Kind.ARRAYS && arg.kind != Kind.ARRAYS && arg.args.size() != 0)) {
                CommonSymbol tempVar = formula.nextVar(arg.toString());
                arg.purify(formula);
                formula.add(new CommonEquality(arg, tempVar, true));    // arg = newVar
                args.remove(i);
                args.add(i, tempVar);                                   // arg -> newVar
            }
        }
        args.forEach(it -> it.purify(formula));
    }
}
