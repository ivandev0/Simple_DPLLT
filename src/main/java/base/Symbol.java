package base;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class Symbol<T extends Symbol<T>> {
    protected String name;
    protected List<T> args;

    public Symbol(String name, List<T> args) {
        this.name = name;
        this.args = args;
    }

    public abstract T copy();

    public String getName() {
        return name;
    }

    public List<T> getArgs() {
        return args;
    }

    public Set<T> getAllSubTerms() {
        Set<T> subTerms = new HashSet<>();
        subTerms.add((T) this);
        args.forEach(it -> subTerms.addAll(it.getAllSubTerms()));
        return subTerms;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Symbol<?> symbol = (Symbol<?>) o;
        return name.equals(symbol.name) &&
                Objects.equals(args, symbol.args);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, args);
    }

    @Override
    public String toString() {
        String argsCollect = args.stream().map(Symbol::toString).collect(Collectors.joining(","));
        if (args.size() != 0) {
            argsCollect = '(' + argsCollect + ')';
        }
        return name + argsCollect;
    }
}
