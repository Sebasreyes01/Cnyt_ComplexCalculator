package com.edu.eci.ieti.complexCalculator;

import java.text.DecimalFormat;

public class ComplexNumber {

	private double realNumber;
	private double imaginaryNumber;

	public ComplexNumber(double realNumber, double imaginaryNumber) {
		this.realNumber = realNumber;
		this.imaginaryNumber = imaginaryNumber;
	}

	public double getRealNumber() {
		return realNumber;
	}

	public double getImaginaryNumber() {
		return imaginaryNumber;
	}

	public String getComplexNumber() {
		DecimalFormat df = new DecimalFormat("#.##");
		if(imaginaryNumber < 0) {
			return df.format(realNumber) + " - " + df.format(imaginaryNumber * -1) + "i";
		} else {
			return df.format(realNumber) + " + " + df.format(imaginaryNumber) + "i";
		}
	}

	public double modulus() {
		return  Math.sqrt(Math.pow(realNumber, 2) + Math.pow(imaginaryNumber, 2));
	}

	public ComplexNumber conjugate() {
		return new ComplexNumber(realNumber, imaginaryNumber * -1);
	}

	public double getPhase() {
		return Math.atan2(imaginaryNumber, realNumber);
	}

	@Override
	public boolean equals(Object o) {

		if (o == this) {
			return true;
		}
		if (!(o instanceof ComplexNumber)) {
			return false;
		}
		ComplexNumber c = (ComplexNumber) o;

		// Compare the data members and return accordingly
		return Double.compare(realNumber, c.getRealNumber()) == 0 && Double.compare(imaginaryNumber, c.getImaginaryNumber()) == 0;
	}
}
