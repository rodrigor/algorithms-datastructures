package sorting;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import sorting.MergeSort;

public class MergeSortTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMergeSort() {
		int[] array = new int[]{5, 3, 8, 2, 9, 6, 0, 1, 6, 4, 8, 9, 5, 3};
		MergeSort.mergeSort(array);
		int[] ordered = new int[]{0, 1, 2, 3, 3, 4, 5, 5, 6, 6, 8, 8, 9, 9};
		assertArrayEquals(ordered,array);
	}
	
	@Test
	public void testMerge(){
		Cost cost = new Cost(false);
		int[] array = new int[]{2,4,1,3};
		int p = 0;
		int r = 3;
		int q = (p + r)/2;
		assertEquals(1,q);
		MergeSort.merge(array, p, q, r, cost);
		int[] ordered = new int[]{1,2,3,4};
		assertArrayEquals(ordered,array);

		// teste 2
		array = new int[]{2,4,6,8,1,3,5,7};
		r = array.length-1;
		q = (p + r)/2;
		MergeSort.merge(array, p, q, r, cost);
		ordered = new int[]{1,2,3,4,5,6,7,8};
		assertArrayEquals(ordered,array);
		
		// teste 3
		array = new int[]{0};
		r = array.length-1;
		q = (p + r)/2;
		MergeSort.merge(array, p, q, r, cost);
		ordered = new int[]{0};
		assertArrayEquals(ordered,array);

		// teste 4
		array = new int[0];
		r = array.length-1;
		q = (p + r)/2;
		MergeSort.merge(array, p, q, r, cost);
		ordered = new int[0];
		assertArrayEquals(ordered,array);

		// teste 5
		array = new int[]{2,4,6,1,2};
		r = array.length-1;
		MergeSort.merge(array, p, 2, r, cost);
		ordered = new int[]{1,2,2,4,6};
		assertArrayEquals(ordered,array);

		// teste 6
		array = new int[]{2,4,1};
		r = array.length-1;
		MergeSort.merge(array, p, 1, r, cost);
		ordered = new int[]{1,2,4};
		assertArrayEquals(ordered,array);

	}

}
