import java.util.*;
import java.util.regex.Pattern;

public class ExpressionHandler {

  static String[] expressionOps = {
      "¬",
      "!",
      "^",
      "&",
      "∨",
      "+",
      "->",
      "→"
  };

  public static String applyBrackets(String expression){
    String[] tokens = tokenizeExpression(expression);

    for (String op: expressionOps){

    }

    System.out.println(Arrays.toString(tokens));
    return null;
  }

  /**
   * Encodes operators and tokenizes elements of the expression.
   *
   * @param expression Expression being tokenized.
   * @return  Encoded Tokens.
   */
  private static String[] tokenizeExpression(String expression){
    //Iteration index variable.
    int i = 0;
    //Copy the expression and remove all spaces.
    String encodedExpression = expression.replaceAll(" ", "").replaceAll("^[()]","");

    //Loop through the possible operators
    for (String op : expressionOps){
      //Replace each operators with the index in the list and and spaces around the operators.
      encodedExpression = encodedExpression
          .replaceAll(Pattern.quote(op),  " " + op + " ");

      //Increment the iteration variable.
      i++;
    }

    //Return the encoded expression split by space regex.
    return encodedExpression.split(" ");
  }
}
