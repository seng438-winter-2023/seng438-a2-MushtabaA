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
		
	    //-------------getUpperBound() Test Start------------------
	    
	    //testing method getUpperBound() for case where upper bound != lower bound
	    @Test
	    public void upperBoundRange() {
	    	//assert value with input
	    	assertEquals("The upper bound of -1 and 1 should be 1",
	    	1, exampleRange.getUpperBound(), .000000001d);
	    }
	    
	    //testing same range (equal value range)
	    @Test
	    public void upperBoundEqualRange() {
	    	Range data = new Range(1, 1);	//Set Range
	    	double input = data.getUpperBound();	//push value through method
	    	//assert value with input
	    	assertEquals("The upper bound of 1 and 1 should be 1",
	    	1, input, .000000001d);
	    }
	    
	    //testing only positive range
	    @Test
	    public void upperBoundPositiveRange() {
	    	Range data = new Range(1.0, 2.0);	//Set Range
	    	double input = data.getUpperBound();	//push value through method
	    	//assert value with input
	    	assertEquals("The upper bound of 1.0 and 2.0 should be 2.0",
	    	2.0, input, .000000001d);
	    }
	    
	    //testing negative range
	    @Test
	    public void upperBoundNegativeRange() {
	    	Range data = new Range(-1.0, -0.5);	//Set Range
	    	double input = data.getUpperBound();	//push value through method
	    	//assert value with input
	    	assertEquals("The upper bound of -1.0 and -0.5 should be -0.5",
	    	-0.5, input, .000000001d);
	    }
	    
	    //testing max and minimum range
	    @Test
	    public void upperBoundMaxMinRange() {
	    	Range data = new Range(Double.MIN_VALUE, Double.MAX_VALUE);	//Set Range
	    	double input = data.getUpperBound();	//push value through method
	    	//assert value with input
	    	assertEquals("The upper bound of Min and Max should be Max",
	    	Double.MAX_VALUE, input, .000000001d);
	    }
	    
	    //-------------getUpperBound() Test End------------------
	    
	    //-------------constrain() Test Start------------------
	    
	    //positive range test
	    @Test
	    public void positiveConstrain() {
	    	Range data = new Range(1, 10); //Set Range
	    	double input = data.constrain(9);	//push value through method
	    	//assert value with input
	    	assertEquals("The constrain of 9 in range 1 and 10 should be 10"
	    			, 10, input, .000000001d);
	    }
	    
	    //negative range test
	    @Test
	    public void negativeConstrain() {
	    	Range data = new Range(-10, -1);	//Set Range
	    	double input = data.constrain(-9);	//push value through method
	    	//assert value with input
	    	assertEquals("The constrain of -9 in range -10 and -1 should be -10"
	    			, -10, input, .000000001d);
	    }
	    
	    //equal range test
	    @Test
	    public void equalConstrain() {
	    	Range data = new Range(1, 1);	//Set Range
	    	double input = data.constrain(1);	//push value through method
	    	//assert value with input
	    	assertEquals("The constrain of 1 in range 1 and 1 should be 1"
	    			, 1, input, .000000001d);
	    }
	    
	    //decimal range test
	    @Test
	    public void decimalConstrain() {
	    	Range data = new Range(-1.0, 1.0);	//Set Range
	    	double input = data.constrain(0.5);	//push value through method
	    	//assert value with input
	    	assertEquals("The constrain of 0.5 in range -1.0 and 1.0 should be 1.0"
	    			, 1.0, input, .000000001d);
	    }
	    
	    
	    //max and min test
	    @Test
	    public void maxMinConstrain() {
	    	Range data = new Range(Double.MIN_VALUE, Double.MAX_VALUE);	//Set Range
	    	double input = data.constrain(10);	//push value through method
	    	//assert value with input
	    	assertEquals("The constrain of 10 in range Min and Max should be Max"
	    			, Double.MAX_VALUE, input, .000000001d);
	    }
	    
	    //Passing an out of range value in constrain method
	    //Supposed to throw an out of bounds exception
	    @Test
	    public void outOfRangeConstrain() {
	    	Range data = new Range(1, 1);	//Set Range
	    	double input = data.constrain(5);	//push value through method
	    	//assert value with input
	    	assertEquals("The constrain of 5 in range 1 and 1 should result in an OutOfBounds Error"
	    			, 1, input, .000000001d);
	    }
	    
	    //-------------constrain() Test End------------------

		// Testing intersect()
		
		// EQUIVALENCE CLASS TESTING
		// Test if equal ranges intersect
		@Test
		public void testIntersectEqualRanges() {
			Range sampleRange = new Range(0, 10);
			
			boolean expectedIntersect = true;
			boolean actualIntersect = sampleRange.intersects(0, 10);
			assertEquals("Equal ranges should intersect", expectedIntersect, actualIntersect);
		}
		
		// Test if ranges intersect when one range's upper bound is greater than another's lower bound
		@Test
		public void testIntersectRangeOneUpperBoundGreaterThanRangeTwoLowerBound() {
			Range sampleRange = new Range(0, 10);
			
			boolean expectedIntersect = true;
			boolean actualIntersect = sampleRange.intersects(5, 30);
			assertEquals("Ranges should intersect when one range's upper bound is greater than another's lower bound", expectedIntersect, actualIntersect);
		}
		
		// Test if ranges intersect when one range's lower bound is less than another's upper bound
		@Test
		public void testIntersectRangeOneLowerBoundLessThanRangeTwoUpperBound() {
			Range sampleRange = new Range(0, 10);
			
			boolean expectedIntersect = true;
			boolean actualIntersect = sampleRange.intersects(-10, 5);
			assertEquals("Ranges should intersect when one range's lower bound is less than another's upper bound", expectedIntersect, actualIntersect);
		}
		
		// Test if ranges do not intersect when one range's upper bound is less than another's upper bound
		@Test
		public void testIntersectRangeOneUpperBoundLessThanRangeTwoLowerBound() {
			Range sampleRange = new Range(0, 10);
			
			boolean expectedIntersect = false;
			boolean actualIntersect = sampleRange.intersects(15, 30);
			assertEquals("Ranges should not intersect when one range's upper bound is less than another's lower bound", expectedIntersect, actualIntersect);
		}
		
		// Test if ranges do not intersect when one range's lower bound is greater than another's upper bound
		@Test
		public void testIntersectRangeOneLowerBoundGreaterThanRangeTwoUpperBound() {
			Range sampleRange = new Range(0, 10);
			
			boolean expectedIntersect = false;
			boolean actualIntersect = sampleRange.intersects(-30, -15);
			assertEquals("Ranges should not intersect when one range's lower bound is greater than another's upper bound", expectedIntersect, actualIntersect);
		}
		
		// BOUNDARY VALUE TESTING
		// Test if ranges intersect when both ranges' bounds are equal (i.e. upper == lower)
		@Test
		public void testIntersectMinimalRangeBounds() {
			Range sampleRange = new Range(0,0);
			
			boolean expectedIntersect = true;
			boolean actualIntersect = sampleRange.intersects(0, 0);
			assertEquals("Ranges should intersect when both ranges' lower bounds are the same as their upper bounds", expectedIntersect, actualIntersect);
		}
		// Test if ranges intersect when one range's upper bound is equal to another's lower bound
		@Test
		public void testIntersectRangeOneUpperBoundEqualToRangeTwoLowerBound() {
			Range sampleRange = new Range(0, 10);
			
			boolean expectedIntersect = true;
			boolean actualIntersect = sampleRange.intersects(10, 30);
			assertEquals("Ranges should intersect when one range's upper bound is equal to another's lower bound", expectedIntersect, actualIntersect);
		}
		
		// Test if ranges intersect when one range's lower bound is equal to another's upper bound
		@Test
		public void testIntersectRangeOneLowerBoundEqualToRangeTwoUpperBound() {
			Range sampleRange = new Range(0, 10);
			
			boolean expectedIntersect = true;
			boolean actualIntersect = sampleRange.intersects(-10, 0);
			assertEquals("Ranges should intersect when one range's lower bound is equal to another's upper bound", expectedIntersect, actualIntersect);
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
