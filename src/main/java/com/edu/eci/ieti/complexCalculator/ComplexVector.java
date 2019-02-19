package com.edu.eci.ieti.complexCalculator;

public class ComplexVector {

	ComplexNumber[] vector;

	/**
	 * The constructor of a new complex vector.
	 * @param vector The complex vector.
	 */
	public ComplexVector(ComplexNumber[] vector) {
		this.vector = vector;
	}

	/**
	 * Obtains the complex vector.
	 * @return The complex vector.
	 */
	public ComplexNumber[] getVector() {
		return vector;
	}

	/**
	 * Calculates the inverse of the complex vector.
	 * @return The inverse of the complex vector.
	 */
	public ComplexVector inverse() {
		ComplexVector r = new ComplexVector(new ComplexNumber[vector.length]);
		for(int i = 0; i < vector.length; i++) {
			r.getVector()[i] = ComplexOperations.multiplication(vector[i], new ComplexNumber(-1, 0));
		}
		return r;
	}

	/**
	 * Compares if 2 complex vectors are equal.
	 * @param o The object that will be compared.
	 * @return True or false depending if the complex vectors are equal.
	 */
	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (!(o instanceof ComplexVector)) {
			return false;
		}
		ComplexVector v = (ComplexVector) o;
		if(v.getVector().length != vector.length) {
			return false;
		}
		boolean b = false;
		for(int i = 0; i < v.getVector().length; i++) {
			if(!v.getVector()[i].equals(vector[i])) {
				b = false;
				break;
			} else {
				b = true;
			}
		}
		return b;
	}

}
