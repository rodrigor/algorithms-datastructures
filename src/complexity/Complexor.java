/**
 * 
 */
package complexity;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import sorting.Cost;
import sorting.InsertionSort;
import sorting.MergeSort;
import sorting.SortingAlgorithm;
import util.Array;
import util.Util;

/**
 * @author Rodrigo Rebouças de Almeida (http://github.com/rodrigor)
 * @date Apr 30, 2017
 */
public class Complexor {

	
	public void run(SortingAlgorithm algorithm, int size, int jumpSize, long seed, String fileName){
		Random random = (seed < 0 ? new Random() : new Random(seed));
		int arraySize = 1;

		System.out.println("RUNNING: "+algorithm.getName()+"...");
		int percent = 0;
		int fraction = size / 100;

		File file = new File(Util.getInstance().getAbsolutePath(fileName));
		System.out.println("FILE:"+file.getAbsolutePath());
		try {
			FileWriter out = new FileWriter(file);

			for (int i = 0; i < size; i++) {
				arraySize += jumpSize;

				Cost cost = new Cost(arraySize);
				int[] array = createArray(arraySize, random).getArray();

				long begin = System.currentTimeMillis();
				
				MergeSort.mergeSort(array, cost);
				
				long end = System.currentTimeMillis();
				long compTime = end - begin;
				cost.setComputationTime(compTime);

				out.write(cost + "\n");
				out.flush();

				if (i == fraction) {
					percent++;
					fraction += size / 100;
					System.out.println("" + percent + "%: Last computation time:" + compTime);
				}
			}
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("END!");
		
	}

	/**
	 * @param jump
	 * @param random
	 * @return
	 */
	static Array createArray(int arraySize, Random random) {
		int[] array = new int[arraySize];
		for (int i = 0; i < arraySize; i++) {
			array[i] = random.nextInt();
		}
		return new Array(array);
	}

	public static void main(String[] args) throws IOException {
		Complexor complexor = new Complexor();
		int size = 5000;
		int jumpSize = 100;
		long seed = 9834754;
		complexor.run(new MergeSort(),size, jumpSize, seed,"mergeSort.csv");

		complexor.run(new InsertionSort(),size, jumpSize, seed,"insertionSort.csv");

	}

	
}
