/**
 * 
 */
package sorting;

/**
 * @author Rodrigo Rebouças de Almeida (http://github.com/rodrigor)
 * @date Apr 30, 2017
 */
public class InsertionSort implements SortingAlgorithm{
	
	
	public static void insertionSort(int[] array){
		insertionSort(array,new Cost(false));
	}

	public static void insertionSort(int[] array, Cost cost){
		if (array.length <= 1) return;
		
		for(int j = 1; j < array.length; j++){
			int key = array[j];
			int i = j - 1;
			cost.plus(2);
			while( (i >= 0) && (array[i] > key)){
				array[i+1] = array[i];
				i = i - 1;
				cost.plus(2);
			}
			array[i+1] = key;
			cost.plus();
		}
	}

	/* (non-Javadoc)
	 * @see sorting.SortingAlgorithm#sort(int[], sorting.Cost)
	 */
	@Override
	public void sort(int[] array, Cost cost) {
		insertionSort(array,cost);
		
	}

	/* (non-Javadoc)
	 * @see sorting.SortingAlgorithm#getName()
	 */
	@Override
	public String getName() {
		return "Insertion Sort - Complexidade conceitual: O(n2)";

	}

}
