package com.lux.calculator.operation;

public enum MathOperationType {

    ADDITION("ADDITION", "+"), 
    SUBTRACTION("SUBTRACTION", "-"),
    DIVISION("DIVISION", "/"),
    MULTIPLICATION("MULTIPLICATION", "*");

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
