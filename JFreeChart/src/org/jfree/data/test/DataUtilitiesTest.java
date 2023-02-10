package org.jfree.data.test;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.api.ExpectationError;
import org.junit.Test;

public class DataUtilitiesTest extends DataUtilities {

	// @Test
	// public void test() {
	// fail("Not yet implemented");
	// }
	
	@Test (expected = InvalidParameterException.class)
	 public void testCalculateRowTotalNullData() throws InvalidParameterException {
	     
		DataUtilities.calculateRowTotal(null, 0);
	 }
	
	@Test
	 public void testCalculateRowTotalPositiveValues() {
		
		Mockery mockingContext = new Mockery();
	    final Values2D values = mockingContext.mock(Values2D.class);
	    mockingContext.checking(new Expectations() {
	        {
	            one(values).getColumnCount();
	            will(returnValue(2));
	            one(values).getRowCount();
	            will(returnValue(1));
	            one(values).getValue(0, 0);
	            will(returnValue(4.0));
	            one(values).getValue(0, 1);
	            will(returnValue(4.0));	            
	        }
	    });

	     double calculationResult = DataUtilities.calculateRowTotal(values, 0);
	     assertEquals("Row 0 total after 4.0 + 4.0", 8.0, calculationResult, .000000001d);
	 }
	
	@Test
	 public void testCalculateRowTotalNegativeValues() {
		
		Mockery mockingContext = new Mockery();
	    final Values2D values = mockingContext.mock(Values2D.class);
	    mockingContext.checking(new Expectations() {
	        {
	            one(values).getColumnCount();
	            will(returnValue(2));
	            one(values).getRowCount();
	            will(returnValue(1));
	            one(values).getValue(0, 0);
	            will(returnValue(-2.0));
	            one(values).getValue(0, 1);
	            will(returnValue(-12.0));
	        }
	    });

	     double calculationResult = DataUtilities.calculateRowTotal(values, 0);
	     assertEquals("Row 0 total after -2.0 + -12.0", -14.0, calculationResult, .000000001d);
	 }
	
	@Test
	 public void testCalculateRowTotalPositiveNegativeValues() {
		
		Mockery mockingContext = new Mockery();
	    final Values2D values = mockingContext.mock(Values2D.class);
	    mockingContext.checking(new Expectations() {
	        {
	            one(values).getColumnCount();
	            will(returnValue(3));
	            one(values).getRowCount();
	            will(returnValue(1));
	            one(values).getValue(0, 0);
	            will(returnValue(2.0));
	            one(values).getValue(0, 1);
	            will(returnValue(-12.0));
	            one(values).getValue(0, 2);
	            will(returnValue(-11.0));
	        }
	    });

	     double calculationResult = DataUtilities.calculateRowTotal(values, 0);
	     assertEquals("Row 0 total after 2.0 + -12.0 + -11.0", -21.0, calculationResult, .000000001d);
	 }
	
	@Test
	 public void testCalculateRowTotalEmptyRow() {
		
		Mockery mockingContext = new Mockery();
	    final Values2D values = mockingContext.mock(Values2D.class);
	    mockingContext.checking(new Expectations() {
	        {
	            one(values).getColumnCount();
	            will(returnValue(0));
	            one(values).getRowCount();
	            will(returnValue(0));
	        }
	    });

	     double calculationResult = DataUtilities.calculateRowTotal(values, 0);
	     assertEquals("Calculate total of empty row", 0, calculationResult, .000000001d);
	 }
	
	@Test 
	 public void testCalculateRowTotalNegativeRowIndex() {
		
		Mockery mockingContext = new Mockery();
	    final Values2D values = mockingContext.mock(Values2D.class);
	    mockingContext.checking(new Expectations() {
	        {
	            one(values).getColumnCount();
	            will(returnValue(2));
	            one(values).getRowCount();
	            will(returnValue(1));
	            one(values).getValue(0, 0);
	            will(returnValue(4.0));
	            one(values).getValue(0, 1);
	            will(returnValue(4.0));

	        }
	    });
	     
		double calculationResult = DataUtilities.calculateRowTotal(values, -1);
	    assertEquals("Calculate total with negative row index should be zero", 0.0, calculationResult, .000000001d);
		
	 }
	
