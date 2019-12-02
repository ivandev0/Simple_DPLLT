package common;

import base.Symbol;

import java.util.List;
import java.util.stream.Collectors;

public class CommonSymbol extends Symbol<CommonSymbol> {
    public CommonSymbol(String name, List<CommonSymbol> args) {
        super(name, args);
    }

    @Override
    public CommonSymbol copy() {
        return new CommonSymbol(name, args.stream().map(CommonSymbol::copy).collect(Collectors.toList()));
    }
}
