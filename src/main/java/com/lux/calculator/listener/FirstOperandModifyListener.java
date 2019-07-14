package com.lux.calculator.listener;

import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.widgets.Text;

import com.lux.calculator.ui.Calculator;

public class FirstOperandModifyListener implements ModifyListener {

    private Calculator calculator = Calculator.getInstance();

    @Override
    public void modifyText(ModifyEvent e) {
        Text widget = (Text) e.widget;
        String operand = widget.getText();
//        if (calculator.isOnFlyMode()) {
            calculator.setFirstOperand(operand);
//        }
    }
}
