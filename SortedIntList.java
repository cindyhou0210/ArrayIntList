package main;

import java.util.*;
//Cindy hou
//Cosi12B
//Antonella Dililo
//cindyhou0210@brandeis.edu
//this is the sortedIntList object class with constructors and various methods, this class inherits 
//basic behaviors from parent class ArrayIntList

public class SortedIntList extends ArrayIntList {

	private boolean unique;
	
	/**
	 * inheritate from the parent class
	 */
	public SortedIntList() {
		super();
	}

	/**
	 * constructor 
	 * @param unique
	 */
	public SortedIntList(boolean unique) {
		super();
		this.unique = unique;
	}
	
	/**
	 * constructing a new object with capacity
	 * @param capacity
	 */
	public SortedIntList(int capacity) {
		super(capacity);
		this.unique = false;
	}
	
	/**
	 * constructor a new object with its uniqueness and capacity
	 * @param unique
	 * @param capacity
	 */
	public SortedIntList(boolean unique, int capacity) {
		super(capacity);
		this.unique = unique;
		
	}
	
	/**
	 * add value in the sorted array, array should be remain sorted 
	 */
	public void add(int value) {
		if(size() < this.getLength() && indexOf(value) < 0 || !unique) {
			if(size() == 0) {
				resetValue(0,value);
			}
			for(int i = size(); i >0; i--) {
				if(get(i-1) > value) {
					//get (i) = get(i -1);
					resetValue(i, get(i-1));
					//intList[i - 1] = value;
					resetValue(i-1, value);
				} else {
					//intList[i] = value;
					resetValue(i,value);
					i = -1;
				}
			}
		}
		int neS = size();
		setSize(neS + 1);	
	}
	
	/**
	 * throws an exception when try to add value to a specific index
	 */
	public void add(int index, int value) {
		throw new UnsupportedOperationException("unsupported");
	}
	
	/**
	 * get the status of uniqueness
	 * @return the status
	 */
	public boolean getUnique() {
		return unique;
	}
	
	/**
	 * search for the minimum value in the array
	 * @return the min value
	 */
	public int min() {
		int min = get(0);
		for(int i = 1; i < size(); i++) {
			if(get(i) < min) {
				min =get(i);
			}
		}
		return min;
	}
	
	/**
	 * search for the maximum value in the array
	 * @return the max value
	 */
	public int max() {
		int max = get(0);
		for(int i = 1; i < size(); i++) {
			if(get(i) > max) {
				max = get(i);
			}
		}
		return max;
	}
	
	/**
	 * set the unique status to the parameter. if funique equals to true remove all the duplicates 
	 * @param unique
	 */
	public void setUnique(boolean unique) {
		if(unique == true) {
			for(int i = 0; i < size(); i++) {
				for(int j = i+1; j < size(); j++) {
					if(get(i) == get(j)) {
						remove(i);
					}
				}
			}
			this.unique= unique;
		} else {
			this.unique = unique;
		}
	}
	
	
	
	/**
	 * return the index of the value
	 * negative if its not found
	 */
	public int indexOf(int value) {
		int index1 =binarySearch(value);
		return index1;
	}
	
	/**
	 * to String method  
	 */
	public String toString() {
		int [] array = new int[this.size()];
		for(int i = 0; i < array.length;i++) {
			array[i] = this.get(i);
		}
		if(unique == true) {
			return "S: " + Arrays.toString(array) + "U";
		}
		return "S: " + Arrays.toString(array);
	}
	
	
}
