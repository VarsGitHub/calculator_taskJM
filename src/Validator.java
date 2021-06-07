import Exceptions.ExpressionFormatException;
import Exceptions.NumberSizeException;
import Exceptions.OperandTypeException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/*Class, which contains methods to check input data validity and filling expression data in case of correct user input.
Also contains roman digits map for notation conversion*/
public class Validator {

    private final Map<String, Integer> romanDigits = new HashMap<>();
    private final ArrayList<String> operands = new ArrayList<>();

    public Validator() {
        romanDigits.put("i", 1);
        romanDigits.put("ii", 2);
        romanDigits.put("iii", 3);
        romanDigits.put("iv", 4);
        romanDigits.put("v", 5);
        romanDigits.put("vi", 6);
        romanDigits.put("vii", 7);
        romanDigits.put("viii", 8);
        romanDigits.put("ix", 9);
        romanDigits.put("x", 10);
        operands.add("+");
        operands.add("-");
        operands.add("*");
        operands.add("/");
    }

    public boolean isValid(String userInput, Data userData) {
        if (userInput == null || userData == null) {
            return false;
        }
        /*Checking input expression format and arguments number*/
        String[] splitExpression = userInput.split(" ");
        if (splitExpression.length != 3) {
            throw new ExpressionFormatException(userInput);
        }
        /*Checking input expression operand validity*/
        if (operands.contains(splitExpression[1])) {
            userData.setOperand(splitExpression[1]);
        } else {
            throw new OperandTypeException(splitExpression[1]);
        }
        /*Checking input expression notation and filling expression data if both arguments have same notation*/
        try {
            if (isRoman(splitExpression[0]) && isRoman(splitExpression[2])) {
                userData.setFirstArg(romanDigits.get(splitExpression[0]));
                userData.setSecondArg(romanDigits.get(splitExpression[2]));
                userData.setNotation('R');
                return true;
            } else if (isArabic(splitExpression[0]) && isArabic(splitExpression[2])) {
                userData.setFirstArg(Integer.parseInt(splitExpression[0]));
                userData.setSecondArg(Integer.parseInt(splitExpression[2]));
                userData.setNotation('A');
                return true;
            }
        } catch (Exception ex) {
            throw new ExpressionFormatException(userInput.toUpperCase());
        }
        throw new NumberSizeException(userInput);
    }

    /*Checking if input argument refers to arabic notation*/
    private boolean isArabic(String targetString) {
        return romanDigits.containsValue(Integer.parseInt(targetString));
    }

    /*Checking if input argument refers to roman notation*/
    private boolean isRoman(String targetString) {
        return romanDigits.containsKey(targetString);
    }
}
