package com.edu.eci.ieti.complexCalculator;

import java.text.DecimalFormat;

public class ComplexNumber {

	private double realNumber;
	private double imaginaryNumber;

	/**
	 * Constructor of the class
	 * @param realNumber is the real part of the complex number.
	 * @param imaginaryNumber is the imaginary part of the complex number.
	 */
	public ComplexNumber(double realNumber, double imaginaryNumber) {
		this.realNumber = realNumber;
		this.imaginaryNumber = imaginaryNumber;
	}

	/**
	 * Gets the real part of the complex number.
	 * @return the real part of the complex number.
	 */
	public double getRealNumber() {
		return realNumber;
	}

	/**
	 * Gets the imaginary part of the complex number.
	 * @return the imginary part of the complex number.
	 */
	public double getImaginaryNumber() {
		return imaginaryNumber;
	}

	/**
	 * Displays the complex number in a string.
	 * @return the complex number in a string.
	 */
	public String getComplexNumber() {
		DecimalFormat df = new DecimalFormat("#.##");
		if(imaginaryNumber < 0) {
			return df.format(realNumber) + " - " + df.format(imaginaryNumber * -1) + "i";
		} else {
			return df.format(realNumber) + " + " + df.format(imaginaryNumber) + "i";
		}
	}

	/**
	 * Calculates the modulus of the complex number.
	 * @return the modulus of the complex number.
	 */
	public double modulus() {
		return  Math.sqrt(Math.pow(realNumber, 2) + Math.pow(imaginaryNumber, 2));
	}

	/**
	 * Calculates the conjugate of the complex number.
	 * @return the conjugate of the complex number.
	 */
	public ComplexNumber conjugate() {
		return new ComplexNumber(realNumber, imaginaryNumber * -1);
	}

	/**
	 * Gets the phase of the complex number.
	 * @return the phase of the complex number.
	 */
	public double getPhase() {
		return Math.atan2(imaginaryNumber, realNumber);
	}

	/**
	 * Compares two complex numbers and determines if are equal.
	 * @param o the object to be compered with.
	 * @return if the complex number is equal to the object.
	 */
	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (!(o instanceof ComplexNumber)) {
			return false;
		}
		ComplexNumber c = (ComplexNumber) o;
		return Double.compare(round(realNumber), round(c.getRealNumber())) == 0 && Double.compare(round(imaginaryNumber), round(c.getImaginaryNumber())) == 0;
	}

	/**
	 * Rounds a double to 5 decimals.
	 * @param d The given double.
	 * @return The double round to 5 decimals.
	 */
	private double round(double d) {
		String s = Double.toString(d);
		if(s.length() > 7) {
			s = s.substring(0,7);
		}
		return Double.valueOf(s);
	}
}
