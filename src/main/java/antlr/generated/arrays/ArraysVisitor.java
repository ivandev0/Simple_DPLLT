// Generated from E:/!PROJECTS/IntelliJ_IDEA/dpllt/src/main/java/antlr\Arrays.g4 by ANTLR 4.7.2
package antlr.generated.arrays;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ArraysParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ArraysVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code conjunction}
	 * labeled alternative in {@link ArraysParser}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConjunction(ArraysParser.ConjunctionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code function}
	 * labeled alternative in {@link ArraysParser}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(ArraysParser.FunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArraysParser#equality}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEquality(ArraysParser.EqualityContext ctx);
	/**
	 * Visit a parse tree produced by the {@code select}
	 * labeled alternative in {@link ArraysParser#fun}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelect(ArraysParser.SelectContext ctx);
	/**
	 * Visit a parse tree produced by the {@code store}
	 * labeled alternative in {@link ArraysParser#fun}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStore(ArraysParser.StoreContext ctx);
	/**
	 * Visit a parse tree produced by the {@code simpleName}
	 * labeled alternative in {@link ArraysParser#fun}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleName(ArraysParser.SimpleNameContext ctx);
}