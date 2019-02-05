package com.edu.eci.ieti.complexCalculator;

public class ComplexVector {

	ComplexNumber[] vector;

	public ComplexVector(ComplexNumber[] vector) {
		this.vector = vector;
	}

	public ComplexNumber[] getVector() {
		return vector;
	}

	public ComplexVector inverse(ComplexVector v) {
		for(int i = 0; i < v.getVector().length; i++) {
			v.getVector()[i] = ComplexOperations.multiplication(v.getVector()[i], new ComplexNumber(0, -1));
		}
		return v;
	}

}
