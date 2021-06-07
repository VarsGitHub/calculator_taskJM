import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*Creating necessary objects for calculation*/
        Data userData = new Data();
        Validator validator = new Validator();
        Calculator calculator = new Calculator();
        Scanner in = new Scanner(System.in);
        String scanData;
        /*Waiting for user input*/
        while (true) {
            System.out.println("Enter an expression to calculate or 'E' to exit:");
            scanData = in.nextLine().toLowerCase();
            if (scanData.equalsIgnoreCase("e")) {
                System.exit(0);
            } else if (!validator.isValid(scanData, userData)) {
                System.out.println("Invalid data, try another:\n");
            } else {
                calculator.execute(userData);
            }
        }
    }
}
