package com.lux.calculator.listener;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;

import com.lux.calculator.ui.Calculator;

public class CheckBoxSelectionListener extends SelectionAdapter {

    private Calculator calculator = Calculator.getInstance();

    @Override
    public void widgetSelected(SelectionEvent e) {
        if (e.widget instanceof Button) {
            Button button = (Button)e.widget;
            calculator.setOnFlyMode(button.getSelection());
        }
    }
}
