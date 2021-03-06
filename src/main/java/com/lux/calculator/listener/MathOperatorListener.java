package com.lux.calculator.listener;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Combo;

import com.lux.calculator.operation.MathOperationType;
import com.lux.calculator.ui.Calculator;

@SuppressWarnings("unchecked")
public class MathOperatorListener extends SelectionAdapter {

    private Calculator calculator = Calculator.getInstance();

    private static final Map<String, String> items = new HashMap() {
        {
            put(MathOperationType.ADDITION.getOperationSign(), MathOperationType.ADDITION.getValue());
            put(MathOperationType.SUBTRACTION.getOperationSign(), MathOperationType.SUBTRACTION.getValue());
            put(MathOperationType.MULTIPLICATION.getOperationSign(), MathOperationType.MULTIPLICATION.getValue());
            put(MathOperationType.DIVISION.getOperationSign(), MathOperationType.DIVISION.getValue());
        }
    };

    @Override
    public void widgetSelected(SelectionEvent e) {
        if (e.widget instanceof Combo) {
            Combo combo = (Combo) e.widget;
            calculator.setOperation(items.get(combo.getText()));
            if (calculator.isOnFlyMode()) {
                if (calculator.isDataFieldsValid()) {
                    calculator.runCalculation();
                } else {
                    calculator.displayMessage(combo.getShell(), SWT.ICON_WARNING, "Warning",
                            "Please fill operation fields");
                }
            }
        }
    }
}
