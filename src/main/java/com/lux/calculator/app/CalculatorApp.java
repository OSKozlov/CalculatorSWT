package com.lux.calculator.app;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.lux.calculator.ui.AbstractCalculator;
import com.lux.calculator.ui.Calculator;

public class CalculatorApp {

    private static final String TITLE_OF_APP = "SWT Calculator";

    public static void main(String[] args) {

        Display display = new Display();
        Shell shell = new Shell(display, SWT.TITLE | SWT.BORDER | SWT.CLOSE | SWT.MIN | SWT.RESIZE);
        shell.setText(TITLE_OF_APP);
        
        GridLayout layout = new GridLayout(1, false);
        shell.setLayout(layout);

        AbstractCalculator calculator = Calculator.getInstance();
        calculator.runUI(shell);

        shell.setLocation(750, 200);
        shell.pack();
        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch())
                display.sleep();
        }
        display.dispose();
    }

}
