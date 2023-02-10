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

}
