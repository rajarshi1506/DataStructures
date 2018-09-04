package com.raj.trees;

public interface Tree<T extends Comparable<T>> {

	public  void add(T value);
	
	public Boolean contains(T value);
	
	public int getSize();
	
	public void preOrderPrint();
		
}
