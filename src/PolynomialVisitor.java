// Generated from java-escape by ANTLR 4.11.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link PolynomialParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface PolynomialVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link PolynomialParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(PolynomialParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link PolynomialParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(PolynomialParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PolynomialExpr}
	 * labeled alternative in {@link PolynomialParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPolynomialExpr(PolynomialParser.PolynomialExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NumExpr}
	 * labeled alternative in {@link PolynomialParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumExpr(PolynomialParser.NumExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MulDivModExpr}
	 * labeled alternative in {@link PolynomialParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulDivModExpr(PolynomialParser.MulDivModExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EvalExpr}
	 * labeled alternative in {@link PolynomialParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEvalExpr(PolynomialParser.EvalExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VarExpr}
	 * labeled alternative in {@link PolynomialParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarExpr(PolynomialParser.VarExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ParenExpr}
	 * labeled alternative in {@link PolynomialParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenExpr(PolynomialParser.ParenExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AddSubExpr}
	 * labeled alternative in {@link PolynomialParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddSubExpr(PolynomialParser.AddSubExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PolynomialParser#polynomial}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPolynomial(PolynomialParser.PolynomialContext ctx);
	/**
	 * Visit a parse tree produced by {@link PolynomialParser#polyTerm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPolyTerm(PolynomialParser.PolyTermContext ctx);
}