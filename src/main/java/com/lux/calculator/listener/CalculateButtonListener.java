package com.lux.calculator.listener;

import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

import com.lux.calculator.ui.Calculator;

public class CalculateButtonListener implements Listener {

    private Calculator calculator = Calculator.getInstance();

    @Override
    public void handleEvent(Event event) {
        calculator.runCalculation();
    }
}