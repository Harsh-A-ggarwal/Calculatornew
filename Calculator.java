import java.util.Scanner;

public class Calculator {

    public static double calculate(double num1, char operator, double num2) {
        switch (operator) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
            case 'x':
                return num1 * num2;
            case '/':
                if (num2 == 0) {
                    System.out.println("Error: Cannot divide by zero.");
                    return Double.NaN;
                }
                return num1 / num2;
            default:
                System.out.println("Invalid operator.");
                return Double.NaN;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Java Real-like Console Calculator");
        System.out.println("Type your expression (e.g., 12 + 5) or 'exit' to quit.\n");

        while (true) {
            System.out.print("Enter: ");

            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit") || input.equalsIgnoreCase("quit")) {
                System.out.println("👋 Exiting Calculator. Goodbye!");
                break;
            }

            String[] tokens = input.split(" ");

            if (tokens.length != 3) {
                System.out.println(" Invalid input format. Use format: number operator number (e.g., 12 + 4)");
                continue;
            }

            try {
                double num1 = Double.parseDouble(tokens[0]);
                char operator = tokens[1].charAt(0);
                double num2 = Double.parseDouble(tokens[2]);

                double result = calculate(num1, operator, num2);
                if (!Double.isNaN(result)) {
                    System.out.println("✅ Result: " + result);
                }

            } catch (NumberFormatException e) {
                System.out.println(" Invalid number format. Please enter valid numbers.");
            }
        }

        scanner.close();
    }
}
