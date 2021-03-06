package com.lux.calculator.logic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

//import static org.junit.Assert.*;

import org.junit.Test;

import com.lux.calculator.operation.MathOperationAddition;

public class MathOperationAddTest {

	@Test
	public void testCalculateResult() {
		double firstNumber = 2;
		double secondNumber = 1;
 		double expResult = 3;
		MathOperationAddition instance = new MathOperationAddition();
		double result = instance.calculateResult(firstNumber, secondNumber);
		assertEquals(expResult, result, 0.0001);
	}

}
