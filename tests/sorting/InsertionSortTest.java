/**
 * 
 */
package sorting;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Rodrigo Rebouças de Almeida (http://github.com/rodrigor)
 * @date Apr 30, 2017
 */
public class InsertionSortTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link sorting.InsertionSort#insertionSort(int[])}.
	 */
	@Test
	public void testInsertionSort() {
		int[] array = new int[]{5, 3, 8, 2, 9, 6, 0, 1, 6, 4, 8, 9, 5, 3};
		InsertionSort.insertionSort(array);
		int[] ordered = new int[]{0, 1, 2, 3, 3, 4, 5, 5, 6, 6, 8, 8, 9, 9};
		assertArrayEquals(ordered,array);

	}

}
