// Generated from E:/!PROJECTS/IntelliJ_IDEA/dpllt/src/main/java/antlr\EUF.g4 by ANTLR 4.7.2
package antlr.generated.euf;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link EUFParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface EUFVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code conjunction}
	 * labeled alternative in {@link EUFParser}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConjunction(EUFParser.ConjunctionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code function}
	 * labeled alternative in {@link EUFParser}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(EUFParser.FunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link EUFParser#equality}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEquality(EUFParser.EqualityContext ctx);
	/**
	 * Visit a parse tree produced by {@link EUFParser#fun}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFun(EUFParser.FunContext ctx);
	/**
	 * Visit a parse tree produced by {@link EUFParser#args}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgs(EUFParser.ArgsContext ctx);
}