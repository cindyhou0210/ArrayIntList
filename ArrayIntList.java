package main;

import java.util.Arrays;

//Cindy hou
//Cosi12B
//Antonella Dililo
// cindyhou0210@brandeis.edu
//this is the arrayIntList object class with constructors and various methods
public class ArrayIntList {
	
	private int[] intList;
	private int size;
	
	/**
	 * constructor a default arrayintlist with a capacity of 10
	 */
	public ArrayIntList() {
		intList = new int[10];
		size = 0;
	}
	/**
	 * constructor an arrayinlist with a capacity
	 * @param capacity
	 */
	public ArrayIntList(int capacity) {
		if(capacity < 0) {
			throw new IllegalArgumentException("less than zero");
		}
		intList = new int[capacity];
		size = 0;
	}
	
	/**
	 * add value at the end of the list
	 * @param value
	 */
	public void add(int value) {
		for(int i = 0; i < intList.length; i++) {
			intList[size] = value;
		}
		size++;
	}
	
	/**
	 * add value at a specific index
	 * @param index
	 * @param value
	 */
	public void add(int index, int value) {
		ensureCapacity(size+1);
		checkIndex(index, 0,size);
		if(index <= size) {
			for(int i = index; i < size; i++) {
				intList[i+1] = intList[i];
				
			}
			intList[index] = value;
		}
		size++;
	}
	
	/**
	 * get value at a specific index
	 * @param index
	 * @return the value at the index
	 */
	public int get(int index) {
		int getValue = 0;
		for(int i = 0 ; i < intList.length; i++) {
			getValue = intList[index];
		}
		return getValue;
	}
	
	/**
	 * return the first index the value occurs in th list
	 * @param value
	 * @return the index
	 */
	public int indexOf(int value) {
		for(int i = 0; i < intList.length; i++) {
			if(intList[i] == value) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * remove specific index from the array
	 * @param index
	 */
	public void remove(int index) {
		checkIndex(index, 0, intList.length);
		for(int i = 1; i < intList.length - index; i++) {
			intList[index + i - 1] = intList[index + i];
		}
		size--;
	}
	
	/**
	 * return the size of the array
	 * @return the size
	 */
	public int size() {
		return size;
	}
	
	/**
	 * to string method
	 */
	public String toString() {
		int[] edited = new int[size];
		for(int i = 0; i < size; i++) {
			edited[i] = intList[i];
		}
		return Arrays.toString(edited);
	}
	
	/**
	 * clear all the elements
	 */
	public void clear() {
		for(int i = 0; i < intList.length; i++) {
			intList[i] = 0;
		}
		size = 0;
	}
	
	/**
	 * check if the array conatins one specific value
	 * @param value
	 * @return true if it does, false if not
	 */
	public boolean contains(int value) {
		for(int i = 0; i < intList.length; i++) {
			if(intList[i] == value) {
				return true;
			} 
		}
		return false;
	}
	
	/**
	 * makes sure that this list's internal array is large 
	 * enough to store at least the given number of elements
	 * @param capacity
	 */
	public void ensureCapacity(int capacity) {
		if(capacity > intList.length) {
			int newCap = capacity * 2;
			int[] newArray = new int[newCap];
			for(int i = 0; i < size; i++) {
				newArray[i] = intList[i];
			}
			intList= newArray;
		}
	}
	
	/**
	 * check if the array is empty
	 * @return true if it is and false if not
	 */
	public boolean isEmpty() {
		if(size == 0) {
			return true;
		}
		return false;
	}
	
	/**
	 * check if the index is within the range
	 * @param index
	 * @param min
	 * @param max
	 */
	private void checkIndex(int index, int min, int max) {
		if(index > max || index < min) {
			throw new IndexOutOfBoundsException("out of bounce index" + index);
		}
	}
	
	/**
	 * helper method to get the range
	 * @return the length
	 */
	public int getLength() {
		return intList.length;
	}
	
	/**
	 * binary search method
	 * @param value
	 * @return the result from binary search
	 */
	protected int binarySearch(int value) {
		int search = Arrays.binarySearch(intList, 0,size, value);
		return search;
	}
	
	/**
	 * set the size to the parameter
	 * @param value
	 */
	protected void setSize(int value) {
		size = value;
	}
	
	/**
	 * set the value at index equals to value passed 
	 * @param index
	 * @param value
	 */
	protected void resetValue(int index, int value) {
		intList[index] = value;
	}

}
