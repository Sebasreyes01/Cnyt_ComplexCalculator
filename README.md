# Complex Calculator

This is a JAVA library of a calculator of complex numbers, complex vectors and complex matrices. The operations it have are:  
- Sum of complex numbers.
- Subtraction of complex numbers.
- Multiplication of complex numbers.
- Division of complex numbers.
- Transformation of the polar form of a complex number to its cartesian form.
- Transformation of the cartesian form of a complex number to its polar form.
- Modulus of a complex number.
- Conjugate of a complex number.
- Get the phase of a complex number.
- Addition of complex vectors.
- Scalar Multiplication of complex vectors.
- Addition of complex matrices.
- Scalar multiplication of complex matrices.
- Inverse of a complex vector.
- Inverse of a complex matrix.
- Multiplication of complex matrices.
- Action of a complex matrix on a complex vector.
- Inner product of complex vectors.
- Adjoint of a complex matrix.
- Checking if a complex matrix is hermitian.
- Checking if a complex matrix is unitary.
- Tensor product of complex matrices.

## Getting Started

For use this library, clone the repository or download the zip of the repository. 

### Prerequisites

You must have maven to compile this project. Go to https://maven.apache.org/ and follow the instructions to install it.

## Running the tests

For running the tests, you can open the cmd in the folder of this project an run
```
mvn test
```

### Tests

This tests test the correct implementation of the different operations.  
Example:

```
@Test
	public void sumTest() {
		ComplexNumber c1 = new ComplexNumber(3, -1);
		ComplexNumber c2 = new ComplexNumber(1, 4);
		ComplexNumber result = ComplexOperations.sum(c1, c2);
		ComplexNumber expected = new ComplexNumber(4, 3);
		assertEquals(expected, result);
	}
```

## Versioning

Complex Calculator 1.0

## Authors

- Sebastián Camilo Reyes Villamil

