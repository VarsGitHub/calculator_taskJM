/* Expression thrown if user expression is incorrect*/
package Exceptions;

public class ExpressionFormatException extends RuntimeException {
    public ExpressionFormatException(String message) {
        super(String.format("Invalid expression %s", message));
    }
}
