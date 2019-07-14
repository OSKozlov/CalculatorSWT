package com.lux.calculator.exceptions;

public class IncorrectInputOfNumberException extends IllegalArgumentException {

    public IncorrectInputOfNumberException() {
        super();
    }

    public IncorrectInputOfNumberException(String message) {
        super(message);
    }
}
