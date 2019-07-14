package com.lux.calculator.listener;

import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;

public class OperandVerifyListener implements Listener {

    @Override
    public void handleEvent(Event e) {
        if (verifyInputNumber(e) || e.character == 8) {
            System.out.println("All is good");
        } else {
            e.doit = false;
            System.out.println("incorrect input");
        }
    }

    private boolean verifyInputNumber(Event e) {
        Text widget = (Text) e.widget;
        String wholNumber = widget.getText();
        String input = e.text;
        if (e.character == 8) {
            return true;
        } else if ((wholNumber.length() == 0) && input.equals("-")) {
            return true;
        } else if (wholNumber.length() != 0 && !pointIsAdded(wholNumber) && input.equals(".")) {
            return true;
        } else {
            try {
                double digit = Double.parseDouble(input);
            } catch (NumberFormatException nfe) {
                return false;
            }
        }

        return true;
    }

    private boolean pointIsAdded(String number) {
        return number.indexOf(".") >= 0;
    }
}