// Generated from E:/!PROJECTS/IntelliJ_IDEA/dpllt/src/main/java/antlr\FOL.g4 by ANTLR 4.7.2
package antlr.generated;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link FOLParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface FOLVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code conjunction}
	 * labeled alternative in {@link FOLParser}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConjunction(FOLParser.ConjunctionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code function}
	 * labeled alternative in {@link FOLParser}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(FOLParser.FunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link FOLParser#equality}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEquality(FOLParser.EqualityContext ctx);
	/**
	 * Visit a parse tree produced by {@link FOLParser#fun}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFun(FOLParser.FunContext ctx);
	/**
	 * Visit a parse tree produced by {@link FOLParser#args}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgs(FOLParser.ArgsContext ctx);
}