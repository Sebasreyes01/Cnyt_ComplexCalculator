package com.edu.eci.ieti.complexCalculator;

import java.text.DecimalFormat;

public class ComplexOperations {

	public static ComplexNumber sum(ComplexNumber c1, ComplexNumber c2) {
		return new ComplexNumber(c1.getRealNumber() + c2.getRealNumber(), c1.getImaginaryNumber() + c2.getImaginaryNumber());
	}

	public static ComplexNumber subtraction(ComplexNumber c1, ComplexNumber c2) {
		return new ComplexNumber(c1.getRealNumber() - c2.getRealNumber(), c1.getImaginaryNumber() - c2.getImaginaryNumber());
	}

	public static ComplexNumber multiplication(ComplexNumber c1, ComplexNumber c2) {
		double realNumber = (c1.getRealNumber() * c2.getRealNumber()) - (c1.getImaginaryNumber() * c2.getImaginaryNumber());
		double imaginaryNumber = (c1.getRealNumber() * c2.getImaginaryNumber()) + (c2.getRealNumber() * c1.getImaginaryNumber());
		return new ComplexNumber(realNumber, imaginaryNumber);
	}

	public static ComplexNumber division(ComplexNumber c1, ComplexNumber c2) {
		double realNumerator = (c1.getRealNumber() * c2.getRealNumber()) + (c1.getImaginaryNumber() * c2.getImaginaryNumber());
		double imaginaryNumerator = (c2.getRealNumber() * c1.getImaginaryNumber()) - (c1.getRealNumber() * c2.getImaginaryNumber());
		double denominator = Math.pow(c2.getRealNumber(), 2) + Math.pow(c2.getImaginaryNumber(), 2);
		return new ComplexNumber(Math.round((realNumerator / denominator) * 100.0) / 100.0, Math.round((imaginaryNumerator / denominator) * 100.0) / 100.0);
	}

	public static ComplexNumber polarToCartesian(double p, double t) {
		double a = p * Math.cos(t);
		double b = p * Math.sin(t);
		return new ComplexNumber(Math.round(a * 100.0) / 100.0,Math.round(b * 100.0) / 100.0);
	}

	public static String cartesianToPolar(ComplexNumber c1) {
		double p = Math.sqrt(Math.pow(c1.getRealNumber(), 2) + Math.pow(c1.getImaginaryNumber(), 2));
		double t = Math.atan2(c1.getImaginaryNumber(), c1.getRealNumber());
		DecimalFormat df = new DecimalFormat("#.##");
		return "(" + df.format(p) + ", " + df.format(t) +")";
	}

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

	public static ComplexVector vectorScalarMultiplication(ComplexNumber c, ComplexVector v) {
		ComplexVector r = new ComplexVector(new ComplexNumber[v.getVector().length]);
		for(int i = 0; i < v.getVector().length; i++) {
			r.getVector()[i] = ComplexOperations.multiplication(c, v.getVector()[i]);
		}
		return r;
	}

	private static ComplexMatrix createMatrix(int i, int j) {
		ComplexMatrix r =null;
		try {
			r = new ComplexMatrix(new ComplexNumber[i][j]);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return r;
	}

	public static ComplexMatrix matrixAddition(ComplexMatrix m1, ComplexMatrix m2) throws Exception {
		if (m1.getMatrix().length != m2.getMatrix().length || m1.getMatrix()[0].length != m2.getMatrix().length) {
			throw new Exception("The matrices have to be the same size");
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

	public static ComplexMatrix matrixScalarMultiplication(ComplexNumber c, ComplexMatrix m) {
		ComplexMatrix r = createMatrix(m.getMatrix().length, m.getMatrix()[0].length);
		for(int i = 0; i < m.getMatrix().length; i++) {
			for (int j = 0; j < m.getMatrix()[0].length;j++) {
				r.getMatrix()[i][j] = multiplication(c, m.getMatrix()[i][j]);
			}
		}
		return r;
	}

}