	@Test
	 public void testCalculateRowTotalRowIndexAUB() {
		
		Mockery mockingContext = new Mockery();
	    final Values2D values = mockingContext.mock(Values2D.class);
	    mockingContext.checking(new Expectations() {
	        {
	            one(values).getColumnCount();
	            will(returnValue(2));
	            one(values).getRowCount();
	            will(returnValue(1));
	            one(values).getValue(0, 0);
	            will(returnValue(4.0));
	            one(values).getValue(0, 1);
	            will(returnValue(4.0));
	        }
	    });
	     
		double calculationResult = DataUtilities.calculateRowTotal(values, 1);
	    assertEquals("Calculate total with AUB row index should be zero", 0.0, calculationResult, .000000001d);
		
	 }
	
	@Test (expected = InvalidParameterException.class)
	 public void testCreateNumberArrayNullData() throws InvalidParameterException {
		
		double[] inputData = null;
	     
	    DataUtilities.createNumberArray(inputData);
		
	 }
	
	@Test
	 public void testCreateNumberArrayEmptyData() {
		
		double[] inputData = {};
		Number[] expectedData = {};
	     
	    Number[] arrayResult = DataUtilities.createNumberArray(inputData);
	    assertArrayEquals("Creating array with empty data", expectedData, arrayResult);
		
	 }
	
	@Test
	 public void testCreateNumberArrayPositiveValues() {
		
		double[] inputData = {4.0, 4.0, 12.0, 14.0};
		Number[] expectedData = {4.0, 4.0, 12.0, 14.0};
	     
	    Number[] arrayResult = DataUtilities.createNumberArray(inputData);
	    assertArrayEquals("Creating array with positive values", expectedData, arrayResult);
		
	 }
	
	@Test
	 public void testCreateNumberArrayNegativeValues() {
		
		double[] inputData = {-1.0, -2.0, -3.0, -4.0};
		Number[] expectedData = {-1.0, -2.0, -3.0, -4.0};
	     
	    Number[] arrayResult = DataUtilities.createNumberArray(inputData);
	    assertArrayEquals("Creating array with negative values", expectedData, arrayResult);
		
	 }
	
	@Test
	 public void testCreateNumberArrayPositiveDecimalValues() {
		
		double[] inputData = {1.11, 2.22, 3.33, 4.44};
		Number[] expectedData = {1.11, 2.22, 3.33, 4.44};
	     
	    Number[] arrayResult = DataUtilities.createNumberArray(inputData);
	    assertArrayEquals("Creating array with positive decimal values", expectedData, arrayResult);
		
	 }
	
	@Test
	 public void testCreateNumberArrayNegativeDecimalValues() {
		
		double[] inputData = {-1.11, -2.22, -3.33, -4.44};
		Number[] expectedData = {-1.11, -2.22, -3.33, -4.44};
	     
	    Number[] arrayResult = DataUtilities.createNumberArray(inputData);
	    assertArrayEquals("Creating array with positive decimal values", expectedData, arrayResult);
		
	 }
	
	@Test
	 public void testCreateNumberArrayLBValues() {
		
		double[] inputData = {Double.MIN_NORMAL};
		Number[] expectedData = {Double.MIN_NORMAL};
	     
	    Number[] arrayResult = DataUtilities.createNumberArray(inputData);
	    assertArrayEquals("Creating array with smallest positive normal value", expectedData, arrayResult);
		
	 }
	
	@Test
	 public void testCreateNumberArrayUBValues() {
		
		double[] inputData = {Double.MAX_VALUE};
		Number[] expectedData = {Double.MAX_VALUE};
	     
	    Number[] arrayResult = DataUtilities.createNumberArray(inputData);
	    assertArrayEquals("Creating array with largest positive value", expectedData, arrayResult);
		
	 }

