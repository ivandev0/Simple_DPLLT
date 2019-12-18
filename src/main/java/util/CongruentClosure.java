package util;

import common.CommonEquality;
import common.CommonSymbol;
import common.Kind;
import euf.FunctionSymbol;

import java.util.*;

public class CongruentClosure {
    List<Set<FunctionSymbol>> closure;
    Set<FunctionSymbol> allSubTerms;

    public CongruentClosure(Set<FunctionSymbol> init) {
        allSubTerms = new HashSet<>(init);
        closure = new ArrayList<>();
        for (FunctionSymbol functionSymbol : init) {
            closure.add(new HashSet<FunctionSymbol>() {{
                add(functionSymbol);
            }});
        }
    }

    public void newAssociation(FunctionSymbol first, FunctionSymbol second) {
        if (first.equals(second)) return;
        if (closure.stream().anyMatch(it -> it.contains(first) && it.contains(second))) return;
        Set<FunctionSymbol> equals = new HashSet<>();
        if (closure.size() != 1) {
            closure.removeIf(it -> {
                boolean contains = it.contains(first);
                if (contains) equals.addAll(it);
                return contains;
            });
        }
        closure.forEach(it -> {
            if (it.contains(second)) {
                it.addAll(equals);
                propagation(it);
            }
        });

        union();
    }

    private void propagation(Set<FunctionSymbol> newSet) {
        List<Pair<FunctionSymbol, FunctionSymbol>> equalPairs = new ArrayList<>();
        for (FunctionSymbol functionSymbol1 : newSet) {
            for (FunctionSymbol functionSymbol2 : newSet) {
                if (functionSymbol1 != functionSymbol2) {
                    equalPairs.add(new Pair<>(functionSymbol1, functionSymbol2));
                }
            }
        }

        for (Set<FunctionSymbol> symbols : closure) {
            if (symbols != newSet) {
                Set<FunctionSymbol> newSymbols = new HashSet<>();
                for (FunctionSymbol symbol : symbols) {
                    for (Pair<FunctionSymbol, FunctionSymbol> equalPair : equalPairs) {
                        FunctionSymbol newSymbol = null;
                        if (symbol.contains(equalPair.getL())) {
                            newSymbol = symbol.replace(equalPair.getL(), equalPair.getR());
                        } else if (symbol.contains(equalPair.getR())) {
                            newSymbol = symbol.replace(equalPair.getR(), equalPair.getL());
                        }
                        if (newSymbol != null && allSubTerms.contains(newSymbol)) {
                            // add to symbols
                            newSymbols.add(newSymbol);
                        }
                    }
                }
                symbols.addAll(newSymbols);
            }
        }
    }

    private void union() {
        L:
        for (int i = 0; i < closure.size() - 1; i++) {
            Set<FunctionSymbol> functionSymbols1 = closure.get(i);
            for (int j = i + 1; j < closure.size(); j++) {
                Set<FunctionSymbol> functionSymbols2 = closure.get(j);
                if (functionSymbols1.stream().anyMatch(functionSymbols2::contains)) {
                    functionSymbols1.addAll(functionSymbols2);
                    closure.remove(functionSymbols2);
                    i--;
                    continue L;
                }
            }
        }

    }

    public boolean symbolsAreEqual(FunctionSymbol first, FunctionSymbol second) {
        return closure.stream().anyMatch(it -> it.contains(first) && it.contains(second));
    }

    public List<CommonEquality> getAllCommon(List<FunctionSymbol> singleLiteralSymbols) {
        List<CommonEquality> pairs = new ArrayList<>();
        for (Set<FunctionSymbol> symbols : closure) {
            for (FunctionSymbol functionSymbol1 : symbols) {
                for (FunctionSymbol functionSymbol2 : symbols) {
                    if (functionSymbol1 != functionSymbol2 &&
                            singleLiteralSymbols.contains(functionSymbol1) &&
                            singleLiteralSymbols.contains(functionSymbol2)
                    ) {
                        CommonSymbol left = new CommonSymbol(functionSymbol1.getName(), new ArrayList<>(), Kind.EUF);
                        CommonSymbol right = new CommonSymbol(functionSymbol2.getName(), new ArrayList<>(), Kind.EUF);
                        pairs.add(new CommonEquality(left, right, true));
                    }
                }
            }
        }

        return pairs;
    }
}

class Pair<L, R> {
    private L l;
    private R r;

    public Pair(L l, R r) {
        this.l = l;
        this.r = r;
    }

    public L getL() {
        return l;
    }

    public R getR() {
        return r;
    }

    public void setL(L l) {
        this.l = l;
    }

    public void setR(R r) {
        this.r = r;
    }
}