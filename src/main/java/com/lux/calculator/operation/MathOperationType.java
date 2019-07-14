package com.lux.calculator.operation;

public enum MathOperationType {

    ADDITION("Addition", "+"), 
    SUBTRACTION("Subtraction", "-"),
    DIVISION("Division", "/"),
    MULTIPLICATION("Multiplication", "*");

    private String value;
    private String operationSign;

    MathOperationType(String value, String operationSign) {
        this.value = value;
        this.operationSign = operationSign;
    }

    public String getValue() {
        return value;
    }

    public String getOperationSign() {
        return operationSign;
    }

}
