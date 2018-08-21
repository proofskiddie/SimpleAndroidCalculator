package edu.purdue.kidd9.cs180;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView display;
    AlertDialog alertDialog;
    CalculatorView calculatorView;
    Calculator calculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        this.display = (TextView) findViewById(R.id.Display);
        this.alertDialog = new AlertDialog.Builder(MainActivity.this).create();
        alertDialog.setTitle("Error");
        alertDialog.setMessage("Invalid Input");

        this.calculatorView = new CalculatorView(display, alertDialog);
        this.calculator = new Calculator(calculatorView);
        setSupportActionBar(toolbar);
    }

    public void input_1(View view) {
        calculator.inputDigit('1');
    }
    public void input_2(View view) {
        calculator.inputDigit('2');
    }
    public void input_3(View view) {
        calculator.inputDigit('3');
    }
    public void input_4(View view) {
        calculator.inputDigit('4');
    }
    public void input_5(View view) {
        calculator.inputDigit('5');
    }
    public void input_6(View view) {
        calculator.inputDigit('6');
    }
    public void input_7(View view) {
        calculator.inputDigit('7');
    }
    public void input_8(View view) {
        calculator.inputDigit('8');
    }
    public void input_9(View view) {
        calculator.inputDigit('9');
    }
    public void input_0(View view) {
        calculator.inputDigit('0');
    }
    public void dot(View view) {
        calculator.dot();
    }
    public void delete(View view) {
        calculator.delete();
    }
    public void opPlus(View view) {
        calculator.operator('+');
    }
    public void opSub(View view) {
        calculator.operator('-');
    }
    public void opDivide(View view) {
        calculator.operator('/');
    }
    public void opMulti(View view) {
        calculator.operator('*');
    }
    public void equal(View view) {
        calculator.equal();
    }
}
