package edu.purdue.kidd9.cs180;

import android.app.AlertDialog;
import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.widget.TextView;


/**
 * CalculatorView
 * The view for the calculator program using MVC design
 * @Steven Kidd, kidd9@purdue.edu
 */
public class CalculatorView implements CalculatorViewInterface {
    private TextView display;
    private AlertDialog alertDialog;
    public CalculatorView(TextView display, AlertDialog alertDialog) {
        this.display = display;
        this.alertDialog = alertDialog;
    }

    public void display(String val) {
        this.display.setText(val);
    }

    public void invalid() {
        alertDialog.show();
    }
}
