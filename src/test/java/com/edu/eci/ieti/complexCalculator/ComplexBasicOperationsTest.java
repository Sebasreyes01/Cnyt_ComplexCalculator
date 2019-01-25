package com.edu.eci.ieti.complexCalculator;

import org.junit.Test;

import static org.junit.Assert.*;

public class ComplexBasicOperationsTest {

    private ComplexBasicOperations cbo = new ComplexBasicOperations();

    @Test
    public void sumTest() {
        ComplexNumber c1 = new ComplexNumber(3, -1);
        ComplexNumber c2 = new ComplexNumber(1, 4);
        ComplexNumber result = cbo.sum(c1, c2);
        ComplexNumber expected = new ComplexNumber(4, 3);
        assertEquals(expected.getComplexNumber(), result.getComplexNumber());
    }

    @Test
    public void subtractionTest() {
        ComplexNumber c1 = new ComplexNumber(5, 7);
        ComplexNumber c2 = new ComplexNumber(3, 1);
        ComplexNumber result = cbo.subtraction(c1, c2);
        ComplexNumber expected = new ComplexNumber(2, 6);
        assertEquals(expected.getComplexNumber(), result.getComplexNumber());
    }

    @Test
    public void multiplicationTest() {
        ComplexNumber c1 = new ComplexNumber(3, -2);
        ComplexNumber c2 = new ComplexNumber(1, 2);
        ComplexNumber result = cbo.multiplication(c1, c2);
        ComplexNumber expected = new ComplexNumber(7, 4);
        assertEquals(expected.getComplexNumber(), result.getComplexNumber());
    }

    @Test
    public void divisionTest() {
        ComplexNumber c1 = new ComplexNumber(-2, 1);
        ComplexNumber c2 = new ComplexNumber(1, 2);
        ComplexNumber result = cbo.division(c1, c2);
        ComplexNumber expected = new ComplexNumber(0, 1);
        assertEquals(expected.getComplexNumber(), result.getComplexNumber());
    }

    @Test
    public void polarToCartesianTest() {
        ComplexNumber result = cbo.polarToCartesian(Math.sqrt(2), Math.PI / 4.0 );
        ComplexNumber expected = new ComplexNumber(1, 1);
        assertEquals(expected.getComplexNumber(), result.getComplexNumber());
    }

    @Test
    public void cartesianToPolarTest() {
        ComplexNumber c1 = new ComplexNumber(1, 1);
        String expected = "(1.41, 0.79)";
        String result = cbo.cartesianToPolar(c1);
        assertEquals(expected, result);
    }

    @Test
    public void modulusTest() {
        ComplexNumber c1 = new ComplexNumber(1, -1);
        double expected = Math.sqrt(2);
        double result = c1.modulus();
        assertEquals(expected, result, 0);
    }

    @Test
    public void conjugateTest() {
        ComplexNumber c1 = new ComplexNumber(2, 5);
        ComplexNumber expected = new ComplexNumber(2, -5);
        ComplexNumber result = c1.conjugate();
        assertEquals(expected.getComplexNumber(), result.getComplexNumber());
    }

    @Test
    public void getPhaseTest() {
        ComplexNumber c1 = new ComplexNumber(1, 1);
        double expected = Math.PI / 4;
        double result = c1.getPhase();
        assertEquals(expected, result, 0);
    }
}