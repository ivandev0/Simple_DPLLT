package reader;

import antlr.generated.euf.FOLBaseVisitor;
import antlr.generated.euf.FOLLexer;
import antlr.generated.euf.FOLParser;
import euf.EUFEquality;
import euf.EUFFormula;
import euf.FunctionSymbol;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EUFReader {
    public static EUFFormula transform(String str) {
        CharStream inputStream = CharStreams.fromString(str);
        FOLLexer markupLexer = new FOLLexer(inputStream);
        CommonTokenStream commonTokenStream = new CommonTokenStream(markupLexer);
        FOLParser markupParser = new FOLParser(commonTokenStream);
        FormulaVisitor visitor = new FormulaVisitor();
        return visitor.parse(markupParser.formula());
    }

    private static class FormulaVisitor extends FOLBaseVisitor {
        EUFFormula formula = new EUFFormula();

        EUFFormula parse(FOLParser.FormulaContext ctx) {
            visit(ctx);
            return formula;
        }

        @Override
        public Object visitFunction(FOLParser.FunctionContext ctx) {
            formula.add(visitEquality(ctx.equality()));
            return super.visitFunction(ctx);
        }

        @Override
        public Object visitConjunction(FOLParser.ConjunctionContext ctx) {
            formula.add(visitEquality(ctx.equality()));
            return super.visitConjunction(ctx);
        }

        @Override
        public EUFEquality visitEquality(FOLParser.EqualityContext ctx) {
            boolean isEqual = ctx.children.get(1).toString().equals("=");
            return new EUFEquality(visitFun(ctx.fun(0)), visitFun(ctx.fun(1)), isEqual);
        }

        @Override
        public FunctionSymbol visitFun(FOLParser.FunContext ctx) {
            return new FunctionSymbol(ctx.IDENTIFIER().toString(), visitArgs(ctx.args()));
        }

        @Override
        public List<FunctionSymbol> visitArgs(FOLParser.ArgsContext ctx) {
            if (ctx == null) return new ArrayList<>();
            return ctx.fun()
                    .stream()
                    .map(this::visitFun)
                    .collect(Collectors.toList());
        }
    }
}
