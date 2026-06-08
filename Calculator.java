public abstract class Calculator {

    private double num1;
    private double num2;

    public void setNumbers(double a, double b) {
        this.num1 = a;
        this.num2 = b;
    }

    public double getNum1() {
        return num1;
    }

    public double getNum2() {
        return num2;
    }

    // Abstract method
    public abstract void displayCalculatorType();
}