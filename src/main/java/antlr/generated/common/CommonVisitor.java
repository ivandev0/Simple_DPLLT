// Generated from E:/!PROJECTS/IntelliJ_IDEA/dpllt/src/main/java/antlr\Common.g4 by ANTLR 4.7.2
package antlr.generated.common;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CommonParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CommonVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code not}
	 * labeled alternative in {@link CommonParser}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNot(CommonParser.NotContext ctx);
	/**
	 * Visit a parse tree produced by the {@code equivalence}
	 * labeled alternative in {@link CommonParser}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEquivalence(CommonParser.EquivalenceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code conjunction}
	 * labeled alternative in {@link CommonParser}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConjunction(CommonParser.ConjunctionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code disjunction}
	 * labeled alternative in {@link CommonParser}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDisjunction(CommonParser.DisjunctionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code implication}
	 * labeled alternative in {@link CommonParser}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImplication(CommonParser.ImplicationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code singleEquality}
	 * labeled alternative in {@link CommonParser}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleEquality(CommonParser.SingleEqualityContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenthesized}
	 * labeled alternative in {@link CommonParser}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesized(CommonParser.ParenthesizedContext ctx);
	/**
	 * Visit a parse tree produced by the {@code equal}
	 * labeled alternative in {@link CommonParser#equality}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqual(CommonParser.EqualContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notEqual}
	 * labeled alternative in {@link CommonParser#equality}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotEqual(CommonParser.NotEqualContext ctx);
	/**
	 * Visit a parse tree produced by the {@code simple}
	 * labeled alternative in {@link CommonParser#fun}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimple(CommonParser.SimpleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code funWithArgs}
	 * labeled alternative in {@link CommonParser#fun}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunWithArgs(CommonParser.FunWithArgsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code select}
	 * labeled alternative in {@link CommonParser#fun}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelect(CommonParser.SelectContext ctx);
	/**
	 * Visit a parse tree produced by the {@code store}
	 * labeled alternative in {@link CommonParser#fun}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStore(CommonParser.StoreContext ctx);
	/**
	 * Visit a parse tree produced by {@link CommonParser#args}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgs(CommonParser.ArgsContext ctx);
}