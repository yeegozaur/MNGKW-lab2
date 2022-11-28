// Generated from java-escape by ANTLR 4.11.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CalculatorParser}.
 */
public interface CalculatorListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CalculatorParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(CalculatorParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(CalculatorParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculatorParser#multiplyingExpression}.
	 * @param ctx the parse tree
	 */
	void enterMultiplyingExpression(CalculatorParser.MultiplyingExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorParser#multiplyingExpression}.
	 * @param ctx the parse tree
	 */
	void exitMultiplyingExpression(CalculatorParser.MultiplyingExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculatorParser#powExpression}.
	 * @param ctx the parse tree
	 */
	void enterPowExpression(CalculatorParser.PowExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorParser#powExpression}.
	 * @param ctx the parse tree
	 */
	void exitPowExpression(CalculatorParser.PowExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculatorParser#floatExpresion}.
	 * @param ctx the parse tree
	 */
	void enterFloatExpresion(CalculatorParser.FloatExpresionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorParser#floatExpresion}.
	 * @param ctx the parse tree
	 */
	void exitFloatExpresion(CalculatorParser.FloatExpresionContext ctx);
}