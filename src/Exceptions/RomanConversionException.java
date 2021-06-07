/*Expression thrown if number conversion from arabic to roman notation had failed for some reason*/
package Exceptions;

public class RomanConversionException extends RuntimeException {
    public RomanConversionException(int message) {
        super(String.format("Conversion to roman notation failed for number %s", message));
    }
}
