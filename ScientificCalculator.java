public class ScientificCalculator extends BasicCalculator {

    public double squareRoot(double n) {

        if (n < 0) {
            return Double.NaN;
        }

        return Math.sqrt(n);
    }

    public double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }

    // Polymorphism
    public double power(int base, int exponent) {
        return Math.pow(base, exponent);
    }

    public double sin(double angle) {
        return Math.sin(Math.toRadians(angle));
    }

    public double cos(double angle) {
        return Math.cos(Math.toRadians(angle));
    }

    public double tan(double angle) {
        return Math.tan(Math.toRadians(angle));
    }

    public double log(double n) {

        if (n <= 0) {
            return Double.NaN;
        }

        return Math.log10(n);
    }

    public long factorial(int n) {

        if (n < 0) {
            System.out.println(
                    "Factorial not possible for negative numbers");
            return 0;
        }

        long fact = 1;

        for (int i = 1; i <= n; i++) {
            fact *= i;
        }

        return fact;
    }
}