import java.util.Stack;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class Calculator extends CalculatorBaseListener {
    private final Stack<Double> stack = new Stack<>();

    public Double getResult() {
        return stack.pop();
    }

    @Override
    public void exitExpression(CalculatorParser.ExpressionContext ctx) {
        Double result = stack.pop();
        for (int i = 1; i < ctx.getChildCount(); i = i + 2) {
            if (symbolEquals(ctx.getChild(i), CalculatorParser.PLUS)) {
                result += stack.pop();
            } else {
                result -= stack.pop();
            }
        }
        stack.push(result);
        System.out.println("Expression: \"" + ctx.getText() + "\" -> "+result);
    }


    @Override
    public void exitMultiplyingExpression(CalculatorParser.MultiplyingExpressionContext ctx) {
        Double result = stack.pop();
        for (int i = ctx.getChildCount() - 2; i >= 1; i = i - 2) {
            if (symbolEquals(ctx.getChild(i), CalculatorParser.TIMES)) {
                result = stack.pop() * result;
            } else {
                result = stack.pop() / result;
            }
        }
        stack.push(result);
        System.out.println("MultiplyingExpression: \"" + ctx.getText() + "\" -> "+result);
    }

    private boolean symbolEquals(ParseTree child, double symbol) {
        return ((TerminalNode) child).getSymbol().getType() == symbol;
    }

    @Override public void exitPowExpression(CalculatorParser.PowExpressionContext ctx) {
        Double result = stack.pop();
        for (int i = ctx.getChildCount() - 2; i >= 1; i = i - 2) {
            if (symbolEquals(ctx.getChild(i), CalculatorParser.POW)) {
                result = Math.pow(stack.pop(), result);
            }else if(symbolEquals(ctx.getChild(i), CalculatorParser.SQRT)){
                result = Math.pow(stack.pop(), 1/ result);
            }
        }
        stack.push(result);
        System.out.println("powExpression: \"" + ctx.getText() + "\" -> "+result);
    }

    @Override public void exitFloatExpresion(CalculatorParser.FloatExpresionContext ctx) {
        double value = Double.valueOf(ctx.FLOAT().getText());
        if (ctx.FLOAT() != null) {
            if(ctx.MINUS() != null){
                stack.push(-1 * value);
            }
            else
            {
                stack.push( value) ;
            }
        }
        System.out.println("floatExpression: \"" + ctx.getText() + "\" ");
    }

    public static void main(String[] args) throws Exception {
        CharStream charStreams = CharStreams.fromFileName("C:\\Users\\igorp.DEKSTOP-LENOVO\\IdeaProjects\\antlrcombo\\src\\example.txt");
        CalculatorLexer lexer = new CalculatorLexer(charStreams);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        System.out.println(tokens.getText());

        CalculatorParser parser = new CalculatorParser(tokens);
        ParseTree tree = parser.expression();

        ParseTreeWalker walker = new ParseTreeWalker();
        Calculator calculatorListener = new Calculator();
        walker.walk(calculatorListener, tree);
        System.out.println("Result = " + calculatorListener.getResult());
    }
}