	// Testing calculateColumnTotal(Values2D data, int column)

	// Sample Test Case provided by SENG 438 Lab Document
	@Test
	public void calculateColumnTotalForTwoValues() {
		// setup
		Mockery mockingContext = new Mockery();
		final Values2D values = mockingContext.mock(Values2D.class);
		mockingContext.checking(new Expectations() {
			{
				one(values).getRowCount();
				will(returnValue(2));
				one(values).getValue(0, 0);
				will(returnValue(7.5));
				one(values).getValue(1, 0);
				will(returnValue(2.5));
			}
		});
		// exercise
		double result = DataUtilities.calculateColumnTotal(values, 0);
		// verify
		assertEquals(result, 10.0, .000000001d);
		// tear-down: NONE in this test method
	}

	// Test a null data parameter which is invalid
	@Test(expected = InvalidParameterException.class)
	public void calculateColumnTotalNullData() {
		double actualColumnTotal = DataUtilities.calculateColumnTotal(null, 0);
	}

	// Test an empty data parameter
	@Test
	public void calculateColumnTotalEmpty() {
		Mockery mockingContext = new Mockery();
		final Values2D values = mockingContext.mock(Values2D.class);

		mockingContext.checking(new Expectations() {
			{
				one(values).getRowCount();
				will(returnValue(0));
			}
		});

		double expectedColumnTotal = 0;
		double actualColumnTotal = DataUtilities.calculateColumnTotal(values, 0);
		assertEquals("The column total for empty object should be 0", expectedColumnTotal, actualColumnTotal,
				.000000001d);
	}

	// Test a valid data parameter with positive values and positive index and other
	// values in other columns
	@Test
	public void calculateColumnTotalPositiveTableAndValues() {
		Mockery mockingContext = new Mockery();
		final Values2D values = mockingContext.mock(Values2D.class);

		mockingContext.checking(new Expectations() {
			{
				one(values).getRowCount();
				will(returnValue(3));

				one(values).getValue(0, 0);
				will(returnValue(1000));
				one(values).getValue(0, 1);
				will(returnValue(14));
				one(values).getValue(0, 2);
				will(returnValue(1000));

				one(values).getValue(1, 1);
				will(returnValue(24));

				one(values).getValue(2, 1);
				will(returnValue(34));
			}
		});

		double expectedColumnTotal = 72;
		double actualColumnTotal = DataUtilities.calculateColumnTotal(values, 1);
		assertEquals("The column total should be 72", expectedColumnTotal, actualColumnTotal, .000000001d);
	}

	// Test a valid data parameter with positive values and positive index and other
	// values in other columns
	@Test
	public void calculateColumnTotalNegativeValues() {
		Mockery mockingContext = new Mockery();
		final Values2D values = mockingContext.mock(Values2D.class);

		mockingContext.checking(new Expectations() {
			{
				one(values).getRowCount();
				will(returnValue(3));

				one(values).getValue(0, 0);
				will(returnValue(-1000));
				one(values).getValue(0, 1);
				will(returnValue(-14));
				one(values).getValue(0, 2);
				will(returnValue(-1000));

				one(values).getValue(1, 1);
				will(returnValue(-24));

				one(values).getValue(2, 1);
				will(returnValue(-34));
			}
		});

		double expectedColumnTotal = -72;
		double actualColumnTotal = DataUtilities.calculateColumnTotal(values, 1);
		assertEquals("The column total should be -72", expectedColumnTotal, actualColumnTotal, .000000001d);
	}

	// Test a valid data parameter with positive values and negative index
	@Test(expected = InvalidParameterException.class)
	public void calculateColumnTotalNegativeColumn() {
		Mockery mockingContext = new Mockery();
		final Values2D values = mockingContext.mock(Values2D.class);

		mockingContext.checking(new Expectations() {
			{
				one(values).getRowCount();
				will(returnValue(3));

				one(values).getValue(0, 0);
				will(returnValue(1000));
			}
		});

		double expectedColumnTotal = 0;
		double actualColumnTotal = DataUtilities.calculateColumnTotal(values, -1);
		assertEquals("The column total should be 0", expectedColumnTotal, actualColumnTotal, .000000001d);
	}
	
