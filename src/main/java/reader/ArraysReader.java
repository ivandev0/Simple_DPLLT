package reader;

import antlr.generated.arrays.ArraysBaseVisitor;
import antlr.generated.arrays.ArraysLexer;
import antlr.generated.arrays.ArraysParser;
import arrays.ArraysEquality;
import arrays.ArraysFormula;
import arrays.ArraysSymbol;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.util.ArrayList;
import java.util.List;

public class ArraysReader {

    public static ArraysFormula transform(String str) {
        CharStream inputStream = CharStreams.fromString(str);
        ArraysLexer markupLexer = new ArraysLexer(inputStream);
        CommonTokenStream commonTokenStream = new CommonTokenStream(markupLexer);
        ArraysParser markupParser = new ArraysParser(commonTokenStream);
        FormulaVisitor visitor = new FormulaVisitor();
        return visitor.parse(markupParser.formula());
    }

    private static class FormulaVisitor extends ArraysBaseVisitor {
        ArraysFormula formula = new ArraysFormula();

        public ArraysFormula parse(ArraysParser.FormulaContext ctx) {
            visit(ctx);
            return formula;
        }

        @Override
        public Object visitFunction(ArraysParser.FunctionContext ctx) {
            formula.add(visitEquality(ctx.equality()));
            return super.visitFunction(ctx);
        }

        @Override
        public Object visitConjunction(ArraysParser.ConjunctionContext ctx) {
            formula.add(visitEquality(ctx.equality()));
            return super.visitConjunction(ctx);
        }

        @Override
        public ArraysEquality visitEquality(ArraysParser.EqualityContext ctx) {
            boolean isEqual = ctx.children.get(1).toString().equals("=");
            ArraysSymbol left = (ArraysSymbol) ctx.fun(0).accept(this);
            ArraysSymbol right = (ArraysSymbol) ctx.fun(1).accept(this);
            return new ArraysEquality(left, right, isEqual);
        }

        @Override
        public ArraysSymbol visitStore(ArraysParser.StoreContext ctx) {
            List<ArraysSymbol> args = new ArrayList<>();
            args.add((ArraysSymbol) ctx.fun(0).accept(this));
            args.add((ArraysSymbol) ctx.fun(1).accept(this));
            args.add((ArraysSymbol) ctx.fun(2).accept(this));
            return new ArraysSymbol("store", args);
        }

        @Override
        public ArraysSymbol visitSelect(ArraysParser.SelectContext ctx) {
            List<ArraysSymbol> args = new ArrayList<>();
            args.add((ArraysSymbol) ctx.fun(0).accept(this));
            args.add((ArraysSymbol) ctx.fun(1).accept(this));
            return new ArraysSymbol("select", args);
        }

        @Override
        public ArraysSymbol visitSimpleName(ArraysParser.SimpleNameContext ctx) {
            return new ArraysSymbol(ctx.IDENTIFIER().toString(), new ArrayList<>());
        }
    }
}
