package org.jfree.data.test;

import static org.junit.Assert.*;
import org.jfree.data.Range;
import org.junit.Test;
import org.junit.*;


public class RangeTest {

	private Range exampleRange;

	// ! Provided by SENG 438 Lab Document
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		exampleRange = new Range(-1, 1);
	}

//	@Test
//	public void centralValueShouldBeZero() {
//		assertEquals("The central value of -1 and 1 should be 0",
//				0, exampleRange.getCentralValue(), .000000001d);
//	}
	// ! End of Code provided by Lab Doc.

	// Testing getLength()

	// Test the length of a range that is 0.0
	@Test
	public void testGetLengthZero() {
		Range sampleRange = new Range(24, 24);

		double expectedLength = 0;
		double actualLength = sampleRange.getLength();
		assertEquals("Length should be 0", expectedLength, actualLength, .000000001d);
	}

	// Test the length of a range with positive upper and lower bounds
	@Test
	public void testGetLengthBothBoundsPositive() {
		Range sampleRange = new Range(0, 24);

		double expectedLength = 24 - 0;
		double actualLength = sampleRange.getLength();
		assertEquals("Length should be 24.0", expectedLength, actualLength, .000000001d);
	}

	// Test the length of a range with negative upper and lower bounds
	@Test
	public void testGetLengthBothBoundsNegative() {
		Range sampleRange = new Range(-100, -24);

		double expectedLength = -24 - (-100);
		double actualLength = sampleRange.getLength();
		assertEquals("Length should be 76.0", expectedLength, actualLength, .000000001d);
	}

	// Test the length of a range with negative lower and positive upper bounds
	@Test
	public void testGetLengthOnlyLowerBoundNegative() {
		Range sampleRange = new Range(-100, 100);

		double expectedLength = 100 - (-100);
		double actualLength = sampleRange.getLength();
		assertEquals("Length should be 200.0", expectedLength, actualLength, .000000001d);
	}

	// Test the length of a range with a decimal upper and lower bound
	@Test
	public void testGetLengthBothBoundsDecimals() {
		Range sampleRange = new Range(-123.24, 100.24);

		double expectedLength = 100.24 - (-123.24);
		double actualLength = sampleRange.getLength();
		assertEquals("Length should be 223.48", expectedLength, actualLength, .000000001d);
	}

	// Test the length of a range with a decimal upper and whole number lower bound
	@Test
	public void testGetLengthOnlyUpperBoundDecimal() {
		Range sampleRange = new Range(-123, 100.24);

		double expectedLength = 100.24 - (-123);
		double actualLength = sampleRange.getLength();
		assertEquals("Length should be 223.24", expectedLength, actualLength, .000000001d);
	}

	// Test the length of a range with a decimal lower and whole number upper bound
	@Test
	public void testGetLengthOnlyLowerBoundDecimal() {
		Range sampleRange = new Range(-123.24, 150);

		double expectedLength = 150 - (-123.24);
		double actualLength = sampleRange.getLength();
		assertEquals("Length should be 273.24", expectedLength, actualLength, .000000001d);
	}
	
	// Testing contains()

		// Test if a valid integer exists in range
		@Test
		public void testGetContainsNumberExists() {
			Range sampleRange = new Range(20, 24);

			boolean expectedContains = true;
			boolean actualContains = sampleRange.contains(23);
			assertEquals("22 should exist in range of 20 to 24", expectedContains, actualContains);
		}

		// Test if a valid integer does not exist in range
		@Test
		public void testGetContainsNumberNotExists() {
			Range sampleRange = new Range(20, 24);

			boolean expectedContains = false;
			boolean actualContains = sampleRange.contains(25);
			assertEquals("25 should not exist in range of 20 to 24", expectedContains, actualContains);
		}
		
		// Test if a valid integer does exist in range and is lower bound
		@Test
		public void testGetContainsPositiveNumberExistsLowerBound() {
			Range sampleRange = new Range(20, 24);

			boolean expectedContains = true;
			boolean actualContains = sampleRange.contains(20);
			assertEquals("20 should exist in range of -20 to 24", expectedContains, actualContains);
		}
		
		// Test if a valid integer does exist in range and is upper bound
		@Test
		public void testGetContainsPositiveNumberExistsUpperBound() {
			Range sampleRange = new Range(42, 224);

			boolean expectedContains = true;
			boolean actualContains = sampleRange.contains(224);
			assertEquals("224 should exist in range of 42 to 224", expectedContains, actualContains);
		}
		// Test if a valid integer does exist in range and is lower bound and is negative
		@Test
		public void testGetContainsNegativeNumberExistsLowerBound() {
			Range sampleRange = new Range(-20, 24);

			boolean expectedContains = true;
			boolean actualContains = sampleRange.contains(-20);
			assertEquals("-20 should exist in range of -20 to 24", expectedContains, actualContains);
		}
		
		// Test if a valid integer does exist in range and is upper bound and is negative
		@Test
		public void testGetContainsNegativeNumberExistsUpperBound() {
			Range sampleRange = new Range(-42, -24);

			boolean expectedContains = true;
			boolean actualContains = sampleRange.contains(-24);
			assertEquals("-24 should exist in range of -42 to -24", expectedContains, actualContains);
		}
		
		
	
	// ! Provided by SENG 438 Lab Document
	@After
	public void tearDown() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	// ! End of Code provided by Lab Doc.
}
