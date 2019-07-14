package com.lux.calculator.listener;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;

public class OperandVerifyListener implements Listener {

    private Logger logger = Logger.getLogger(OperandVerifyListener.class.getName());

    @Override
    public void handleEvent(Event e) {
        if (!checkInputNumber(e)) {
            e.doit = false;
            logger.log(Level.WARNING, "Incorrect input");
        }
    }

    private boolean checkInputNumber(Event e) {
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