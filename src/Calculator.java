import Exceptions.RomanConversionException;

import java.util.HashMap;
import java.util.Map;

/**
 * Class, designed to execute base arithmetic operations and arabic-roman notation number conversion.
 */
public class Calculator {
    public final Map<Integer, java.lang.String> romanNumbers = new HashMap<>();

    public Calculator() {
        romanNumbers.put(1, "I");
        romanNumbers.put(2, "II");
        romanNumbers.put(3, "III");
        romanNumbers.put(4, "IV");
        romanNumbers.put(5, "V");
        romanNumbers.put(6, "VI");
        romanNumbers.put(7, "VII");
        romanNumbers.put(8, "VIII");
        romanNumbers.put(9, "IX");
        romanNumbers.put(10, "X");
        romanNumbers.put(20, "XX");
        romanNumbers.put(30, "XXX");
        romanNumbers.put(40, "XL");
        romanNumbers.put(50, "L");
        romanNumbers.put(60, "LX");
        romanNumbers.put(70, "LXX");
        romanNumbers.put(80, "LXXX");
        romanNumbers.put(90, "XC");
        romanNumbers.put(100, "C");
    }

    public void execute(Data userData) {
        /* Choosing arithmetic operation, based on input expression operand*/
        switch (userData.getOperand()) {
            case "+":
                if (userData.getNotation() == 'A') {
                    System.out.println("Your answer is : " + (userData.getFirstArg() + userData.getSecondArg()));
                    return;
                } else if (userData.getNotation() == 'R') {
                    System.out.println("Your answer is : " + conversionRoman(userData.getFirstArg() + userData.getSecondArg()));
                    return;
                }
            case "-":
                if (userData.getNotation() == 'A') {
                    System.out.println("Your answer is : " + (userData.getFirstArg() - userData.getSecondArg()));
                    return;
                } else if (userData.getNotation() == 'R') {
                    System.out.println("Your answer is : " + conversionRoman(userData.getFirstArg() - userData.getSecondArg()));
                    return;
                }
            case "*":
                if (userData.getNotation() == 'A') {
                    System.out.println("Your answer is : " + (userData.getFirstArg() * userData.getSecondArg()));
                    return;
                } else if (userData.getNotation() == 'R') {
                    System.out.println("Your answer is : " + conversionRoman(userData.getFirstArg() * userData.getSecondArg()));
                    return;
                }
            case "/":
                if (userData.getNotation() == 'A') {
                    System.out.println("Your answer is : " + (userData.getFirstArg() / userData.getSecondArg()));
                    if (userData.getFirstArg() % userData.getSecondArg() != 0) {
                        System.out.println("The result was rounded to whole number, may be inaccurate.");
                    }
                } else if (userData.getNotation() == 'R') {
                    System.out.println("Your answer is : " + conversionRoman(userData.getFirstArg() / userData.getSecondArg()));
                    if (userData.getFirstArg() % userData.getSecondArg() != 0) {
                        System.out.println("The result was rounded to whole number, may be inaccurate.");
                    }
                }
        }
    }

    /*Method for number conversion from arabic to roman notation*/
    private String conversionRoman(int input) {
        if (romanNumbers.containsKey(Math.abs(input))) {
            if (input < 0) {
                return "-" + romanNumbers.get(Math.abs(input));
            } else {
                return romanNumbers.get(Math.abs(input));
            }
        }
        for (int i = 90; i >= 0; i = i - 10) {
            if (Math.abs(input) % i != 0 && i < Math.abs(input)) {
                return romanNumbers.get(i) + romanNumbers.get(Math.abs(input) % i);
            }
        }
        throw new RomanConversionException(input);
    }
}
