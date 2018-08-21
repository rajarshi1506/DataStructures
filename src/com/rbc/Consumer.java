package com.rbc;

import com.rbc.tree.BinaryTree;

public class Consumer {

	public static void main(String[] args) {
		BinaryTree bTree = new BinaryTree();
		System.out.println("adding nodes");
		bTree.add(3);
		bTree.add(5);
		bTree.add(2);
		bTree.add(4);

		System.out.println("displaying nodes");
		System.out.println(bTree);

		System.out.println("finding nodes");

		checkIfExists(bTree, 3);
		checkIfExists(bTree, 5);
		checkIfExists(bTree, 8);
		System.out.println("smallest::" + bTree.getSmallestNode());
		
		System.out.println("dropping nodes");
		bTree.drop(5);
		System.out.println(bTree);

	}

	private static void checkIfExists(BinaryTree bTree, int value) {
		System.out.println(bTree.find(value) == true ? value + " found" : value + " not found");
	}

}
