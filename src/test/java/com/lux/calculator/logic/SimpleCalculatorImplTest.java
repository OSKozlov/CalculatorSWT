package com.lux.calculator.logic;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.lux.calculator.operation.MathOperationType;
import com.lux.calculator.ui.Calculator;

public class SimpleCalculatorImplTest {

	@Test
	public void testMakeCalculation() {
		double firstNumber = 4;
		double secondNumber = 5;
		final double delta = 0.0001;
		MathOperationType mathOperator1 = MathOperationType.ADDITION;
//		String mathOperator2 = "-";
//		String mathOperator3 = "/";
//		String mathOperator4 = "*";

		double expResult1 = 9;
//		double expResult2 = -1;
//		double expResult3 = 0.8;
//		double expResult4 = 20;
		
		Calculator calc = Calculator.getInstance();
		
		double result1 = calc.performOperation(firstNumber, secondNumber, mathOperator1);
//		double result2 = calc.makeCalculation(firstNumber, secondNumber, mathOperator2);
//		double result3 = calc.makeCalculation(firstNumber, secondNumber, mathOperator3);
//		double result4 = calc.makeCalculation(firstNumber, secondNumber, mathOperator4);
			
		assertEquals(expResult1, result1, delta);
//		assertEquals(expResult2, result2, delta);
//		assertEquals(expResult3, result3, delta);
//		assertEquals(expResult4, result4, delta);
	
	}
}
