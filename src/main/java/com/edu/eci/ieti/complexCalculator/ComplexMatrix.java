package com.edu.eci.ieti.complexCalculator;

public class ComplexMatrix {

	ComplexNumber[][] matrix;

	public ComplexMatrix(ComplexNumber[][] matrix) throws Exception {
		int l = matrix[0].length;
		for (int i = 0; i < matrix.length; i++) {
			if(matrix[i].length != l) {
				throw new Exception("The rows of the matrix have to be the same length");
			}
		}
		this.matrix = matrix;
	}

	public ComplexNumber[][] getMatrix() {
		return matrix;
	}

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
