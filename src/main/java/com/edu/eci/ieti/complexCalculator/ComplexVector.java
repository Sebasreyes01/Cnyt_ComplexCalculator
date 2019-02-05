package com.edu.eci.ieti.complexCalculator;

public class ComplexVector {

	ComplexNumber[] vector;

	public ComplexVector(ComplexNumber[] vector) {
		this.vector = vector;
	}

	public ComplexNumber[] getVector() {
		return vector;
	}

	public ComplexVector inverse() {
		ComplexVector r = new ComplexVector(new ComplexNumber[vector.length]);
		for(int i = 0; i < vector.length; i++) {
			r.getVector()[i] = ComplexOperations.multiplication(vector[i], new ComplexNumber(-1, 0));
		}
		return r;
	}

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
