package com.rbc.tree;

/**
 * 
 * @author Urjasri sorted binary tree no duplicates
 *
 */
public class BinaryTree {

	private Node root;

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	public BinaryTree() {
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.display();
	}

	/**
	 * display nodes
	 */
	private String display() {
		if (this.getRoot() == null)
			return "tree is empty";
		else
			return "Tree:::" + printNode(this.getRoot(), "");
	}

	private String printNode(Node node, String treeBefore) {
		if (node == null)
			return treeBefore;
		treeBefore = treeBefore + " " + node.getValue();

		// print left tree
		treeBefore = printNode(node.getLeft(), treeBefore);
		// print right tree
		treeBefore = printNode(node.getRight(), treeBefore);
		return treeBefore;
	}

	/**
	 * add Node
	 */
	public void add(int value) {
		if (this.getRoot() == null)
			this.setRoot(new Node(value));
		else
			addNode(this.getRoot(), value);
	}

	private Node addNode(Node node, int value) {
		if (node == null) {
			return new Node(value);
		}
		// go left if new value is smaller than current node
		if (value < node.getValue()) {
			node.setLeft(addNode(node.getLeft(), value));
		} else if (value > node.getValue()) {
			// go right
			node.setRight(addNode(node.getRight(), value));
		} else {
			// return element if value already exists
			return node;
		}
		return node;
	}

	/**
	 * getNode
	 */

	public boolean find(int value) {
		return findNode(this.getRoot(), value) != null ? true : false;
	}

	public Node findNode(Node node, int value) {
		// end of tree branch
		if (node == null)
			return null;
		// node found
		if (value == node.getValue())
			return node;
		// go left
		if (value < node.getValue()) {
			node = findNode(node.getLeft(), value);
		} else {
			// go right
			node = findNode(node.getRight(), value);
		}
		return node;
	}

	/**
	 * drop Node
	 */

	public void drop(int value) {
		dropNode(this.getRoot(), value);
	}

	public Node dropNode(Node node, int value) {
		// check if value exist

		System.out.println("node::" + node);
		if (node == null) {
			System.out.println("value does not exist");
			return null;
		}
		// value exist
		if (node.getValue() == value) {
			// node with no children
			if (node.getLeft() == null && node.getRight() == null)
				node = null;
			// node with only left branch
			else if (node.getLeft() != null && node.getRight() == null)
				node = node.getLeft();
			// node with only right branch
			else if (node.getLeft() == null && node.getRight() != null)
				node = node.getRight();
			else {
				// replace the node with the smallest on the right//this will also work if we
				// replace with largest on the left
				int smallestValue = getSmallestBasedOnaNode(node.getRight()).getValue();
				node.setValue(smallestValue);
				node.setRight(dropNode(node.getRight(), smallestValue));
			}
		} else if (value < node.getValue()) {
			node.setLeft(dropNode(node.getLeft(), value));
		} else {
			node.setRight(dropNode(node.getRight(), value));
		}
		return node;

	}

	/**
	 * get smallest based on a Node
	 */
	private Node getSmallestBasedOnaNode(Node node) {
		if (node == null)
			return null;
		else {
			while (node.getLeft() != null) {
				node = node.getLeft();
			}
		}
		return node;
	}

	/**
	 * get smallest
	 */
	public Node getSmallestNode() {
		return getSmallestBasedOnaNode(this.getRoot());
	}
}

class Node {

	private int value;
	private Node left;
	private Node right;

	public Node(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return new Integer(this.getValue()).toString();
	}

}
