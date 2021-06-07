/*Exception thrown if input expression contains wrong operand*/
package Exceptions;

public class OperandTypeException extends RuntimeException {
    public OperandTypeException(String message) {
        super(String.format("Invalid operand %s", message));
    }
}
