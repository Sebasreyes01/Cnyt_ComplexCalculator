package com.edu.eci.ieti.complexCalculator;

import java.text.DecimalFormat;

public class ComplexOperations {

	/**
	 * Calculates the sum of 2 complex numbers.
	 * @param c1 The first complex number of the sum.
	 * @param c2 The second complex number of the sum.
	 * @return The sum of 2 complex numbers.
	 */
	public static ComplexNumber sum(ComplexNumber c1, ComplexNumber c2) {
		return new ComplexNumber(c1.getRealNumber() + c2.getRealNumber(), c1.getImaginaryNumber() + c2.getImaginaryNumber());
	}

	/**
	 * Calculates the subtraction of 2 complex numbers.
	 * @param c1 The first complex number of the subtraction.
	 * @param c2 The second complex number of the subtraction.
	 * @return The subtraction of 2 complex numbers.
	 */
	public static ComplexNumber subtraction(ComplexNumber c1, ComplexNumber c2) {
		return new ComplexNumber(c1.getRealNumber() - c2.getRealNumber(), c1.getImaginaryNumber() - c2.getImaginaryNumber());
	}

	/**
	 * Calculates the multiplication of 2 complex numbers.
	 * @param c1 The first complex number of the multiplication.
	 * @param c2 The second complex number of the multiplication.
	 * @return The multiplication of 2 complex numbers.
	 */
	public static ComplexNumber multiplication(ComplexNumber c1, ComplexNumber c2) {
		double realNumber = (c1.getRealNumber() * c2.getRealNumber()) - (c1.getImaginaryNumber() * c2.getImaginaryNumber());
		double imaginaryNumber = (c1.getRealNumber() * c2.getImaginaryNumber()) + (c2.getRealNumber() * c1.getImaginaryNumber());
		return new ComplexNumber(realNumber, imaginaryNumber);
	}

	/**
	 * Calculates the division of 2 complex numbers.
	 * @param c1 The first complex number of the division.
	 * @param c2 The second complex number of the division.
	 * @return The division of 2 complex numbers.
	 */
	public static ComplexNumber division(ComplexNumber c1, ComplexNumber c2) {
		double realNumerator = (c1.getRealNumber() * c2.getRealNumber()) + (c1.getImaginaryNumber() * c2.getImaginaryNumber());
		double imaginaryNumerator = (c2.getRealNumber() * c1.getImaginaryNumber()) - (c1.getRealNumber() * c2.getImaginaryNumber());
		double denominator = Math.pow(c2.getRealNumber(), 2) + Math.pow(c2.getImaginaryNumber(), 2);
		return new ComplexNumber(Math.round((realNumerator / denominator) * 100.0) / 100.0, Math.round((imaginaryNumerator / denominator) * 100.0) / 100.0);
	}

	/**
	 * Calculates the cartesian form of a polar complex number.
	 * @param p The phase of the polar complex number.
	 * @param t The angle of the polar complex number.
	 * @return The cartesian representation of a polar complex number.
	 */
	public static ComplexNumber polarToCartesian(double p, double t) {
		double a = p * Math.cos(t);
		double b = p * Math.sin(t);
		return new ComplexNumber(Math.round(a * 100.0) / 100.0,Math.round(b * 100.0) / 100.0);
	}

	/**
	 * Calculates the polar form of a cartesian complex number.
	 * @param c1 The cartesian complex number.
	 * @return The polar representation of a cartesian complex number.
	 */
	public static String cartesianToPolar(ComplexNumber c1) {
		double p = Math.sqrt(Math.pow(c1.getRealNumber(), 2) + Math.pow(c1.getImaginaryNumber(), 2));
		double t = Math.atan2(c1.getImaginaryNumber(), c1.getRealNumber());
		DecimalFormat df = new DecimalFormat("#.##");
		return "(" + df.format(p) + ", " + df.format(t) +")";
	}

