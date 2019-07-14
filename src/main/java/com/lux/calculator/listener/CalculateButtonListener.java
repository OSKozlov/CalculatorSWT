package com.lux.calculator.listener;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

import com.lux.calculator.ui.Calculator;

public class CalculateButtonListener implements Listener {

    private Calculator calculator = Calculator.getInstance();

    @Override
    public void handleEvent(Event event) {
        if (event.widget instanceof Button) {
            Button button = (Button) event.widget;
            if (calculator.isDataFieldsValid()) {
                calculator.runCalculation();
            } else {
                calculator.displayMessage(button.getShell(), SWT.ICON_WARNING, "Warning",
                        "Please fill operation fields");
            }
        }
    }
}