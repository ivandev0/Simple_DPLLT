package reader;

import antlr.generated.common.CommonBaseVisitor;
import antlr.generated.common.CommonLexer;
import antlr.generated.common.CommonParser;
import common.CommonEquality;
import common.CommonFormula;
import common.CommonSymbol;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.TerminalNode;
import tseytin.TseytinTransformation;
import util.IDPool;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommonReader {
    public static CommonFormula transform(String str) {
        CharStream inputStream = CharStreams.fromString(str);
        CommonLexer markupLexer = new CommonLexer(inputStream);
        CommonTokenStream commonTokenStream = new CommonTokenStream(markupLexer);
        CommonParser markupParser = new CommonParser(commonTokenStream);

        Map<CommonEquality, Integer> pool = new HashMap<>();
        CommonReader.FormulaVisitor visitor = new CommonReader.FormulaVisitor(pool);
        String cnfString = visitor.parse(markupParser.formula());

        IDPool idPool = new IDPool();
        for (int i = 1; i <= pool.size(); i++) {
            idPool.idByName("tmp" + i);
        }
        return new CommonFormula(TseytinTransformation.transform(cnfString, idPool), pool);
    }

    private static class FormulaVisitor extends CommonBaseVisitor {
        Map<CommonEquality, Integer> pool;
        private StringBuilder sb = new StringBuilder();

        public FormulaVisitor(Map<CommonEquality, Integer> pool) {
            this.pool = pool;
        }

        public String parse(CommonParser.FormulaContext ctx) {
            visit(ctx);
            return sb.toString();
        }

        @Override
        public Object visitSingleEquality(CommonParser.SingleEqualityContext ctx) {
            CommonEquality equality = (CommonEquality) ctx.equality().accept(this);
            CommonEquality notEquality = (CommonEquality) equality.inverse();
            String prefix;
            int num;
            if (pool.containsKey(equality)) {
                prefix = "";
                num = pool.get(equality);
            } else if (pool.containsKey(notEquality)) {
                prefix = "!";
                num = pool.get(notEquality);
            } else {
                prefix = equality.isEqual() ? "" : "!";
                num = pool.size() + 1;
                pool.put(equality, num);
            }
            sb.append(prefix).append("tmp").append(num);

            return null;
        }

        @Override
        public CommonEquality visitEqual(CommonParser.EqualContext ctx) {
            CommonSymbol left = (CommonSymbol) ctx.fun(0).accept(this);
            CommonSymbol right = (CommonSymbol) ctx.fun(1).accept(this);
            return new CommonEquality(left, right, true);
        }

        @Override
        public Object visitNotEqual(CommonParser.NotEqualContext ctx) {
            CommonSymbol left = (CommonSymbol) ctx.fun(0).accept(this);
            CommonSymbol right = (CommonSymbol) ctx.fun(1).accept(this);
            return new CommonEquality(left, right, false);
        }

        @Override
        public CommonSymbol visitSimple(CommonParser.SimpleContext ctx) {
            return new CommonSymbol(ctx.IDENTIFIER().toString(), new ArrayList<>());
        }

        @Override
        public CommonSymbol visitFunWithArgs(CommonParser.FunWithArgsContext ctx) {
            return new CommonSymbol(ctx.IDENTIFIER().toString(), visitArgs(ctx.args()));
        }

        @Override
        public CommonSymbol visitSelect(CommonParser.SelectContext ctx) {
            List<CommonSymbol> args = new ArrayList<>();
            args.add((CommonSymbol) ctx.fun(0).accept(this));
            args.add((CommonSymbol) ctx.fun(1).accept(this));
            return new CommonSymbol("select", args);
        }

        @Override
        public CommonSymbol visitStore(CommonParser.StoreContext ctx) {
            List<CommonSymbol> args = new ArrayList<>();
            args.add((CommonSymbol) ctx.fun(0).accept(this));
            args.add((CommonSymbol) ctx.fun(1).accept(this));
            args.add((CommonSymbol) ctx.fun(2).accept(this));
            return new CommonSymbol("store", args);
        }

        @Override
        public List<CommonSymbol> visitArgs(CommonParser.ArgsContext ctx) {
            List<CommonSymbol> list = new ArrayList<>();
            for (CommonParser.FunContext it : ctx.fun()) {
                CommonSymbol accept = (CommonSymbol) it.accept(this);
                list.add(accept);
            }
            return list;
        }

        @Override
        public Object visitTerminal(TerminalNode node) {
            sb.append(" ").append(node.toString()).append(" ");
            return super.visitTerminal(node);
        }
    }
}
