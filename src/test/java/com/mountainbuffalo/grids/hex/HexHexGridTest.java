/*
 */
package com.mountainbuffalo.grids.hex;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ryan
 */
public class HexHexGridTest {

	public HexHexGridTest() {
	}

	@BeforeClass
	public static void setUpClass() {
	}

	@AfterClass
	public static void tearDownClass() {
	}

	@Before
	public void setUp() {
	}

	@After
	public void tearDown() {
	}

	/**
	 * Test of elementSum method, of class HexHexGrid.
	 */
	@Test
	public void testElementSum() {
		System.out.println("elementSum");
		for (int i = 1; i <= 100; i++) {
			int result = HexHexGrid.elementSum(i, HexHexGrid.rowCount(i) - 1);
			int expected = HexHexGrid.calculateSize(i);
			assertEquals("elementSum(radius, all rows) == calculateSize(radius)", expected, result);
		}
	}

}
