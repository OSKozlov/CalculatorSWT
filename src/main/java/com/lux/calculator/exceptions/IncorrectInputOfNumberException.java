package com.lux.calculator.exceptions;

@SuppressWarnings("serial")
public class IncorrectInputOfNumberException extends IllegalArgumentException {

    public IncorrectInputOfNumberException() {
        super();
    }

    public IncorrectInputOfNumberException(String message) {
        super(message);
    }
}
