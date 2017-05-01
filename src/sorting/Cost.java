/**
 * 
 */
package sorting;

/**
 * @author Rodrigo Rebouças de Almeida (http://github.com/rodrigor)
 * @date Apr 30, 2017
 */
public class Cost {
	
	
	private int inputSize;
	private long cost;
	private boolean active;
	private long computationTime;
	
	public Cost(int inputSize){
		cost = 0;
		this.active = true;
		this.inputSize = inputSize;
	}
	
	/**
	 * @param b
	 */
	public Cost(boolean active) {
		this.active = active;
		this.inputSize = -1;
		this.cost = -1;
	}

	public void plus(int cost){
		if(active) this.cost += cost;
	}
	
	public void plus(){
		if(active) this.cost++;
	}
	
	public long getCost(){
		return this.cost;
	}
	
	public int getInputSize(){
		return this.inputSize;
	}

	/**
	 * @return the computationTime
	 */
	public long getComputationTime() {
		return computationTime;
	}

	/**
	 * @param computationTime the computationTime to set
	 */
	public void setComputationTime(long computationTime) {
		this.computationTime = computationTime;
	}
	
	public String toString(){
		return ""+this.inputSize+","+this.cost+","+this.computationTime;
	}

}
