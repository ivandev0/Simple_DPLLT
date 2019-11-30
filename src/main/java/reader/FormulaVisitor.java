package reader;

import antlr.generated.FOLBaseVisitor;
import antlr.generated.FOLParser;
import euf.Equality;
import euf.Formula;
import euf.FunctionSymbol;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FormulaVisitor extends FOLBaseVisitor {
    Formula formula = new Formula();

    Formula parse(FOLParser.FormulaContext ctx) {
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
    public Equality visitEquality(FOLParser.EqualityContext ctx) {
        boolean isEqual = ctx.children.get(1).toString().equals("=");
        return new Equality(visitFun(ctx.fun(0)), visitFun(ctx.fun(1)), isEqual);
    }

    @Override
    public FunctionSymbol visitFun(FOLParser.FunContext ctx) {
        return new FunctionSymbol(ctx.IDENTIFIER().toString(), visitArgs(ctx.args()));
    }

    @Override
    public List<String> visitArgs(FOLParser.ArgsContext ctx) {
        if (ctx == null) return new ArrayList<>();
        return ctx.IDENTIFIER()
                .stream()
                .map(Object::toString)
                .collect(Collectors.toList());
    }
}
