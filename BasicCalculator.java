public class BasicCalculator extends Calculator {

    public double add() {
        return getNum1() + getNum2();
    }

    public double subtract() {
        return getNum1() - getNum2();
    }

    public double multiply() {
        return getNum1() * getNum2();
    }

   public double divide() {

    if (getNum2() == 0) {

        throw new ArithmeticException(
                "Undefined");
    }

    return getNum1() / getNum2();
}

    @Override
public void displayCalculatorType() {
    System.out.println("Basic Calculator");
}

    public double modulus() {
        if (getNum2() == 0) {
            System.out.println("Modulus by zero not allowed");
            return 0;
        }
        return getNum1() % getNum2();
    }
}