package com.edu.eci.ieti.complexCalculator;

import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Map;

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
			ComplexNumber s = new ComplexNumber(0,0);
			for (int m = 0; m < m1.getMatrix().length; m++) {
				for (int n = 0; n < m1.getMatrix()[0].length; n++) {
					for (int i = 0; i < m1.getMatrix().length; i++) {
						s = sum(s, multiplication(m1.getMatrix()[m][i], m2.getMatrix()[i][n]));
					}
					r.getMatrix()[m][n] = s;
					s = new ComplexNumber(0,0);
				}
			}
			return r;
		}
	}

	/**
	 * Calculates the action of the matrix over the vector.
 	 * @param m The given matrix.
	 * @param v The given vector.
	 * @return The action of the matrix over the vector.
	 * @throws Exception The length of the matrix's rows are different to the length of the vector.
	 */
	public static ComplexVector actionMatrixVector(ComplexMatrix m, ComplexVector v) throws Exception{
		if (m.getMatrix()[0].length != v.getVector().length) {
			throw new Exception("The length of the matrix's rows are different to the length of the vector");
		} else {
			ComplexVector r = new ComplexVector(new ComplexNumber[v.getVector().length]);
			ComplexNumber s = new ComplexNumber(0,0);
			for (int i = 0; i < v.getVector().length; i++) {
				for (int j = 0; j < m.getMatrix()[0].length; j++) {
					s = sum(s, multiplication(m.getMatrix()[i][j], v.getVector()[j]));
				}
				r.getVector()[i] = s;
				s = new ComplexNumber(0,0);
			}
			return r;
		}
	}

	/**
	 * Calculates the inner product of 2 given vectors.
	 * @param v1 The first given vector.
	 * @param v2 The second given vector.
	 * @return The inner product of 2 vectors.
	 * @throws Exception The length of the 2 vectors is different.
	 */
	public static ComplexNumber vectorInnerProduct(ComplexVector v1, ComplexVector v2) throws Exception {
		if (v1.getVector().length != v2.getVector().length) {
			throw new Exception("The length of the 2 vectors is different");
		} else {
			ComplexNumber r = new ComplexNumber(0,0);
			for (int i = 0; i < v1.getVector().length;i++) {
				r = sum(r, multiplication(v1.conjugate().getVector()[i], v2.getVector()[i]));
			}
			return r;
		}
	}

	/**
	 * Calculates the norm of a real vector.
	 * @param v The given real vector.
	 * @return The norm of the vector.
	 */
	public static double vectorNorm(double[] v) {
		double v2 = 0;
		for (int i = 0; i < v.length; i++) {
			v2 = v2 + v[i] * v[i];
		}
		double r = Math.sqrt(v2);
		return r;
	}

	/**
	 * Calculates the norm of a real matrix.
	 * @param m The given real matrix.
	 * @return The norm of a real matrix.
	 * @throws Exception "The matrix is not square".
	 */
	public static double matrixNorm(double[][] m) throws Exception{
		if (m.length != m[0].length) {
			throw new Exception("The matrix is not square");
		} else {
			double[][] mt = new double[m.length][m[0].length];
			for (int i = 0;i < mt.length;i++) {
				for (int j = 0;j < mt.length;j++) {
					mt[i][j] = m[j][i];
				}
			}
			double[][] r = new double[m.length][m[0].length];
			double s = 0;
			for (int i = 0; i < mt.length; i++) {
				for (int j = 0; j < mt[0].length; j++) {
					for (int k = 0; k < mt.length; k++) {
						s = s + (mt[i][k] * m[i][j]);
					}
					r[i][j] = s;
					s = 0;
				}
			}
			double trace = 0;
			for (int i = 0; i < r.length; i++) {
				trace = trace + r[i][i];
			}
			return Math.sqrt(trace);
		}
	}

	/**
	 * Calculates the distance of 2 real vectors.
	 * @param v1 The first given vector.
	 * @param v2 The second given vector.
	 * @return The distance between 2 real vectors.
	 * @throws Exception The vector have different size.
	 */
	public static double vectorDistance(double[] v1, double[] v2) throws Exception{
		if (v1.length != v2.length) {
			throw new Exception("The vector have different size");
		} else {
			double s = 0;
			for (int i = 0; i < v1.length; i++ ) {
				s = s + ((v1[i] - v2[i]) * (v1[i] - v2[i]));
			}
			double r = Math.sqrt(s);
			return r;
		}
	}

	/**
	 * Calculates the distance of 2 real matrices.
	 * @param m1 The first given matrix.
	 * @param m2 The second given matrix.
	 * @return The sitance of 2 real matrices.
	 * @throws Exception "The matrix is not square".
	 */
	public static double matrixDistance(double[][] m1, double[][] m2) throws Exception {
		if (m1.length != m1[0].length) {
			throw new Exception("The matrix is not square");
		} else {
			double ms[][] = new double[m1.length][m1[0].length];
			for (int i = 0; i < ms.length; i++) {
				for (int j = 0; j < ms[0].length; j++) {
					ms[i][j] = m1[i][j] - m2[i][j];
				}
			}
			double[][] mt = new double[ms.length][ms[0].length];
			for (int i = 0;i < mt.length;i++) {
				for (int j = 0;j < mt.length;j++) {
					mt[i][j] = ms[j][i];
				}
			}
			double[][] r = new double[mt.length][mt[0].length];
			double s = 0;
			for (int i = 0; i < mt.length; i++) {
				for (int j = 0; j < mt[0].length; j++) {
					for (int k = 0; k < mt.length; k++) {
						s = s + (mt[i][k] * ms[i][j]);
					}
					r[i][j] = s;
					s = 0;
				}
			}
			double trace = 0;
			for (int i = 0; i < r.length; i++) {
				trace = trace + r[i][i];
			}
			return Math.sqrt(trace);
		}
	}

	/**
	 * Determines if a matrix is hermitian.
	 * @param m The given matrix.
	 * @return True or false depending if the matrix is hermitian.
	 * @throws Exception The matrix is not square.
	 */
	public static boolean isHermitianMatrix(ComplexMatrix m) throws Exception {
		if (m.getMatrix().length != m.getMatrix()[0].length) {
			throw new Exception("The matrix is not square");
		} else {
			return m.equals(m.adjoint());
		}
	}

	/**
	 * Determines if a matrix is unitary.
	 * @param m The given matrix.
	 * @return True or false depending if the matrix is unitary.
	 * @throws Exception The matrix is not square.
	 */
	public static boolean isUnitaryMatrix(ComplexMatrix m) throws Exception {
		if(m .getMatrix().length != m.getMatrix()[0].length) {
			throw new Exception("The matrix is not square");
		} else {
			return matrixMultiplication(m, m.adjoint()).equals(matrixMultiplication(m.adjoint(), m));
		}
	}

	/**
	 * Calculates the tensor product of 2 complex matrices.
	 * @param m1 The first given matrix.
	 * @param m2 The second given matrix.
	 * @return The tensor product of 2 given matrices.
	 */
	public static ComplexMatrix tensorProduct(ComplexMatrix m1, ComplexMatrix m2) {
		ComplexMatrix r = createMatrix(m1.getMatrix().length * m2.getMatrix().length, m1.getMatrix()[0].length * m2.getMatrix()[0].length);
		ComplexMatrix sp;
		int m = 0;
		int n = 0;
		for (int i = 0; i < m1.getMatrix().length; i++) {
			for (int j = 0; j < m1.getMatrix()[0].length; j++) {
				sp = matrixScalarMultiplication(m1.getMatrix()[i][j], m2);
				for(int k = 0; k < sp.getMatrix().length; k++) {
					for(int l = 0; l < sp.getMatrix()[0].length; l++) {
						r.getMatrix()[m][n] = sp.getMatrix()[k][l];
						n++;
					}
					m++;
					n = j * m2.getMatrix()[0].length;
				}
				m = i * m2.getMatrix().length;
				n = (j + 1) * m2.getMatrix()[0].length;
			}
			m = (i + 1) * m2.getMatrix().length;
			n = 0;
		}
		return r;
	}

	/**
	 * Performs the marbles experiment.
	 * @param A The matrix of the change of the state.
	 * @param X The vector of the state.
	 * @param t The amount of time clicks.
	 * @return The state after t clicks.
	 * @throws Exception The length of the matrix's rows are different to the length of the vector.
	 */
	public static ComplexVector marblesExperiment(ComplexMatrix A, ComplexVector X, int t) throws Exception {
		ComplexVector r = X;
		for (int i = 0; i < t; i++) {
			r = actionMatrixVector(A, r);
		}
		return r;
	}

	/**
	 * Calculates the multislit experiment.
	 * @param slits The number of slits in the experiment
	 * @param targets The number of targets in the experiment.
	 * @param p The probabilities in each arrow. Ex. The probability between 0 and 1 must be gives as "0 1":1/2
	 * @return A list with the matrix after 2 time clicks and the vector state.
	 * @throws Exception The matrices are not square.
	 */
	public static ArrayList<Object> multiSlitExperiment(int slits, int targets, Map p) throws Exception {
		ComplexMatrix A = createMatrix(slits+targets+1, slits+targets+1);
		for(int i = 0; i < slits+targets+1; i++) {
			for(int j = 0; j < slits+targets+1; j++) {
				if(p.containsKey(Integer.toString(i) + " " + Integer.toString(j))) {
					A.getMatrix()[j][i] = (ComplexNumber) p.get(Integer.toString(i) + " " + Integer.toString(j));
				} else {
					A.getMatrix()[j][i] = new ComplexNumber(0,0);
				}
			}
		}
		for (int i = 0; i < slits+1; i++) {
			A.getMatrix()[i][i] = new ComplexNumber(0,0);
		}
		for (int i = slits + 1; i < slits+targets+1;i++) {
			A.getMatrix()[i][i] = new ComplexNumber(1,0);
		}
		ComplexVector X = new ComplexVector(new ComplexNumber[slits+targets+1]);
		X.getVector()[0] = new ComplexNumber(1, 0);
		for (int i = 1; i < X.getVector().length;i++) {
			X.getVector()[i] = new ComplexNumber(0,0);
		}
		ArrayList<Object> r = new ArrayList<>();
		r.add(matrixMultiplication(A,A));
		r.add(actionMatrixVector(matrixMultiplication(A,A), X));
		return r;
	}

	/**
	 * Calculates the probability that a particle can be found at a given position.
	 * @param state The state vector.
	 * @param position The given position.
	 * @return The probability.
	 */
	public static double probability(ComplexVector state, int position) {
		Double n = 0.0;
		for(int i = 0; i < state.getVector().length;i++) {
			n += Math.pow(state.getVector()[i].modulus(), 2);
		}
		Double norm = Math.sqrt(n);
		Double prob = Math.pow(state.getVector()[position].modulus(),2) / Math.pow(norm, 2);
		return prob;
	}

	/**
	 * Calculates the likelihood of transition from one state to another.
	 * @param startState The state before measurement.
	 * @param endState The state after measurement.
	 * @return The probability of transition from one state to another.
	 * @throws Exception The length of the 2 vectors is different.
	 */
	public static ComplexNumber transitionAmplitude(ComplexVector startState, ComplexVector endState) throws Exception {
		ComplexVector bra = endState.conjugate();
		ComplexNumber ans = vectorInnerProduct(endState, startState);
		return ans;
	}

	/**
	 * Calculates the mean value.
	 * @param ket The vector ket.
	 * @param observable The matrix of the observable.
	 * @return The mean value.
	 * @throws Exception The length of the matrix's rows are different to the length of the vector.
	 * @throws Exception The length of the 2 vectors is different.
	 * @throws Exception The matrix is not hermitian.
	 */
	public static ComplexNumber meanValue(ComplexVector ket, ComplexMatrix observable) throws Exception {
			ComplexVector omegaKet = actionMatrixVector(observable, ket);
			ComplexNumber ans = vectorInnerProduct(omegaKet, ket);
			return ans;

	}

	/**
	 * Calculates the variance.
	 * @param ket The vector ket.
	 * @param observable The matrix observable.
	 * @return The variance.
	 * @throws Exception The matrix is not hermitian.
	 */
	public static ComplexNumber variance(ComplexVector ket, ComplexMatrix observable) throws Exception {
			ComplexNumber mean = meanValue(ket, observable);
			ComplexMatrix m = new ComplexMatrix(new ComplexNumber[2][2]);
			m.getMatrix()[0][0] = mean;
			m.getMatrix()[0][1] = new ComplexNumber(0, 0);
			m.getMatrix()[1][0] = new ComplexNumber(0, 0);
			m.getMatrix()[1][1] = mean;
			ComplexMatrix subtraction = matrixAddition(observable, m.inverse());
			ComplexMatrix temp = matrixMultiplication(subtraction, subtraction);
			ComplexVector act = actionMatrixVector(temp, ket);
			ComplexNumber ans = vectorInnerProduct(ket, act);
			return ans;

	}

	public static ComplexVector dynamics(ComplexMatrix[] matrixArray, ComplexVector initialState) throws Exception {
                ComplexVector ans = actionMatrixVector(matrixArray[0], initialState);
		for (int i = 1; i < matrixArray.length; i++) {
			ans = actionMatrixVector(matrixArray[1], ans);
		}
		return ans;
	}
}
