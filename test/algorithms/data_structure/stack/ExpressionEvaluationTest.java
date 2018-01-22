package algorithms.data_structure.stack;


import org.junit.jupiter.api.Test;

/**
 *
 * @author Vlad Manolache
 */
public class ExpressionEvaluationTest {
    
    @Test
    void mainTest() {
        String[] expression = new String[] { 
            "2", "*", "6", "-", "(", 
            "23", "+", "7", ")", "/", 
            "(", "1", "+", "2", ")"
        };
        
        ExpressionEvaluation expressionEvaluation = new ExpressionEvaluation();
                
        assert(expressionEvaluation.evaluate(expression) == 2);
    }
    
    @Test
    void simpleTest_V1() {
        String[] expression = new String[] { 
            "(", "5", "+", "7", ")", "*", "2"
        };
        
        ExpressionEvaluation expressionEvaluation = new ExpressionEvaluation();
                
        assert(expressionEvaluation.evaluate(expression) == 24);
    }
    
    @Test
    void simpleTest_V2() {
        String[] expression = new String[] { 
            "5", "+", "7", "/", "2"
        };
        
        ExpressionEvaluation expressionEvaluation = new ExpressionEvaluation();
                
        assert(expressionEvaluation.evaluate(expression) == 8);
    }
    
}
