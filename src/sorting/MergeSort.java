package sorting;

import java.util.Arrays;

/**
 * Implementation of Merge Sort algorithm, as in Cormen (Introduction of
 * Algorithms 3rd Ed.)
 *
 */
public class MergeSort implements SortingAlgorithm {

	public static void mergeSort(int[] array) {
		mergeSort(array, new Cost(false));
	}

	public static void mergeSort(int[] array, Cost cost) {
		mergeSort(array, 0, array.length - 1, cost);
	}

	public static void mergeSort(int[] array, int p, int r, Cost cost) {
		if (p < r) {
			int q = (p + r) / 2;
			cost.plus();
			mergeSort(array, p, q, cost);
			mergeSort(array, q + 1, r, cost);
			merge(array, p, q, r, cost);
		}
	}

	static void merge(int[] array, int p, int q, int r, Cost cost) {
		if (r < p)
			return;
		int n1 = q - p + 1;
		int n2 = r - q;
		int[] L = new int[n1 + 1];
		int[] R = new int[n2 + 1];
		cost.plus(4);
		for (int i = 0; i < n1; i++) {
			L[i] = array[p + i];
			cost.plus();
		}
		for (int i = 0; i < n2; i++) {
			R[i] = array[q + i + 1];
			cost.plus();
		}
		L[n1] = Integer.MAX_VALUE;
		R[n2] = Integer.MAX_VALUE;
		int i = 0;
		int j = 0;
		cost.plus(4);
		for (int k = p; k <= r; k++)
			if (L[i] <= R[j]) {
				array[k] = L[i];
				i++;
				cost.plus();
			} else {
				array[k] = R[j];
				j++;
				cost.plus();
			}
	}

	public static void test(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = 0;
		}
	}

	public static void main(String[] args) {
		int[] array = new int[] { 5, 3, 8, 2, 9, 6, 0, 1, 6, 4, 8, 9, 5, 3 };
		Arrays.sort(array);
		System.out.println(Arrays.toString(array));

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see sorting.SortingAlgorithm#sort(int[], sorting.Cost)
	 */
	@Override
	public void sort(int[] array, Cost cost) {
		mergeSort(array, cost);
	}

	/* (non-Javadoc)
	 * @see sorting.SortingAlgorithm#getName()
	 */
	@Override
	public String getName() {
		return "Merge Sort - O(nlgn)";
	}

}
