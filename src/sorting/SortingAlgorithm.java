/**
 * 
 */
package sorting;

/**
 * @author Rodrigo Rebouças de Almeida (http://github.com/rodrigor)
 * @date Apr 30, 2017
 */
public interface SortingAlgorithm {
	
	public void sort(int[] array, Cost cost);
	
	public String getName();

}
