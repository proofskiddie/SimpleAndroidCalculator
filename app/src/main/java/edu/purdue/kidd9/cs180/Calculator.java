package edu.purdue.kidd9.cs180;

/**
 * Calculator
 * The model of the Calculator program
 * @Steven Kidd, kidd9@purdue.edu
 */
public class Calculator {
    private String displayString;
    private String lastDisplay;
    private double currentValue;
    private CalculatorViewInterface view;
    boolean lastEqual;

    /*
     * Constructor. Initializes the instance variables.
     */
    public Calculator(CalculatorViewInterface view) {
        this.view = view;
        currentValue = 0;
        this.displayString = "";
        this.lastDisplay = "";
        this.lastEqual = false;
    }

    public void inputDigit(char act) {
        if (lastEqual)
            displayString = "";
        if (!displayString.matches(".*[/.][0-9]{2}")) {
            displayString += act;
            view.display(displayString);
            lastEqual = false;
        } else
            view.invalid();
    }

    public void equal() {
        if (!displayString.matches(".*[ ][/*+-][ ].*")) {
            view.invalid();
        } else {
            lastEqual = true;
            lastDisplay = displayString;
            String[] exp = displayString.split(" ");
            double op1 = Double.parseDouble(exp[0]);
            double op2 = Double.parseDouble(exp[2]);
            switch(exp[1]) {
                case "+":
                    displayString = "" + this.round2(op1 + op2);
                    break;
                case "-":
                    displayString = "" + this.round2(op1 - op2);
                    break;
                case "*":
                    displayString = "" + this.round2(op1 * op2);
                    break;
                case "/":
                    if (op2 == 0)
                        displayString = ((op1 == 0) ? "NaN" : ((op1 > 0) ? "" : "-") + "Infinity");
                    else
                        displayString = "" + this.round2(op1 / op2);
                    break;
            }
            view.display(displayString);
            if (displayString.matches(".*[IN].*"))
                displayString = "";
        }
    }

    public String round2(double arg) {
        String temp = "" + Math.round(100 * (arg)) / 100.0;
        if (!temp.matches("[0-9]+[.][0-9]{2}"))
            temp += "0";
        return temp;
    }

    public void dot() {
        if (displayString.matches("[0-9]+|.*[ ]+[0-9]+")) {
            displayString += ".";
            view.display(displayString);
            lastEqual = false;
        } else
            view.invalid();

    }

    public void delete() {
        int end = displayString.length();
        boolean temp = displayString.matches(".*[ ][/*+-][ ]");
        if (temp) {
            displayString = displayString.substring(0, end - 3);
            view.display(displayString);
        } else if (end > 0 && !lastEqual) {
            displayString = displayString.substring(0, end - 1);
            view.display(displayString);
        } else {
            displayString = lastDisplay;
            lastDisplay = "";
            view.display(displayString);
            lastEqual = false;
        }
    }

    public void operator(char op) {
        if (displayString.equals(""))
            view.invalid();
        else if (!displayString.matches(".*[ ][/*+-][ ].*")) {
            displayString += " " + op + " ";
            view.display(displayString);
            lastEqual = false;
        } else if (displayString.matches(".*[ ][/*+-][ ]")) {
            this.delete();
            this.operator(op);
        } else
            view.invalid();
    }
}
