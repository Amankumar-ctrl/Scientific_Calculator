import javax.swing.*;
import java.awt.*;

public class CalculatorFrame extends JFrame {

    private JLabel expressionLabel;
private JTextField display;

    private double firstNumber = 0;
    private String operator = "";
    private boolean startNewNumber = false;

 private String formatResult(double result) {

    if (result == (long) result) {
        return String.valueOf((long) result);
    }

    return String.format("%.6f", result)
            .replaceAll("0+$", "")
            .replaceAll("\\.$", "");
}

    private ScientificCalculator calc =
            new ScientificCalculator();

    public CalculatorFrame() {

        setTitle("Scientific Calculator Professional");

        // Smaller size to fit laptop screen
        setSize(400, 650);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        getContentPane().setBackground(
                new Color(32, 32, 32));

        setLayout(new BorderLayout());

        ((JPanel)getContentPane())
        .setBorder(
                BorderFactory.createEmptyBorder(
                        8,8,8,8));

        // DISPLAY

       JPanel displayPanel = new JPanel();
displayPanel.setLayout(new BorderLayout());
displayPanel.setBackground(new Color(25,25,25));

expressionLabel = new JLabel("");
expressionLabel.setForeground(Color.LIGHT_GRAY);
expressionLabel.setHorizontalAlignment(SwingConstants.RIGHT);
expressionLabel.setFont(new Font("Segoe UI", Font.PLAIN, 18));

display = new JTextField();
display.setEditable(false);
display.setHorizontalAlignment(JTextField.RIGHT);
display.setFont(new Font("Segoe UI", Font.BOLD, 42));
display.setBackground(new Color(25,25,25));
display.setForeground(Color.WHITE);
display.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

displayPanel.add(expressionLabel, BorderLayout.NORTH);
displayPanel.add(display, BorderLayout.CENTER);

displayPanel.setPreferredSize(new Dimension(400,120));

add(displayPanel, BorderLayout.NORTH);
        // BUTTON PANEL

        JPanel buttonPanel = new JPanel();

        buttonPanel.setBackground(
                new Color(32, 32, 32));

        buttonPanel.setLayout(
                new GridLayout(7, 4, 5, 5));

       String[] buttons = {

        "AC", "DEL", "%", "1/x",

        "sin", "cos", "tan", "n!",

        "√", "log", "x^y", "÷",

        "7", "8", "9", "*",

        "4", "5", "6", "-",

        "1", "2", "3", "+",

        "+/-", "0", ".", "="
};

        for (String text : buttons) {

            JButton button = new JButton(text);

            button.setFont(
                    new Font("Segoe UI",
                            Font.BOLD,
                            16));

            button.setFocusPainted(false);

            button.setBorder(
        BorderFactory.createLineBorder(
                new Color(70,70,70),1));

            button.setForeground(Color.WHITE);

if(text.equals("=")){

    button.setBackground(
            new Color(96,192,202)); // cyan
}

else if(text.equals("+")
        || text.equals("-")
        || text.equals("*")
        || text.equals("÷")
        || text.equals("%")){

    button.setBackground(
            new Color(70,70,70)); // operators
}

else if(text.equals("sin")
        || text.equals("cos")
        || text.equals("tan")
        || text.equals("√")
        || text.equals("log")
        || text.equals("x^y")
        || text.equals("n!")
        || text.equals("AC")
        || text.equals("DEL")){

    button.setBackground(
            new Color(60,60,60)); // scientific
}

else{

    button.setBackground(
            new Color(50,50,50)); // numbers
}

            if (text.equals("")) {
                button.setEnabled(false);
            }

            button.addActionListener(e -> {

               if (text.equals("AC")) {

    display.setText("");

    expressionLabel.setText("");

    firstNumber = 0;

    operator = "";

    startNewNumber = false;
}

                else if (text.equals("DEL")) {

                    String current =
                            display.getText();

                    if (current.length() > 1) {

                        display.setText(
                                current.substring(
                                        0,
                                        current.length() - 1));
                    }

                    else {

                        display.setText("0");
                    }
                }

 else if (text.equals("sin")) {

    double num =
            Double.parseDouble(display.getText());

    expressionLabel.setText(
            "sin(" + formatResult(num) + ")");

    display.setText(
            formatResult(
                    calc.sin(num)));

    startNewNumber = true;
}

                else if (text.equals("cos")) {

                        System.out.println("COS WORKING");

                    double num =
                            Double.parseDouble(
                                    display.getText());
                                    expressionLabel.setText(
        "cos(" + formatResult(num) + ")");

                    display.setText(
                            formatResult(
                                    calc.cos(num)));
                }

                else if (text.equals("tan")) {

                        System.out.println("TAN WORKING");

                    double num =
                            Double.parseDouble(
                                    display.getText());
                                    expressionLabel.setText(
        "tan(" + formatResult(num) + ")");

                    display.setText(
                            formatResult(
                                    calc.tan(num)));
                }

                else if (text.equals("√")) {

                    double num =
                            Double.parseDouble(
                                    display.getText());

                                    expressionLabel.setText(
        "√(" + formatResult(num) + ")");

                    display.setText(
        formatResult(
                calc.squareRoot(num)));
                }

                else if (text.equals("log")) {

                    double num =
                            Double.parseDouble(
                                    display.getText());

                                    expressionLabel.setText(
        "log(" + formatResult(num) + ")");

                    display.setText(
                            formatResult(
                                    calc.log(num)));
                }

                else if (text.equals("n!")) {

                    int num =
                            Integer.parseInt(
                                    display.getText());
                                    expressionLabel.setText(
        "!(" + formatResult(num) + ")");


        
                    display.setText(
                            formatResult(
                                    calc.factorial(num)));
                }

                else if(text.equals("1/x")){

    double num =
            Double.parseDouble(
                    display.getText());

    display.setText(
            formatResult(
                    1 / num));
}

else if(text.equals("+/-")){

    double num =
            Double.parseDouble(
                    display.getText());

    display.setText(
            formatResult(
                    -num));
}




                else if (text.equals("x^y")) {

    firstNumber =
            Double.parseDouble(
                    display.getText());

    operator = "x^y";

    startNewNumber = true;
}

               else if (text.equals("+")
        || text.equals("-")
        || text.equals("*")
        || text.equals("÷")
        || text.equals("%")) {

    firstNumber =
            Double.parseDouble(
                    display.getText());

    operator = text;
    startNewNumber = true;
    expressionLabel.setText(
        formatResult(firstNumber)
        + " " + operator);
}

                else if (text.equals("=")) {

                    double secondNumber =
                            Double.parseDouble(
                                    display.getText());

                    double result = 0;

                    switch (operator) {

                        case "+":
                            calc.setNumbers(firstNumber, secondNumber);
                            result = calc.add();
                            break;

                        case "-":
                            calc.setNumbers(firstNumber, secondNumber);
                            result = calc.subtract();
                            break;

                        case "*":
                            calc.setNumbers(firstNumber, secondNumber);
                            result = calc.multiply();
                            break;

                        case "÷":
    try {

        calc.setNumbers(
                firstNumber,
                secondNumber);

        result = calc.divide();

    } catch (ArithmeticException ex) {

        display.setText("Undefined");
        return;
    }
    break;

                        case "%":
                            calc.setNumbers(firstNumber, secondNumber);
                            result = calc.modulus();
                            break;

                        case "x^y":
                            result = calc.power(firstNumber, secondNumber);
                            break;
                    }

                    expressionLabel.setText(
        formatResult(firstNumber)
        + " "
        + operator
        + " "
        + formatResult(secondNumber)
        + " =");

                    display.setText(
                            formatResult(result)); 
                            startNewNumber = true;               
                }

                else {

    if(startNewNumber){

    display.setText(text);

    expressionLabel.setText("");

    startNewNumber = false;
}

    else if(display.getText().equals("0")
            || display.getText().isEmpty()){

        display.setText(text);
    }

    else{

        display.setText(
                display.getText() + text);
    }
}
            });

            buttonPanel.add(button);
        }

        add(buttonPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() ->
                new CalculatorFrame());
    }
}