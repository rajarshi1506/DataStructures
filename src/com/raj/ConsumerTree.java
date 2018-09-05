package com.raj;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.IntStream;

import com.raj.trees.*;

public class ConsumerTree {

	public static void main(String[] args) {
		Random ran = new Random();

		ArrayList<Integer> arr = new ArrayList<>();
		BinarySearchTree<Integer> bsTree = new BinarySearchTree<>();
		BinarySearchTree<Integer> bTree = new BinarySearchTree<>();
		AVLTree<Integer> avlTree = new AVLTree<>(bTree);

		/**
		 * arraylist
		 **/

		long start = System.nanoTime();

		IntStream.range(1, 10000).forEach(i -> {
			int x = ran.nextInt(10000);
			if (!arr.contains(x))
				arr.add(x);
		});

		System.out.println("Time taken to load arraylist of size " + arr.size() + " :::" + (System.nanoTime() - start));
		/**
		 * binary search tree
		 **/

		start = System.nanoTime();
		IntStream.range(1, 10000).forEach(i -> {
			int x = ran.nextInt(10000);
			bsTree.add(x);
		});

		System.out
				.println("Time taken to load tree of size " + bsTree.getSize() + " :::" + (System.nanoTime() - start));

		/**
		 * arraylist
		 **/

		start = System.nanoTime();
		System.out.println(arr.contains(999));

		System.out.println("Time taken to get from arraylist:::" + (System.nanoTime() - start));
		/**
		 * binary search tree
		 **/

		start = System.nanoTime();
		System.out.println(bsTree.contains(999));

		System.out.println("Time taken to get from tree:::" + (System.nanoTime() - start));
		/**
		 * avl tree
		 **/

		start = System.nanoTime();
		IntStream.range(1, 1000000).forEach(i -> {
			int x = ran.nextInt(1000000);
			
			avlTree.add(x);
		});

		System.out.println(
				"Time taken to load avltree of size " + avlTree.getSize() + " :::" + (System.nanoTime() - start));

		/**
		 * avl tree
		 **/
		start = System.nanoTime();
		System.out.println(avlTree.contains(999));

		System.out.println("Time taken to get from avltree:::" + (System.nanoTime() - start));

		/*
		 * AVLTree<Integer> avlTree2 = new AVLTree(new BinarySearchTree<>());
		 * BinarySearchTree<Integer> bTree2 = new BinarySearchTree<>();
		 * ArrayList<Integer> arr2 = new ArrayList<>(); IntStream.range(1,
		 * 10000).forEach(i -> { int x = ran.nextInt(10000); x = i; if (!arr2.contains(x))
		 * arr2.add(x); avlTree2.add(x); bTree2.add(x);
		 * 
		 * });
		 * 
		 * long startNS = System.nanoTime(); System.out.println("found:::" +
		 * arr2.contains(10000) + "  time taken:::" + (System.nanoTime() - startNS));
		 */

		// avlTree2.preOrderPrint();
		// bTree2.preOrderPrint();

	}

}
