package com.lux.calculator.logic;

import static org.junit.Assert.*;

import org.junit.Test;

import com.lux.calculator.operation.MathOperationDevision;

public class MathOperationDevisionTest {

	@Test
	public void testCalculateResult() {
		double firstNumber = 2;
		double secondNumber = 1;
 		double expResult = 2;
		MathOperationDevision instance = new MathOperationDevision();
		double result = instance.calculateResult(firstNumber, secondNumber);
		assertEquals(expResult, result, 0.0001);
	}

}
