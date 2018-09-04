package com.raj.trees;

class Node<T> {
	public Node<T> left;
	public Node<T> right;
	public T value;
	public int height;

}

public class BinarySearchTree<T extends Comparable<T>> implements Tree<T> {

	protected Node<T> root;
	protected int size = 0;

	public int getSize() {
		return size;
	}

	public Node<T> getRoot() {
		return root;
	}

	public void setRoot(Node<T> root) {
		this.root = root;
	}

	public void add(T value) {
		Node<T> newNode = new Node<T>();
		newNode.value = value;

		if (root == null) {
			root = newNode;
			size++;
		} else {
			size++;
			if (root.value.compareTo(value) > 0)
				root.left = insertNode(root.left, newNode);

			else if (root.value.compareTo(value) < 0)
				root.right = insertNode(root.right, newNode);
			else {
				size--;
				return;
			}
		}

	}

	protected Node<T> insertNode(Node<T> node, Node<T> newNode) {
		if (node == null)
			return newNode;
		if (node.value.compareTo(newNode.value) == 0) {
			// System.out.println("Value exists");
			size--;// bring back to original size
			return node;
		} else if (node.value.compareTo(newNode.value) > 0) {
			node.left = insertNode(node.left, newNode);

		} else

		{
			node.right = insertNode(node.right, newNode);
		}
		return node;
	}

	public Boolean contains(T value) {
		if (root == null)
			return false;
		else {
			return findValue(root, value) == null ? false : true;
		}

	}

	private Node<T> findValue(Node<T> node, T value) {
		if (node == null)
			return null;
		if (node.value.compareTo(value) == 0) {
			return node;
		} else if (node.value.compareTo(value) < 0) {
			return findValue(node.right, value);
		} else {
			return findValue(node.left, value);
		}
	}

	private void preOrder(Node<T> node) {
		if (node != null) {
			System.out.print(node.value + " ");
			preOrder(node.left);
			preOrder(node.right);
		}
	}

	public void preOrderPrint() {
		preOrder(root);
		System.out.println("");
	}
}
