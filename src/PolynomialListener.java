// Generated from java-escape by ANTLR 4.11.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PolynomialParser}.
 */
public interface PolynomialListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PolynomialParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(PolynomialParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link PolynomialParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(PolynomialParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link PolynomialParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(PolynomialParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PolynomialParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(PolynomialParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PolynomialExpr}
	 * labeled alternative in {@link PolynomialParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterPolynomialExpr(PolynomialParser.PolynomialExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PolynomialExpr}
	 * labeled alternative in {@link PolynomialParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitPolynomialExpr(PolynomialParser.PolynomialExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NumExpr}
	 * labeled alternative in {@link PolynomialParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNumExpr(PolynomialParser.NumExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NumExpr}
	 * labeled alternative in {@link PolynomialParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNumExpr(PolynomialParser.NumExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MulDivModExpr}
	 * labeled alternative in {@link PolynomialParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMulDivModExpr(PolynomialParser.MulDivModExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MulDivModExpr}
	 * labeled alternative in {@link PolynomialParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMulDivModExpr(PolynomialParser.MulDivModExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EvalExpr}
	 * labeled alternative in {@link PolynomialParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterEvalExpr(PolynomialParser.EvalExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EvalExpr}
	 * labeled alternative in {@link PolynomialParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitEvalExpr(PolynomialParser.EvalExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VarExpr}
	 * labeled alternative in {@link PolynomialParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterVarExpr(PolynomialParser.VarExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VarExpr}
	 * labeled alternative in {@link PolynomialParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitVarExpr(PolynomialParser.VarExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ParenExpr}
	 * labeled alternative in {@link PolynomialParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParenExpr(PolynomialParser.ParenExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ParenExpr}
	 * labeled alternative in {@link PolynomialParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParenExpr(PolynomialParser.ParenExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AddSubExpr}
	 * labeled alternative in {@link PolynomialParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAddSubExpr(PolynomialParser.AddSubExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AddSubExpr}
	 * labeled alternative in {@link PolynomialParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAddSubExpr(PolynomialParser.AddSubExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link PolynomialParser#polynomial}.
	 * @param ctx the parse tree
	 */
	void enterPolynomial(PolynomialParser.PolynomialContext ctx);
	/**
	 * Exit a parse tree produced by {@link PolynomialParser#polynomial}.
	 * @param ctx the parse tree
	 */
	void exitPolynomial(PolynomialParser.PolynomialContext ctx);
	/**
	 * Enter a parse tree produced by {@link PolynomialParser#polyTerm}.
	 * @param ctx the parse tree
	 */
	void enterPolyTerm(PolynomialParser.PolyTermContext ctx);
	/**
	 * Exit a parse tree produced by {@link PolynomialParser#polyTerm}.
	 * @param ctx the parse tree
	 */
	void exitPolyTerm(PolynomialParser.PolyTermContext ctx);
}