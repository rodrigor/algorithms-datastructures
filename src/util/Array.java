package util;

import java.util.*;

public class Array {
	private int[] array;
	
	public Array(){
		this.array = new int[0];
	}
	
	public Array(int[] array){
		this.array = array;
	}
	
	public int[] getArray(){
		return this.array;
	}
	
	public int getLength(){
		return this.array.length;
	}
	
	public String toString(){
		return Arrays.toString(array);
	}
	
	
	/**
	 * @param length array length
	 * @param bound up limit of the generated numbers. Numbers are generated between 0 (inclusive) and the bound value (exclusive)
	 * @return an array of int numbers. The numbers can be repeated.
	 */
	public static int[] newRandomIntArray(int length, int bound){
		return newRandomIntArray(length, bound, -1);
	}

	public static int[] newRandomIntArray(int length, int bound, long seed){
		int[] array = new int[length];
		Random gen = (seed == -1?new Random(): new Random(seed));
		for (int i = 0; i < array.length; i++){
			array[i] = gen.nextInt(bound); 
		}
		return array;
	}
	
	public static void main(String[] args) {

	}

}
