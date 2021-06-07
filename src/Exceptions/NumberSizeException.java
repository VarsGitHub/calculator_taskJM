/*Expression thrown if input numbers are too big*/
package Exceptions;

public class NumberSizeException extends RuntimeException {
    public NumberSizeException(String message) {
        super(String.format("Invalid digits in expression %s", message));
    }
}
