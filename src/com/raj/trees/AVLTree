package com.raj.trees;

public class AVLTree<T extends Comparable<T>> implements Tree<T> {

	private BinarySearchTree<T> tree;

	public AVLTree(BinarySearchTree<T> bTree) {
		this.tree = bTree;
	}

	private int getBalance(Node<T> node) {
		if (node == null)
			return 0;
		return height(node.left) - height(node.right);
	}

	private Node<T> rotateRight(Node<T> node) {

		Node<T> left = node.left;
		Node<T> right = left.right;

		left.right = node;
		node.left = right;

		left.height = max(height(left.left), height(left.right)) + 1;
		node.height = max(height(node.left), height(node.right)) + 1;

		return left;
	}

	private Node<T> rotateLeft(Node<T> node) {

		Node<T> right = node.right;
		Node<T> left = right.left;

		right.left = node;
		node.right = left;

		right.height = max(height(right.left), height(right.right)) + 1;
		node.height = max(height(node.left), height(node.right)) + 1;

		return right;
	}

	private int max(int a, int b) {
		return a > b ? a : b;
	}

	private Node<T> balanceNode(Node<T> node, Node<T> newNode) {


		int nodeBalance = getBalance(node);
		
		//System.out.println("node balance :::"+nodeBalance);

		// left left case
		if (nodeBalance > 1 && newNode.value.compareTo(node.left.value) < 0)
			return rotateRight(node);

		// left right case
		if (nodeBalance > 1 && newNode.value.compareTo(node.left.value) > 0) {
			node.left = rotateLeft(node.left);
			return rotateRight(node);
		}

		// right right case
		if (nodeBalance < -1 && newNode.value.compareTo(node.right.value) > 0)
			return rotateLeft(node);

		// right left case
		if (nodeBalance < -1 && newNode.value.compareTo(node.right.value) < 0) {
			node.left = rotateRight(node.right);
			return rotateLeft(node);
		}
		return node;

	}

	private int height(Node<T> node) {
		if (node == null)
			return 0;
		return max(height(node.left),height(node.right)) + 1;
	}

	public void add(T value) {
		Node<T> newNode = new Node<T>();
		newNode.value = value;
		
		//System.out.println("tree before adding:::");
		//tree.preOrderPrint();

		if (tree.root == null) {
			tree.root = newNode;
			tree.size++;
		} else {
			tree.size++;
			if (tree.root.value.compareTo(value) > 0) {
				tree.root.left = tree.insertNode(tree.root.left, newNode);

			} else if (tree.root.value.compareTo(value) < 0)
				tree.root.right = tree.insertNode(tree.root.right, newNode);
			else
				tree.size--;
		}

		tree.root=balanceNode(tree.root, newNode);
		//System.out.println("tree after adding:::");
		//tree.preOrderPrint();
	}

	@Override
	public Boolean contains(T value) {
		return tree.contains(value);
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return tree.getSize();
	}

	@Override
	public void preOrderPrint() {
		tree.preOrderPrint();		
	}

}
