package com.edu.eci.ieti.complexCalculator;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

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
	public void vectorsAdditionTest() throws Exception{
		ComplexVector v1 = new ComplexVector(new ComplexNumber[]{new ComplexNumber(1,2), new ComplexNumber(3,4), new ComplexNumber(5,6)});
		ComplexVector v2 = new ComplexVector(new ComplexNumber[]{new ComplexNumber(7,8), new ComplexNumber(9,0), new ComplexNumber(1,2)});
		ComplexVector expected = new ComplexVector(new ComplexNumber[]{new ComplexNumber(8,10), new ComplexNumber(12,4), new ComplexNumber(6,8)});
		ComplexVector result = ComplexOperations.vectorsAddition(v1, v2);
		assertEquals(expected, result);
	}

	@Test
	public void vectorScalarMultiplicationTest() {
		ComplexVector v = new ComplexVector(new ComplexNumber[]{new ComplexNumber(1,2), new ComplexNumber(3,4), new ComplexNumber(5,6)});
		ComplexNumber c = new ComplexNumber(7, 8);
		ComplexVector actual = ComplexOperations.vectorScalarMultiplication(c, v);
		ComplexVector expected = new ComplexVector(new ComplexNumber[]{new ComplexNumber(-9,22), new ComplexNumber(-11,52), new ComplexNumber(-13,82)});
		assertEquals(expected, actual);
	}

	@Test
	public void matrixAdditionTest() throws Exception{
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
	public void matrixScalarMultiplicationTest() throws Exception{
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
	public void vectorInverseTest() {
		ComplexVector v = new ComplexVector(new ComplexNumber[]{new ComplexNumber(1,2), new ComplexNumber(3,4), new ComplexNumber(5,6)});
		ComplexVector expected = new ComplexVector(new ComplexNumber[]{new ComplexNumber(-1,-2), new ComplexNumber(-3,-4), new ComplexNumber(-5,-6)});
		ComplexVector actual = v.inverse();
		assertEquals(expected, actual);
	}

	@Test
	public void matrixInverseTest() throws Exception{
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
	public void matrixMultiplicationTest() throws Exception {
		ComplexMatrix m1 = new ComplexMatrix(new ComplexNumber[3][3]);
		m1.getMatrix()[0][0] = new ComplexNumber(3, 2);
		m1.getMatrix()[0][1] = new ComplexNumber(0, 0);
		m1.getMatrix()[0][2] = new ComplexNumber(5, -6);
		m1.getMatrix()[1][0] = new ComplexNumber(1, 0);
		m1.getMatrix()[1][1] = new ComplexNumber(4, 2);
		m1.getMatrix()[1][2] = new ComplexNumber(0, 1);
		m1.getMatrix()[2][0] = new ComplexNumber(4, -1);
		m1.getMatrix()[2][1] = new ComplexNumber(0, 0);
		m1.getMatrix()[2][2] = new ComplexNumber(4, 0);
		ComplexMatrix m2 = new ComplexMatrix(new ComplexNumber[3][3]);
		m2.getMatrix()[0][0] = new ComplexNumber(5, 0);
		m2.getMatrix()[0][1] = new ComplexNumber(2, -1);
		m2.getMatrix()[0][2] = new ComplexNumber(6, -4);
		m2.getMatrix()[1][0] = new ComplexNumber(0, 0);
		m2.getMatrix()[1][1] = new ComplexNumber(4, 5);
		m2.getMatrix()[1][2] = new ComplexNumber(2, 0);
		m2.getMatrix()[2][0] = new ComplexNumber(7, -4);
		m2.getMatrix()[2][1] = new ComplexNumber(2, 7);
		m2.getMatrix()[2][2] = new ComplexNumber(0, 0);
		ComplexMatrix expected = new ComplexMatrix(new ComplexNumber[3][3]);
		expected.getMatrix()[0][0] = new ComplexNumber(26, -52);
		expected.getMatrix()[0][1] = new ComplexNumber(60, 24);
		expected.getMatrix()[0][2] = new ComplexNumber(26, 0);
		expected.getMatrix()[1][0] = new ComplexNumber(9, 7);
		expected.getMatrix()[1][1] = new ComplexNumber(1, 29);
		expected.getMatrix()[1][2] = new ComplexNumber(14, 0);
		expected.getMatrix()[2][0] = new ComplexNumber(48, -21);
		expected.getMatrix()[2][1] = new ComplexNumber(15, 22);
		expected.getMatrix()[2][2] = new ComplexNumber(20, -22);
		ComplexMatrix actual = ComplexOperations.matrixMultiplication(m1, m2);
		assertEquals(expected, actual);
	}

	@Test
	public void actionMatrixVectorTest() throws Exception {
		ComplexMatrix m = new ComplexMatrix(new ComplexNumber[3][3]);
		m.getMatrix()[0][0] = new ComplexNumber(3, 2);
		m.getMatrix()[0][1] = new ComplexNumber(0, 0);
		m.getMatrix()[0][2] = new ComplexNumber(5, -6);
		m.getMatrix()[1][0] = new ComplexNumber(1, 0);
		m.getMatrix()[1][1] = new ComplexNumber(4, 2);
		m.getMatrix()[1][2] = new ComplexNumber(0, 1);
		m.getMatrix()[2][0] = new ComplexNumber(4, -1);
		m.getMatrix()[2][1] = new ComplexNumber(0, 0);
		m.getMatrix()[2][2] = new ComplexNumber(4, 0);
		ComplexVector v = new ComplexVector(new ComplexNumber[]{new ComplexNumber(7,8), new ComplexNumber(9,0), new ComplexNumber(1,2)});
		ComplexVector expected = new ComplexVector(new ComplexNumber[]{new ComplexNumber(22,42), new ComplexNumber(41,27), new ComplexNumber(40,33)});
		ComplexVector actual = ComplexOperations.actionMatrixVector(m, v);
		assertEquals(expected, actual);
	}

    @Test
    public void vectorInnerProductTest() throws Exception {
		ComplexVector v1 = new ComplexVector(new ComplexNumber[]{new ComplexNumber(5,6), new ComplexNumber(3,2), new ComplexNumber(-7,0)});
		ComplexVector v2 = new ComplexVector(new ComplexNumber[]{new ComplexNumber(7,8), new ComplexNumber(9,0), new ComplexNumber(1,2)});
		ComplexNumber expected = new ComplexNumber(103, -34);
		ComplexNumber actual = ComplexOperations.vectorInnerProduct(v1, v2);
		assertEquals(expected, actual);
    }

	@Test
	public void vectorConjugate() {
		ComplexVector v = new ComplexVector(new ComplexNumber[]{new ComplexNumber(5,6), new ComplexNumber(3,2), new ComplexNumber(-7,1)});
		ComplexVector expected = new ComplexVector(new ComplexNumber[]{new ComplexNumber(5,-6), new ComplexNumber(3,-2), new ComplexNumber(-7,-1)});
		ComplexVector actual = v.conjugate();
		assertEquals(expected, actual);
	}

    @Test
	public void matrixTransposeTest() throws Exception {
		ComplexMatrix m = new ComplexMatrix(new ComplexNumber[2][2]);
		m.getMatrix()[0][0] = new ComplexNumber(3, 2);
		m.getMatrix()[0][1] = new ComplexNumber(9, 5);
		m.getMatrix()[1][0] = new ComplexNumber(5, -6);
		m.getMatrix()[1][1] = new ComplexNumber(1, 4);
		ComplexMatrix expected = new ComplexMatrix(new ComplexNumber[2][2]);
		expected.getMatrix()[0][0] = new ComplexNumber(3, 2);
		expected.getMatrix()[0][1] = new ComplexNumber(5, -6);
		expected.getMatrix()[1][0] = new ComplexNumber(9, 5);
		expected.getMatrix()[1][1] = new ComplexNumber(1, 4);
		ComplexMatrix actual = m.transpose();
		assertEquals(expected, actual);
	}

	@Test
	public void matrixConjugateTest() throws Exception {
		ComplexMatrix m = new ComplexMatrix(new ComplexNumber[2][2]);
		m.getMatrix()[0][0] = new ComplexNumber(3, 2);
		m.getMatrix()[0][1] = new ComplexNumber(9, 5);
		m.getMatrix()[1][0] = new ComplexNumber(5, -6);
		m.getMatrix()[1][1] = new ComplexNumber(1, 4);
		ComplexMatrix expected = new ComplexMatrix(new ComplexNumber[2][2]);
		expected.getMatrix()[0][0] = new ComplexNumber(3, -2);
		expected.getMatrix()[0][1] = new ComplexNumber(9, -5);
		expected.getMatrix()[1][0] = new ComplexNumber(5, 6);
		expected.getMatrix()[1][1] = new ComplexNumber(1, -4);
		ComplexMatrix actual = m.conjugate();
		assertEquals(expected, actual);
	}

	@Test
	public void adjointTest() throws Exception {
		ComplexMatrix m = new ComplexMatrix(new ComplexNumber[2][2]);
		m.getMatrix()[0][0] = new ComplexNumber(3, 2);
		m.getMatrix()[0][1] = new ComplexNumber(9, 5);
		m.getMatrix()[1][0] = new ComplexNumber(5, -6);
		m.getMatrix()[1][1] = new ComplexNumber(1, 4);
		ComplexMatrix expected = new ComplexMatrix(new ComplexNumber[2][2]);
		expected.getMatrix()[0][0] = new ComplexNumber(3, -2);
		expected.getMatrix()[0][1] = new ComplexNumber(5, 6);
		expected.getMatrix()[1][0] = new ComplexNumber(9, -5);
		expected.getMatrix()[1][1] = new ComplexNumber(1, -4);
		ComplexMatrix actual = m.adjoint();
		assertEquals(expected, actual);
	}

	@Test
	public void isHermitianMatrixTest() throws Exception {
		ComplexMatrix m1 = new ComplexMatrix(new ComplexNumber[2][2]);
		m1.getMatrix()[0][0] = new ComplexNumber(3, 2);
		m1.getMatrix()[0][1] = new ComplexNumber(9, 5);
		m1.getMatrix()[1][0] = new ComplexNumber(5, -6);
		m1.getMatrix()[1][1] = new ComplexNumber(1, 4);
		boolean actual = ComplexOperations.isHermitianMatrix(m1);
		boolean expected = false;
		assertEquals(expected, actual);

	}

	@Test
	public void isUnitaryMatrixTest() throws Exception {
		ComplexMatrix m = new ComplexMatrix(new ComplexNumber[2][2]);
		m.getMatrix()[0][0] = new ComplexNumber(3, 2);
		m.getMatrix()[0][1] = new ComplexNumber(9, 5);
		m.getMatrix()[1][0] = new ComplexNumber(5, -6);
		m.getMatrix()[1][1] = new ComplexNumber(1, 4);
		boolean actual = ComplexOperations.isUnitaryMatrix(m);
		boolean expected = false;
		assertEquals(expected, actual);
	}

	@Test
	public void tensorProductTest() throws Exception {
		ComplexMatrix m1 = new ComplexMatrix(new ComplexNumber[2][2]);
		m1.getMatrix()[0][0] = new ComplexNumber(3, 2);
		m1.getMatrix()[0][1] = new ComplexNumber(5, -1);
		m1.getMatrix()[1][0] = new ComplexNumber(1, 2);
		m1.getMatrix()[1][1] = new ComplexNumber(6, 0);
		ComplexMatrix m2 = new ComplexMatrix(new ComplexNumber[3][3]);
		m2.getMatrix()[0][0] = new ComplexNumber(1, 0);
		m2.getMatrix()[0][1] = new ComplexNumber(3, 4);
		m2.getMatrix()[0][2] = new ComplexNumber(5, -7);
		m2.getMatrix()[1][0] = new ComplexNumber(10, 2);
		m2.getMatrix()[1][1] = new ComplexNumber(6, 0);
		m2.getMatrix()[1][2] = new ComplexNumber(2, 5);
		m2.getMatrix()[2][0] = new ComplexNumber(0, 0);
		m2.getMatrix()[2][1] = new ComplexNumber(1, 0);
		m2.getMatrix()[2][2] = new ComplexNumber(2, 9);
		ComplexMatrix expected = new ComplexMatrix(new ComplexNumber[6][6]);
		expected.getMatrix()[0][0] = new ComplexNumber(3, 2);
		expected.getMatrix()[0][1] = new ComplexNumber(1, 18);
		expected.getMatrix()[0][2] = new ComplexNumber(29, -11);
		expected.getMatrix()[0][3] = new ComplexNumber(5, 1);
		expected.getMatrix()[0][4] = new ComplexNumber(19, 17);
		expected.getMatrix()[0][5] = new ComplexNumber(18, -40);
		expected.getMatrix()[1][0] = new ComplexNumber(26, 26);
		expected.getMatrix()[1][1] = new ComplexNumber(18, 12);
		expected.getMatrix()[1][2] = new ComplexNumber(-4, 19);
		expected.getMatrix()[1][3] = new ComplexNumber(52, 0);
		expected.getMatrix()[1][4] = new ComplexNumber(30, -6);
		expected.getMatrix()[1][5] = new ComplexNumber(15, 23);
		expected.getMatrix()[2][0] = new ComplexNumber(0, 0);
		expected.getMatrix()[2][1] = new ComplexNumber(3, 2);
		expected.getMatrix()[2][2] = new ComplexNumber(-12, 31);
		expected.getMatrix()[2][3] = new ComplexNumber(0, 0);
		expected.getMatrix()[2][4] = new ComplexNumber(5, 1);
		expected.getMatrix()[2][5] = new ComplexNumber(19, 43);
		expected.getMatrix()[3][0] = new ComplexNumber(1, 2);
		expected.getMatrix()[3][1] = new ComplexNumber(-5, 10);
		expected.getMatrix()[3][2] = new ComplexNumber(19, 3);
		expected.getMatrix()[3][3] = new ComplexNumber(6, 0);
		expected.getMatrix()[3][4] = new ComplexNumber(18, 24);
		expected.getMatrix()[3][5] = new ComplexNumber(30, 42);
		expected.getMatrix()[4][0] = new ComplexNumber(6, 22);
		expected.getMatrix()[4][1] = new ComplexNumber(6, 12);
		expected.getMatrix()[4][2] = new ComplexNumber(-8, 9);
		expected.getMatrix()[4][3] = new ComplexNumber(60, 12);
		expected.getMatrix()[4][4] = new ComplexNumber(36, 0);
		expected.getMatrix()[4][5] = new ComplexNumber(12, 30);
		expected.getMatrix()[5][0] = new ComplexNumber(0, 0);
		expected.getMatrix()[5][1] = new ComplexNumber(1, 2);
		expected.getMatrix()[5][2] = new ComplexNumber(-16, 13);
		expected.getMatrix()[5][3] = new ComplexNumber(0, 0);
		expected.getMatrix()[5][4] = new ComplexNumber(6, 0);
		expected.getMatrix()[5][5] = new ComplexNumber(12, 54);
		ComplexMatrix actual = ComplexOperations.tensorProduct(m1, m2);
		assertEquals(expected, actual);
	}

	@Test
	public void vectorNormTest() {
		double[] v = new double[]{3,-6,2};
		double actual = ComplexOperations.vectorNorm(v);
		double expected = 7;
		assertEquals(expected, actual, 0);
	}

	@Test
	public void vectorDistanceTest() throws Exception {
		double[] v1 = new double[]{3,1,2};
		double[] v2 = new double[]{2,2,-1};
		double expected = Math.sqrt(11);
		double actual = ComplexOperations.vectorDistance(v1, v2);
		assertEquals(expected, actual,0);
	}

	@Test
	public void matrixNormTest() throws Exception {
		double[][] m = new double[2][2];
		m[0][0] = 3;
		m[0][1] = 5;
		m[1][0] = 2;
		m[1][1] = 3;
		double expected = Math.sqrt(47);
		double actual = ComplexOperations.matrixNorm(m);
		assertEquals(expected, actual, 0.7);
	}

	@Test
	public void matrixDistanceTest() throws Exception {
		double[][] m1 = new double[2][2];
		m1[0][0] = 3;
		m1[0][1] = 5;
		m1[1][0] = 2;
		m1[1][1] = 3;
		double[][] m2 = new double[2][2];
		m2[0][0] = 1;
		m2[0][1] = 6;
		m2[1][0] = 2;
		m2[1][1] = 4;
		double expected = 2.45;
		double actual = ComplexOperations.matrixDistance(m1, m2);
		assertEquals(expected, actual, 0.1);
	}

	@Test
	public void marblesExperimentTest() throws Exception {
		ComplexMatrix A = new ComplexMatrix(new ComplexNumber[3][3]);
		A.getMatrix()[0][0] = new ComplexNumber(1.0/Math.sqrt(2), 0);
		A.getMatrix()[0][1] = new ComplexNumber(1.0/Math.sqrt(2), 0);
		A.getMatrix()[0][2] = new ComplexNumber(0, 0);
		A.getMatrix()[1][0] = new ComplexNumber(0, -1.0/Math.sqrt(2));
		A.getMatrix()[1][1] = new ComplexNumber(0, 1.0/Math.sqrt(2));
		A.getMatrix()[1][2] = new ComplexNumber(0, 0);
		A.getMatrix()[2][0] = new ComplexNumber(0, 0);
		A.getMatrix()[2][1] = new ComplexNumber(0, 0);
		A.getMatrix()[2][2] = new ComplexNumber(0, 1);
		ComplexVector X = new ComplexVector(new ComplexNumber[3]);
		X.getVector()[0] = new ComplexNumber(1.0/Math.sqrt(3), 0);
		X.getVector()[1] = new ComplexNumber(0, 2.0/Math.sqrt(15));
		X.getVector()[2] = new ComplexNumber(Math.sqrt(2.0/5.0), 0);
		ComplexVector expected = new ComplexVector(new ComplexNumber[3]);
		expected.getVector()[0] = new ComplexNumber(1.0/Math.sqrt(6), 2.0/Math.sqrt(30));
		expected.getVector()[1] = new ComplexNumber(-2.0/Math.sqrt(30), -Math.sqrt(5)/Math.sqrt(30));
		expected.getVector()[2] = new ComplexNumber(0, Math.sqrt(2.0/5.0));
		ComplexVector actual = ComplexOperations.marblesExperiment(A, X, 1);
		assertEquals(expected, actual);
	}

	@Test
	public void multiSlitExperimentTest() throws Exception {
		int slits = 2;
		int targets = 5;
		Map<String, ComplexNumber> p = new HashMap<>();
		p.put("0 1", new ComplexNumber(1.0/Math.sqrt(2), 0));
		p.put("0 2", new ComplexNumber(1.0/Math.sqrt(2), 0));
		p.put("1 3", new ComplexNumber(-1.0/Math.sqrt(6), 1.0/Math.sqrt(6)));
		p.put("1 4", new ComplexNumber(-1.0/Math.sqrt(6), -1.0/Math.sqrt(6)));
		p.put("1 5", new ComplexNumber(1.0/Math.sqrt(6), -1.0/Math.sqrt(6)));
		p.put("2 5", new ComplexNumber(-1.0/Math.sqrt(6), 1.0/Math.sqrt(6)));
		p.put("2 6", new ComplexNumber(-1.0/Math.sqrt(6), -1.0/Math.sqrt(6)));
		p.put("2 7", new ComplexNumber(1.0/Math.sqrt(6), -1.0/Math.sqrt(6)));
		ComplexMatrix expectedMatrix = new ComplexMatrix(new ComplexNumber[8][8]);
		expectedMatrix.getMatrix()[0][0] = new ComplexNumber(0, 0);
		expectedMatrix.getMatrix()[0][1] = new ComplexNumber(0, 0);
		expectedMatrix.getMatrix()[0][2] = new ComplexNumber(0, 0);
		expectedMatrix.getMatrix()[0][3] = new ComplexNumber(0, 0);
		expectedMatrix.getMatrix()[0][4] = new ComplexNumber(0, 0);
		expectedMatrix.getMatrix()[0][5] = new ComplexNumber(0, 0);
		expectedMatrix.getMatrix()[0][6] = new ComplexNumber(0, 0);
		expectedMatrix.getMatrix()[0][7] = new ComplexNumber(0, 0);
		expectedMatrix.getMatrix()[1][0] = new ComplexNumber(0, 0);
		expectedMatrix.getMatrix()[1][1] = new ComplexNumber(0, 0);
		expectedMatrix.getMatrix()[1][2] = new ComplexNumber(0, 0);
		expectedMatrix.getMatrix()[1][3] = new ComplexNumber(0, 0);
		expectedMatrix.getMatrix()[1][4] = new ComplexNumber(0, 0);
		expectedMatrix.getMatrix()[1][5] = new ComplexNumber(0, 0);
		expectedMatrix.getMatrix()[1][6] = new ComplexNumber(0, 0);
		expectedMatrix.getMatrix()[1][7] = new ComplexNumber(0, 0);
		expectedMatrix.getMatrix()[2][0] = new ComplexNumber(0, 0);
		expectedMatrix.getMatrix()[2][1] = new ComplexNumber(0, 0);
		expectedMatrix.getMatrix()[2][2] = new ComplexNumber(0, 0);
		expectedMatrix.getMatrix()[2][3] = new ComplexNumber(0, 0);
		expectedMatrix.getMatrix()[2][4] = new ComplexNumber(0, 0);
		expectedMatrix.getMatrix()[2][5] = new ComplexNumber(0, 0);
		expectedMatrix.getMatrix()[2][6] = new ComplexNumber(0, 0);
		expectedMatrix.getMatrix()[2][7] = new ComplexNumber(0, 0);
		expectedMatrix.getMatrix()[3][0] = new ComplexNumber(-1.0/Math.sqrt(12), 1.0/Math.sqrt(12));
		expectedMatrix.getMatrix()[3][1] = new ComplexNumber(-1.0/Math.sqrt(6), 1.0/Math.sqrt(6));
		expectedMatrix.getMatrix()[3][2] = new ComplexNumber(0, 0);
		expectedMatrix.getMatrix()[3][3] = new ComplexNumber(1, 0);
		expectedMatrix.getMatrix()[3][4] = new ComplexNumber(0, 0);
		expectedMatrix.getMatrix()[3][5] = new ComplexNumber(0, 0);
		expectedMatrix.getMatrix()[3][6] = new ComplexNumber(0, 0);
		expectedMatrix.getMatrix()[3][7] = new ComplexNumber(0, 0);
		expectedMatrix.getMatrix()[4][0] = new ComplexNumber(-1.0/Math.sqrt(12), -1.0/Math.sqrt(12));
		expectedMatrix.getMatrix()[4][1] = new ComplexNumber(-1.0/Math.sqrt(6), -1.0/Math.sqrt(6));
		expectedMatrix.getMatrix()[4][2] = new ComplexNumber(0, 0);
		expectedMatrix.getMatrix()[4][3] = new ComplexNumber(0, 0);
		expectedMatrix.getMatrix()[4][4] = new ComplexNumber(1, 0);
		expectedMatrix.getMatrix()[4][5] = new ComplexNumber(0, 0);
		expectedMatrix.getMatrix()[4][6] = new ComplexNumber(0, 0);
		expectedMatrix.getMatrix()[4][7] = new ComplexNumber(0, 0);
		expectedMatrix.getMatrix()[5][0] = new ComplexNumber(0, 0);
		expectedMatrix.getMatrix()[5][1] = new ComplexNumber(1.0/Math.sqrt(6), -1.0/Math.sqrt(6));
		expectedMatrix.getMatrix()[5][2] = new ComplexNumber(-1.0/Math.sqrt(6), 1.0/Math.sqrt(6));
		expectedMatrix.getMatrix()[5][3] = new ComplexNumber(0, 0);
		expectedMatrix.getMatrix()[5][4] = new ComplexNumber(0, 0);
		expectedMatrix.getMatrix()[5][5] = new ComplexNumber(1, 0);
		expectedMatrix.getMatrix()[5][6] = new ComplexNumber(0, 0);
		expectedMatrix.getMatrix()[5][7] = new ComplexNumber(0, 0);
		expectedMatrix.getMatrix()[6][0] = new ComplexNumber(-1.0/Math.sqrt(12), -1.0/Math.sqrt(12));
		expectedMatrix.getMatrix()[6][1] = new ComplexNumber(0, 0);
		expectedMatrix.getMatrix()[6][2] = new ComplexNumber(-1.0/Math.sqrt(6), -1.0/Math.sqrt(6));
		expectedMatrix.getMatrix()[6][3] = new ComplexNumber(0, 0);
		expectedMatrix.getMatrix()[6][4] = new ComplexNumber(0, 0);
		expectedMatrix.getMatrix()[6][5] = new ComplexNumber(0, 0);
		expectedMatrix.getMatrix()[6][6] = new ComplexNumber(1, 0);
		expectedMatrix.getMatrix()[6][7] = new ComplexNumber(0, 0);
		expectedMatrix.getMatrix()[7][0] = new ComplexNumber(1.0/Math.sqrt(12), -1.0/Math.sqrt(12));
		expectedMatrix.getMatrix()[7][1] = new ComplexNumber(0, 0);
		expectedMatrix.getMatrix()[7][2] = new ComplexNumber(1.0/Math.sqrt(6), -1.0/Math.sqrt(6));
		expectedMatrix.getMatrix()[7][3] = new ComplexNumber(0, 0);
		expectedMatrix.getMatrix()[7][4] = new ComplexNumber(0, 0);
		expectedMatrix.getMatrix()[7][5] = new ComplexNumber(0, 0);
		expectedMatrix.getMatrix()[7][6] = new ComplexNumber(0, 0);
		expectedMatrix.getMatrix()[7][7] = new ComplexNumber(1, 0);
		ComplexMatrix actualMatrix = (ComplexMatrix) ComplexOperations.multiSlitExperiment(slits, targets, p).get(0);
		ComplexVector expectedVector = new ComplexVector(new ComplexNumber[8]);
		expectedVector.getVector()[0] = new ComplexNumber(0,0);
		expectedVector.getVector()[1] = new ComplexNumber(0,0);
		expectedVector.getVector()[2] = new ComplexNumber(0,0);
		expectedVector.getVector()[3] = new ComplexNumber(-1.0/Math.sqrt(12), 1.0/Math.sqrt(12));
		expectedVector.getVector()[4] = new ComplexNumber(-1.0/Math.sqrt(12), -1.0/Math.sqrt(12));
		expectedVector.getVector()[5] = new ComplexNumber(0,0);
		expectedVector.getVector()[6] = new ComplexNumber(-1.0/Math.sqrt(12), -1.0/Math.sqrt(12));
		expectedVector.getVector()[7] = new ComplexNumber(1.0/Math.sqrt(12), -1.0/Math.sqrt(12));
		ComplexVector actualVector = (ComplexVector) ComplexOperations.multiSlitExperiment(slits, targets, p).get(1);
		assertEquals(expectedMatrix, actualMatrix);
		assertEquals(expectedVector, actualVector);
	}

	@Test
	public void probabilityTest() {
		ComplexVector state = new ComplexVector(new ComplexNumber[4]);
		state.getVector()[0] = new ComplexNumber(-3,-1);
		state.getVector()[1] = new ComplexNumber(0,-2);
		state.getVector()[2] = new ComplexNumber(0,1);
		state.getVector()[3] = new ComplexNumber(2,0);
		int position = 2;
		Double expected = 0.052624;
		Double actual = ComplexOperations.probability(state, position);
		assertEquals(expected, actual, 0.0001);
	}

	@Test
	public void transitionAmplitudeTest() throws Exception {
		ComplexVector startState = new ComplexVector(new ComplexNumber[2]);
		startState.getVector()[0] = new ComplexNumber(Math.sqrt(2) / 2, 0);
		startState.getVector()[1] = new ComplexNumber(0, Math.sqrt(2) / 2);
		ComplexVector endState = new ComplexVector(new ComplexNumber[2]);
		endState.getVector()[0] = new ComplexNumber(0,Math.sqrt(2) / 2);
		endState.getVector()[1] = new ComplexNumber(-Math.sqrt(2) / 2, 0);
		ComplexNumber expected = new ComplexNumber(0, -1);
		ComplexNumber actual = ComplexOperations.transitionAmplitude(startState, endState);
		assertEquals(expected, actual);
	}

	@Test
	public void meanValueTest() throws Exception {
		ComplexVector ket = new ComplexVector(new ComplexNumber[2]);
		ket.getVector()[0] = new ComplexNumber(Math.sqrt(2) / 2, 0);
		ket.getVector()[1] = new ComplexNumber(0, Math.sqrt(2) / 2);
		ComplexMatrix observable = new ComplexMatrix(new ComplexNumber[2][2]);
		observable.getMatrix()[0][0] = new ComplexNumber(1, 0);
		observable.getMatrix()[0][1] = new ComplexNumber(0, -1);
		observable.getMatrix()[1][0] = new ComplexNumber(0, 1);
		observable.getMatrix()[1][1] = new ComplexNumber(2, 0);
		ComplexNumber expected = new ComplexNumber(2.5, 0);
		ComplexNumber actual = ComplexOperations.meanValue(ket, observable);
		assertEquals(expected, actual);
	}

	@Test
	public void varianceTest() throws Exception {
		ComplexVector ket = new ComplexVector(new ComplexNumber[2]);
		ket.getVector()[0] = new ComplexNumber(Math.sqrt(2) / 2, 0);
		ket.getVector()[1] = new ComplexNumber(0, Math.sqrt(2) / 2);
		ComplexMatrix observable = new ComplexMatrix(new ComplexNumber[2][2]);
		observable.getMatrix()[0][0] = new ComplexNumber(1, 0);
		observable.getMatrix()[0][1] = new ComplexNumber(0, -1);
		observable.getMatrix()[1][0] = new ComplexNumber(0, 1);
		observable.getMatrix()[1][1] = new ComplexNumber(2, 0);
		ComplexNumber expected = new ComplexNumber(0.25, 0);
		ComplexNumber actual = ComplexOperations.variance(ket, observable);
		assertEquals(expected, actual);
	}

	@Test
	public void dynamicsTest() throws Exception{
		ComplexVector initialState = new ComplexVector(new ComplexNumber[4]);
		initialState.getVector()[0] = new ComplexNumber(1, 0);
		initialState.getVector()[1] = new ComplexNumber(0,0);
		initialState.getVector()[2] = new ComplexNumber(0,0);
		initialState.getVector()[3] = new ComplexNumber(0,0);
		ComplexMatrix Un = new ComplexMatrix(new ComplexNumber[4][4]);
		Un.getMatrix()[0][0] = new ComplexNumber(0,0);
		Un.getMatrix()[0][1] = new ComplexNumber(1/Math.sqrt(2), 0);
		Un.getMatrix()[0][2] = new ComplexNumber(1/Math.sqrt(2), 0);
		Un.getMatrix()[0][3] = new ComplexNumber(0,0);
		Un.getMatrix()[1][0] = new ComplexNumber(0, 1/Math.sqrt(2));
		Un.getMatrix()[1][1] = new ComplexNumber(0,0);
		Un.getMatrix()[1][2] = new ComplexNumber(0,0);
		Un.getMatrix()[1][3] = new ComplexNumber(1/Math.sqrt(2), 0);
		Un.getMatrix()[2][0] = new ComplexNumber(1/Math.sqrt(2), 0);
		Un.getMatrix()[2][1] = new ComplexNumber(0,0);
		Un.getMatrix()[2][2] = new ComplexNumber(0,0);
		Un.getMatrix()[2][3] = new ComplexNumber(0, 1/Math.sqrt(2));
		Un.getMatrix()[3][0] = new ComplexNumber(0,0);
		Un.getMatrix()[3][1] = new ComplexNumber(1/Math.sqrt(2), 0);
		Un.getMatrix()[3][2] = new ComplexNumber(-1/Math.sqrt(2), 0);
		Un.getMatrix()[3][3] = new ComplexNumber(0,0);
		ComplexVector expected = new ComplexVector(new ComplexNumber[4]);
		expected.getVector()[0] = new ComplexNumber(-0.4999, 0.49999);
		expected.getVector()[1] = new ComplexNumber(0,0);
		expected.getVector()[2] = new ComplexNumber(0,0);
		expected.getVector()[3] = new ComplexNumber(-0.4999, 0.49999);
		ComplexVector actual = ComplexOperations.dynamics(Un, initialState, 3);
//		for (int i = 0; i < actual.getVector().length; i++) {
//			System.out.println("actual: " + actual.getVector()[i].getComplexNumber());
//			System.out.println("expected: " + expected.getVector()[i].getComplexNumber());
//		}
//		for (int i = 0; i < actual.getVector().length; i++) {
//			System.out.println(expected.getVector()[i].equals(actual.getVector()[i]));
//		}
		assertEquals(expected, actual);

	}
}