	 //Parbir Code
	 //createNumberArray2D(double[][] data) Tests
	 
	 /** 
	  * This test is creates an array of array of Number objects by accepting double primitives.  
	  * This test asserts that a 2 row, 2 column positive value array of double is created. 
	  * **/
	 
	 @Test
	 public void createNumber2DArrayPositive() {
		 //create expected array
		 Number[][] expectedArray = {{1, 5},{2, 6}};
		 //create array of double to pass through the method
		 double[][] inputArray = {{1, 5},{2, 6}};
		 //call method to create Number array of arrays
		 Number[][] actualArray = DataUtilities.createNumberArray2D(inputArray);
		 //assert actual and expected array of arrays
		 assertArrayEquals(expectedArray, actualArray);
	 }
	 
	 
	 /** 
	  * This test is creates an array of array of Number objects by accepting double primitives.  
	  * This test asserts that a 2 row, 2 column negative value array of double is created. 
	  * **/
	 
	 @Test
	 public void createNumber2DArrayNegative() {
		 //create expected array
		 Number[][] expectedArray = {{-1, -5},{-2, -6}};
		 //create array of double to pass through the method
		 double[][] inputArray = {{-1, -5},{-2, -6}};
		 //call method to create Number array of arrays
		 Number[][] actualArray = DataUtilities.createNumberArray2D(inputArray);
		 //assert actual and expected array of arrays
		 assertArrayEquals(expectedArray, actualArray);
	 }
	 
	 /** 
	  * This test is creates an array of array of Number objects by accepting double primitives.  
	  * This test asserts that a 2 row, 2 column positive decimal value array of double is created. 
	  * **/
	 
	 @Test
	 public void createNumber2DArrayPositiveDecimal() {
		 //create expected array
		 Number[][] expectedArray = {{1.0, 5.0},{2.0, 6.0}};
		 //create array of double to pass through the method
		 double[][] inputArray = {{1.0, 5.0},{2.0, 6.0}};
		 //call method to create Number array of arrays
		 Number[][] actualArray = DataUtilities.createNumberArray2D(inputArray);
		 //assert actual and expected array of arrays
		 assertArrayEquals(expectedArray, actualArray);
	 }
	 
	 /** 
	  * This test is creates an array of array of Number objects by accepting double primitives.  
	  * This test asserts that a 2 row, 2 column negative decimal value array of double is created. 
	  * **/
	 
	 @Test
	 public void createNumber2DArrayNegativeDecimals() {
		 //create expected array
		 Number[][] expectedArray = {{-1.0, -5.0},{-2.0, -6.0}};
		 //create array of double to pass through the method
		 double[][] inputArray = {{-1.0, -5.0},{-2.0, -6.0}};
		 //call method to create Number array of arrays
		 Number[][] actualArray = DataUtilities.createNumberArray2D(inputArray);
		 //assert actual and expected array of arrays
		 assertArrayEquals(expectedArray, actualArray);
	 }
	 
	 
	 /** 
	  * This test is creates an array of array of Number objects by accepting double primitives.  
	  * This test asserts that a null 2D array passed into createNumberArray2D
	  * The assert will throw an exception 
	  * **/
	 
	 @Test (expected = InvalidParameterException.class)
	 public void createNumber2DArrayNull() throws InvalidParameterException{
		 //try{
			 //create null array to pass through the method
			 double[][] inputArray = null;
			 //call method
			 DataUtilities.createNumberArray2D(inputArray);
			// fail("Should have thrown illegal argument exception");
		 	
		 	
		 //} catch (Exception e) {
			// assertEquals("The exception e thorwn type IllegalArgumentException",
			//		 IllegalArgumentException.class, e.getClass());
		 //
	 }

}