	/**
	 * Calculates the addition of 2 complex vectors.
	 * @param v1 The first complex vector of the addition.
	 * @param v2 The second complex vector of the addition.
	 * @return The addition of 2 complex numbers.
	 * @throws Exception The length of the vectors is not the same.
	 */
	public static ComplexVector vectorsAddition(ComplexVector v1, ComplexVector v2) throws Exception{
		if (v1.getVector().length != v2.getVector().length) {
			throw new Exception("The length of the vectors is not the same");
		} else {
			ComplexVector r = new ComplexVector(new ComplexNumber[v1.getVector().length]);
			for(int i = 0; i < v1.getVector().length; i++) {
				r.getVector()[i] = ComplexOperations.sum(v1.getVector()[i], v2.getVector()[i]);
			}
			return r;
		}
	}

	/**
	 * Calculates the scalar multiplication of a complex number and a complex vector.
	 * @param c The complex number of the scalar multiplication.
	 * @param v The complex vector of the scalar multiplication.
	 * @return The scalar multiplication of a complex number and a complex vector.
	 */
	public static ComplexVector vectorScalarMultiplication(ComplexNumber c, ComplexVector v) {
		ComplexVector r = new ComplexVector(new ComplexNumber[v.getVector().length]);
		for(int i = 0; i < v.getVector().length; i++) {
			r.getVector()[i] = ComplexOperations.multiplication(c, v.getVector()[i]);
		}
		return r;
	}

	/**
	 * Creates a complex matrix.
	 * @param i The number of rows.
	 * @param j The number of columns.
	 * @return A complex matrix.
	 */
	private static ComplexMatrix createMatrix(int i, int j) {
		ComplexMatrix r =null;
		try {
			r = new ComplexMatrix(new ComplexNumber[i][j]);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return r;
	}

	/**
	 * Calculates the addition of 2 matrices.
	 * @param m1 The first matrix of the addition.
	 * @param m2 The second matrix of the addition.
	 * @return The addition of 2 matrices.
	 * @throws Exception The matrices must be the same size.
	 */
	public static ComplexMatrix matrixAddition(ComplexMatrix m1, ComplexMatrix m2) throws Exception {
		if (m1.getMatrix().length != m2.getMatrix().length || m1.getMatrix()[0].length != m2.getMatrix().length) {
			throw new Exception("The matrices must be the same size");
		} else {
			ComplexMatrix r = createMatrix(m1.getMatrix().length, m1.getMatrix()[0].length);
			for (int i = 0; i < m1.getMatrix().length; i++) {
				for (int j = 0 ; j < m1.getMatrix()[0].length; j++) {
					r.getMatrix()[i][j] = sum(m1.getMatrix()[i][j], m2.getMatrix()[i][j]);
				}
			}
			return r;
		}
	}

	/**
	 * Calculates the scalar multiplication of a complex number and a matrix.
	 * @param c The complex number.
	 * @param m The complex matrix.
	 * @return The scalar multiplication of a complex number and a complex matrix.
	 */
	public static ComplexMatrix matrixScalarMultiplication(ComplexNumber c, ComplexMatrix m) {
		ComplexMatrix r = createMatrix(m.getMatrix().length, m.getMatrix()[0].length);
		for(int i = 0; i < m.getMatrix().length; i++) {
			for (int j = 0; j < m.getMatrix()[0].length;j++) {
				r.getMatrix()[i][j] = multiplication(c, m.getMatrix()[i][j]);
			}
		}
		return r;
	}

	/**
	 * Calculates the multiplication of 2 complex square matrix.
	 * @param m1 The first complex square matrix of the multiplication.
	 * @param m2 The second complex square matrix of the multiplication.
	 * @return The multiplication of the 2 complex square matrices.
	 * @throws Exception The matrices are not square.
	 */
	public static ComplexMatrix matrixMultiplication(ComplexMatrix m1, ComplexMatrix m2) throws Exception {
		if (m1.getMatrix().length != m2.getMatrix()[0].length) {
			throw new Exception("The matrices are not square");
		} else {
			ComplexMatrix r = createMatrix(m1.getMatrix().length, m1.getMatrix()[0].length);
			for (int i = 0; i < m2.getMatrix()[0].length;i++) {
				for (int j = 0; j < m1.getMatrix()[0].length; j++) {
					r.getMatrix()[i][j] = multiplication(m1.getMatrix()[i][j],m2.getMatrix()[j][i]);
				}
			}
			return r;
		}
	}
}
