package com.edu.eci.ieti.complexCalculator;

public class ComplexCalculatorApplication {

	public static void main(String[] args) {
		ComplexNumber c1 = new ComplexNumber(3,-1);
		ComplexNumber c2 = new ComplexNumber(1, 4);
		ComplexNumber sum = ComplexOperations.sum(c1,c2);
		ComplexNumber sub = ComplexOperations.subtraction(c1,c2);
		ComplexNumber mul = ComplexOperations.multiplication(c1,c2);
		ComplexNumber div = ComplexOperations.division(c1,c2);
		double mod = c1.modulus();
		ComplexNumber con = c1.conjugate();
		double pha = c1.getPhase();
		ComplexNumber ptc = ComplexOperations.polarToCartesian(Math.sqrt(2), Math.PI / 4);
		String ctp = ComplexOperations.cartesianToPolar(new ComplexNumber(1, 1));
		System.out.println(sum.getComplexNumber());
		System.out.println(sub.getComplexNumber());
		System.out.println(mul.getComplexNumber());
		System.out.println(div.getComplexNumber());
		System.out.println(mod);
		System.out.println(con.getComplexNumber());
		System.out.println(pha);
		System.out.println(ptc.getComplexNumber());
		System.out.println(ctp);
	}

}

