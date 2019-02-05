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

}
