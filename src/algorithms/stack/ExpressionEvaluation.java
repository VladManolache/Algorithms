package algorithms.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Given an expression string array, return the final result of this expression. The expression contains only integer, +, -, *, /, (, ).
 *
 * Example:
 * For the expression 2*6-(23+7)/(1+2), input is
 * [
 *   "2", "*", "6", "-", "(", "23", "+", "7", ")", "/", "(", "1", "+", "2", ")"
 * ],
 * return 2
 * 
 * @author Vlad Manolache
 */
public class ExpressionEvaluation {
    
    public int evaluate(String[] expression) {
        if (expression == null || expression.length == 0) {
            return 0;
        }
        
       List<String> postfixExpression = infixToPostfix(expression);
              
       return evaluate(postfixExpression);
    }
    
    private int evaluate(List<String> postfixExpression) {
        Stack<String> stack = new Stack();
                
        int first;
        int second;
        int res;
        
        System.out.println("Evaluating postfix expression: " + postfixExpression);
        for ( String operator : postfixExpression ) { 
            switch (operator) {
                case "+":
                    second = Integer.parseInt(stack.pop());
                    first = Integer.parseInt(stack.pop());
                    res = first + second;
                    break;
                    
                case "-":
                    second = Integer.parseInt(stack.pop());
                    first = Integer.parseInt(stack.pop());
                    res = first - second;
                    break;
                    
                case "*":
                    second = Integer.parseInt(stack.pop());
                    first = Integer.parseInt(stack.pop());
                    res = first * second;
                    break;
                    
                case "/":
                    second = Integer.parseInt(stack.pop());
                    first = Integer.parseInt(stack.pop());
                    res = first / second;
                    break; 
                    
                default:
                    res = Integer.parseInt(operator);
                    break;
            }
            stack.push(res + "");
            
            System.out.println(stack);
        }
        
        res = 0;
        if (stack.size() == 1) {
            res = Integer.parseInt(stack.pop());
        }
        return res; 
    }
    
    private List<String> infixToPostfix(String[] expression) {
        Stack<String> operatorStack = new Stack<>(); 
        ArrayList<String> output = new ArrayList();
         
        System.out.println("Infix to Postfix:" + Arrays.toString(expression));
        for ( String operator : expression) {
            switch (operator) {
                case "+":
                case "-": {
                    while (!operatorStack.empty() && 
                        getPriority(operatorStack.peek()) >= getPriority(operator)) {
                        output.add(operatorStack.pop());
                    }
                    operatorStack.push(operator);            
                    break;
                }
                
                case "*":
                case "/":
                case "(": {
                    operatorStack.add(operator);
                    break;
                }
                
                case ")": {
                    while ( !operatorStack.empty() && 
                            !operatorStack.peek().equals("(")) {
                        output.add( operatorStack.pop() );
                    }
                    
                    if ( operatorStack.peek().equals("(")) {
                        operatorStack.pop();
                    }
                    else {
                        throw new Error("Invalid expression");
                    }
                    
                    break;
                }
                
                default:
                    // this is expected to be a number.
                    output.add(operator);
                    break;
            }
        }
        
        while( !operatorStack.empty() ) {
            output.add( operatorStack.pop() );
        }
        
        return output;
    } 
    
    private int getPriority(String operator) {
        switch (operator) {
            case "+":
                return 1;
            case "-":
                return 1;
            case "*":
                return 2;
            case "/":
                return 2;    
            default:
                return 0;
        }
    }
}
