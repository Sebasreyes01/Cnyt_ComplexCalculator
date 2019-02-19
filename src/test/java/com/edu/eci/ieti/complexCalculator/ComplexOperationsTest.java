package com.edu.eci.ieti.complexCalculator;

import org.junit.Test;

import static org.junit.Assert.*;

public class ComplexOperationsTest {

	@Test
	public void sumTest() {
		ComplexNumber c1 = new ComplexNumber(3, -1);
		ComplexNumber c2 = new ComplexNumber(1, 4);
		ComplexNumber result = ComplexOperations.sum(c1, c2);
		ComplexNumber expected = new ComplexNumber(4, 3);
		assertEquals(expected, result);
//        assertEquals(expected.getComplexNumber(), result.getComplexNumber());
	}

	@Test
	public void subtractionTest() {
		ComplexNumber c1 = new ComplexNumber(5, 7);
		ComplexNumber c2 = new ComplexNumber(3, 1);
		ComplexNumber result = ComplexOperations.subtraction(c1, c2);
		ComplexNumber expected = new ComplexNumber(2, 6);
		assertEquals(expected, result);
//        assertEquals(expected.getComplexNumber(), result.getComplexNumber());
	}

	@Test
	public void multiplicationTest() {
		ComplexNumber c1 = new ComplexNumber(3, -2);
		ComplexNumber c2 = new ComplexNumber(1, 2);
		ComplexNumber result = ComplexOperations.multiplication(c1, c2);
		ComplexNumber expected = new ComplexNumber(7, 4);
		assertEquals(expected, result);
//        assertEquals(expected.getComplexNumber(), result.getComplexNumber());
	}

	@Test
	public void divisionTest() {
		ComplexNumber c1 = new ComplexNumber(-2, 1);
		ComplexNumber c2 = new ComplexNumber(1, 2);
		ComplexNumber result = ComplexOperations.division(c1, c2);
		ComplexNumber expected = new ComplexNumber(0, 1);
		assertEquals(expected, result);
//        assertEquals(expected.getComplexNumber(), result.getComplexNumber());
	}

	@Test
	public void polarToCartesianTest() {
		ComplexNumber result = ComplexOperations.polarToCartesian(Math.sqrt(2), Math.PI / 4.0 );
		ComplexNumber expected = new ComplexNumber(1, 1);
		assertEquals(expected, result);
//        assertEquals(expected.getComplexNumber(), result.getComplexNumber());
	}

	@Test
	public void cartesianToPolarTest() {
		ComplexNumber c1 = new ComplexNumber(1, 1);
		String expected = "(1.41, 0.79)";
		String result = ComplexOperations.cartesianToPolar(c1);
		assertEquals(expected, result);
	}

	@Test
	public void modulusTest() {
		ComplexNumber c1 = new ComplexNumber(1, -1);
		double expected = Math.sqrt(2);
		double result = c1.modulus();
		assertEquals(expected, result, 0);
	}

	@Test
	public void conjugateTest() {
		ComplexNumber c1 = new ComplexNumber(2, 5);
		ComplexNumber expected = new ComplexNumber(2, -5);
		ComplexNumber result = c1.conjugate();
		assertEquals(expected, result);
//        assertEquals(expected.getComplexNumber(), result.getComplexNumber());
	}

	@Test
	public void getPhaseTest() {
		ComplexNumber c1 = new ComplexNumber(1, 1);
		double expected = Math.PI / 4;
		double result = c1.getPhase();
		assertEquals(expected, result, 0);
	}

	@Test
	public void vectorsAddition() throws Exception{
		ComplexVector v1 = new ComplexVector(new ComplexNumber[]{new ComplexNumber(1,2), new ComplexNumber(3,4), new ComplexNumber(5,6)});
		ComplexVector v2 = new ComplexVector(new ComplexNumber[]{new ComplexNumber(7,8), new ComplexNumber(9,0), new ComplexNumber(1,2)});
		ComplexVector expected = new ComplexVector(new ComplexNumber[]{new ComplexNumber(8,10), new ComplexNumber(12,4), new ComplexNumber(6,8)});
		ComplexVector result = ComplexOperations.vectorsAddition(v1, v2);
		assertEquals(expected, result);
	}

