# Complex Calculator

This is a JAVA library of a calculator of complex numbers, complex vectors and complex matrices.

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

