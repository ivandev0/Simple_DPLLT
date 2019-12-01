package euf;

import java.util.List;
import java.util.stream.Collectors;

public class FunctionSymbol {
    private String name;
    private List<FunctionSymbol> args;

    public FunctionSymbol(String name, List<FunctionSymbol> args) {
        this.name = name;
        this.args = args;
    }

    public String getName() {
        return name;
    }

    public List<FunctionSymbol> getArgs() {
        return args;
    }

    @Override
    public String toString() {
        String argsCollect = args.stream().map(FunctionSymbol::toString).collect(Collectors.joining(","));
        if (args.size() != 0) {
            argsCollect = '(' + argsCollect + ')';
        }
        return name + argsCollect;
    }
}
