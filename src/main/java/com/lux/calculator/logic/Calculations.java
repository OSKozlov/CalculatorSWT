package com.lux.calculator.logic;

import java.util.Map;

import com.lux.calculator.app.AbstractCalculator;
import com.lux.calculator.listener.MathModelChangeListener;
import com.lux.calculator.model.MathModel;
import com.lux.calculator.ui.CalculatorComposite;

public class Calculations implements MathModelChangeListener {

	private double firstNumber;
	private String mathOperator;
	private double secondNumber;
	private double result;
	private boolean isflyModeOn;

	private MathModel mathData;
	private AbstractCalculator calculator;

	public Calculations(AbstractCalculator calculator) {
		this.calculator = calculator;
	}

	@Override
	public void update(Map params) {
		
		this.firstNumber = (double) params.get("firstOperand");
		this.mathOperator = (String) params.get("sign");
		this.secondNumber = (double) params.get("secondOperand");
		
		this.result = calculator.doCalculation(firstNumber, secondNumber, mathOperator);
		setResultIntoResultField(result);
		setResultIntoHistory(result);
	}
	
	private void setResultIntoResultField(double result) {
//		CalculatorComposite.getInstance().getMathOperationPanel().updateResultField(String.valueOf(result));
	}
	
	private void setResultIntoHistory(double result) {
//		CalculatorComposite.getInstance().getHistoryPanel()
//		.addStatementToHistory(firstNumber + mathOperator + secondNumber + " = " + result);
	}
	

}