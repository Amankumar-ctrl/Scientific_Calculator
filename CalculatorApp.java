import java.util.Scanner;

public class CalculatorApp {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ScientificCalculator calc = new ScientificCalculator();

        while (true) {
            System.out.println("\n===== SCIENTIFIC CALCULATOR =====");
            System.out.println("1. Add");
            System.out.println("2. Subtract");
            System.out.println("3. Multiply");
            System.out.println("4. Divide");
            System.out.println("5. Modulus");
            System.out.println("6. Square Root");
            System.out.println("7. Power");
            System.out.println("8. Sin");
            System.out.println("9. Cos");
            System.out.println("10. Tan");
            System.out.println("11. Log");
            System.out.println("12. Factorial");
            System.out.println("13. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter 2 numbers: ");
                    calc.setNumbers(sc.nextDouble(), sc.nextDouble());
                    System.out.println("Result: " + calc.add());
                    break;

                case 2:
                    System.out.print("Enter 2 numbers: ");
                    calc.setNumbers(sc.nextDouble(), sc.nextDouble());
                    System.out.println("Result: " + calc.subtract());
                    break;

                case 3:
                    System.out.print("Enter 2 numbers: ");
                    calc.setNumbers(sc.nextDouble(), sc.nextDouble());
                    System.out.println("Result: " + calc.multiply());
                    break;

                case 4:
                    System.out.print("Enter 2 numbers: ");
                    calc.setNumbers(sc.nextDouble(), sc.nextDouble());
                    System.out.println("Result: " + calc.divide());
                    break;

                case 5:
                    System.out.print("Enter 2 numbers: ");
                    calc.setNumbers(sc.nextDouble(), sc.nextDouble());
                    System.out.println("Result: " + calc.modulus());
                    break;

                case 6:
                    System.out.print("Enter number: ");
                    System.out.println("Result: " + calc.squareRoot(sc.nextDouble()));
                    break;

                case 7:
                    System.out.print("Enter base and exponent: ");
                    double base = sc.nextDouble();
                    double exponent = sc.nextDouble();
                    System.out.println("Result: " + calc.power(base, exponent));
                    break;

                case 8:
                    System.out.print("Enter angle in degrees: ");
                    System.out.println("Result: " + calc.sin(sc.nextDouble()));
                    break;

                case 9:
                    System.out.print("Enter angle in degrees: ");
                    System.out.println("Result: " + calc.cos(sc.nextDouble()));
                    break;

                case 10:
                    System.out.print("Enter angle in degrees: ");
                    System.out.println("Result: " + calc.tan(sc.nextDouble()));
                    break;

                case 11:
                    System.out.print("Enter number: ");
                    System.out.println("Result: " + calc.log(sc.nextDouble()));
                    break;

                case 12:
                    System.out.print("Enter integer: ");
                    System.out.println("Result: " + calc.factorial(sc.nextInt()));
                    break;

                case 13:
                    System.out.println("Calculator closed.");
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}