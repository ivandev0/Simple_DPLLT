package arrays;

import euf.FunctionSymbol;

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

    @Override
    public String toString() {
        String argsCollect = args.stream().map(ArraysSymbol::toString).collect(Collectors.joining(","));
        if (args.size() != 0) {
            argsCollect = '(' + argsCollect + ')';
        }
        return name + argsCollect;
    }
}
