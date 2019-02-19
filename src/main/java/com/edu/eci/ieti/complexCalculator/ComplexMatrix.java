package com.edu.eci.ieti.complexCalculator;

public class ComplexMatrix {

	ComplexNumber[][] matrix;

	/**
	 * The constructor of a new complex matrix.
	 * @param matrix The matrix that will be used.
	 * @throws Exception The rows of the matrix have to be the same length.
	 */
	public ComplexMatrix(ComplexNumber[][] matrix) throws Exception {
		int l = matrix[0].length;
		for (int i = 0; i < matrix.length; i++) {
			if(matrix[i].length != l) {
				throw new Exception("The rows of the matrix have to be the same length");
			}
		}
		this.matrix = matrix;
	}

	/**
	 * Obtains the matrix.
	 * @return The matrix.
	 */
	public ComplexNumber[][] getMatrix() {
		return matrix;
	}

	/**
	 * Calculates the inverse of a matrix.
	 * @return The inverse of a matrix.
	 */
	public ComplexMatrix inverse() {
		ComplexMatrix r = null;
		try {
			r = new ComplexMatrix(new ComplexNumber[matrix.length][matrix[0].length]);
		} catch (Exception e) {
			e.printStackTrace();
		}
		for(int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				r.getMatrix()[i][j] = ComplexOperations.multiplication(matrix[i][j], new ComplexNumber(-1,0));
			}
		}
		return r;
	}

	/**
	 * Verifies if two matrices are equal.
	 * @param o The object that is going to be compered.
	 * @return True or false depending if the matrices are equal.
	 */
	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (!(o instanceof ComplexMatrix)) {
			return false;
		}
		ComplexMatrix m = (ComplexMatrix) o;
		if (m.getMatrix().length != matrix.length || m.getMatrix()[0].length != matrix[0].length) {
			return false;
		}
		boolean b = false;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (!m.getMatrix()[i][j].equals(matrix[i][j])) {
					b = false;
					break;
				} else {
					b = true;
				}
			}
		}
		return b;
	}
}