	@Test
	public void vectorScalarMultiplication() {
		ComplexVector v = new ComplexVector(new ComplexNumber[]{new ComplexNumber(1,2), new ComplexNumber(3,4), new ComplexNumber(5,6)});
		ComplexNumber c = new ComplexNumber(7, 8);
		ComplexVector actual = ComplexOperations.vectorScalarMultiplication(c, v);
		ComplexVector expected = new ComplexVector(new ComplexNumber[]{new ComplexNumber(-9,22), new ComplexNumber(-11,52), new ComplexNumber(-13,82)});
		assertEquals(expected, actual);
	}

	@Test
	public void matrixAddition() throws Exception{
		ComplexMatrix m1 = new ComplexMatrix(new ComplexNumber[2][2]);
		m1.getMatrix()[0][0] = new ComplexNumber(1, 2);
		m1.getMatrix()[0][1] = new ComplexNumber(5, 6);
		m1.getMatrix()[1][0] = new ComplexNumber(3, 4);
		m1.getMatrix()[1][1] = new ComplexNumber(7, 8);
		ComplexMatrix m2 = new ComplexMatrix(new ComplexNumber[2][2]);
		m2.getMatrix()[0][0] = new ComplexNumber(9, 0);
		m2.getMatrix()[0][1] = new ComplexNumber(3, 4);
		m2.getMatrix()[1][0] = new ComplexNumber(1, 2);
		m2.getMatrix()[1][1] = new ComplexNumber(5, 6);
		ComplexMatrix expected = new ComplexMatrix(new ComplexNumber[2][2]);
		expected.getMatrix()[0][0] = new ComplexNumber(10, 2);
		expected.getMatrix()[0][1] = new ComplexNumber(8, 10);
		expected.getMatrix()[1][0] = new ComplexNumber(4, 6);
		expected.getMatrix()[1][1] = new ComplexNumber(12, 14);
		ComplexMatrix actual = ComplexOperations.matrixAddition(m1, m2);
		assertEquals(expected, actual);
	}

	@Test
	public void matrixScalarMultiplication() throws Exception{
		ComplexNumber c = new ComplexNumber(9, 2);
		ComplexMatrix m = new ComplexMatrix(new ComplexNumber[2][2]);
		m.getMatrix()[0][0] = new ComplexNumber(1, 2);
		m.getMatrix()[0][1] = new ComplexNumber(5, 6);
		m.getMatrix()[1][0] = new ComplexNumber(3, 4);
		m.getMatrix()[1][1] = new ComplexNumber(7, 8);
		ComplexMatrix expected = new ComplexMatrix(new ComplexNumber[2][2]);
		expected.getMatrix()[0][0] = new ComplexNumber(5, 16);
		expected.getMatrix()[0][1] = new ComplexNumber(33, 64);
		expected.getMatrix()[1][0] = new ComplexNumber(19, 42);
		expected.getMatrix()[1][1] = new ComplexNumber(47, 86);
		ComplexMatrix actual = ComplexOperations.matrixScalarMultiplication(c, m);
		assertEquals(expected, actual);
	}

	@Test
	public void vectorInverse() {
		ComplexVector v = new ComplexVector(new ComplexNumber[]{new ComplexNumber(1,2), new ComplexNumber(3,4), new ComplexNumber(5,6)});
		ComplexVector expected = new ComplexVector(new ComplexNumber[]{new ComplexNumber(-1,-2), new ComplexNumber(-3,-4), new ComplexNumber(-5,-6)});
		ComplexVector actual = v.inverse();
		assertEquals(expected, actual);
	}

	@Test
	public void matrixInverse() throws Exception{
		ComplexMatrix m = new ComplexMatrix(new ComplexNumber[2][2]);
		m.getMatrix()[0][0] = new ComplexNumber(1, 2);
		m.getMatrix()[0][1] = new ComplexNumber(5, 6);
		m.getMatrix()[1][0] = new ComplexNumber(3, 4);
		m.getMatrix()[1][1] = new ComplexNumber(7, 8);
		ComplexMatrix expected = new ComplexMatrix(new ComplexNumber[2][2]);
		expected.getMatrix()[0][0] = new ComplexNumber(-1, -2);
		expected.getMatrix()[0][1] = new ComplexNumber(-5, -6);
		expected.getMatrix()[1][0] = new ComplexNumber(-3, -4);
		expected.getMatrix()[1][1] = new ComplexNumber(-7, -8);
		ComplexMatrix actual = m.inverse();
		assertEquals(expected, actual);
	}

	@Test
	public void matrixMultiplication() {
	}
}