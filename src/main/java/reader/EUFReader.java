package reader;

import antlr.generated.FOLLexer;
import antlr.generated.FOLParser;
import euf.Formula;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public class EUFReader {
    public static Formula transform(String str) {
        CharStream inputStream = CharStreams.fromString(str);
        FOLLexer markupLexer = new FOLLexer(inputStream);
        CommonTokenStream commonTokenStream = new CommonTokenStream(markupLexer);
        FOLParser markupParser = new FOLParser(commonTokenStream);
        FormulaVisitor visitor = new FormulaVisitor();
        return visitor.parse(markupParser.formula());
    }
}
