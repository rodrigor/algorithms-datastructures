package util;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ArrayTest {
	

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testNewRandomIntArrayIntIntLong() {
		int[] array = Array.newRandomIntArray(10, 10, 273462837);
		System.out.println(new Array(array));
	}

}
