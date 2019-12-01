package euf;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
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

    public Set<FunctionSymbol> getAllSubTerms() {
        Set<FunctionSymbol> subTerms = new HashSet<>();
        subTerms.add(this);
        args.forEach(it -> subTerms.addAll(it.getAllSubTerms()));
        return subTerms;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FunctionSymbol that = (FunctionSymbol) o;
        return name.equals(that.name) &&
                Objects.equals(args, that.args);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, args);
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
