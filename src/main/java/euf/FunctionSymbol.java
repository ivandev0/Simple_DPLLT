package euf;

import java.util.List;
import java.util.stream.Collectors;

public class FunctionSymbol {
    private String name;
    private List<String> args;

    public FunctionSymbol(String name, List<String> args) {
        this.name = name;
        this.args = args;
    }

    public String getName() {
        return name;
    }

    public List<String> getArgs() {
        return args;
    }

    @Override
    public String toString() {
        String argsCollect = args.stream().collect(Collectors.joining(","));
        if (args.size() != 0) {
            argsCollect = '(' + argsCollect + ')';
        }
        return name + argsCollect;
    }
}
