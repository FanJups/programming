package node;

public class BinaryTree {

	Node root;

	private Node addRecursive(Node current, int value) {
		if (current == null) {
			return new Node(value);
		}

		if (value < current.value) {
			current.left = addRecursive(current.left, value);
		} else if (value > current.value) {
			current.right = addRecursive(current.right, value);
		} else {
			// value already exists
			return current;
		}

		return current;
	}

	public void add(int value) {
		root = addRecursive(root, value);
	}

	private BinaryTree createBinaryTree() {
		BinaryTree bt = new BinaryTree();

		bt.add(6);
		bt.add(4);
		bt.add(8);
		bt.add(3);
		bt.add(5);
		bt.add(7);
		bt.add(9);

		return bt;
	}

	/*
	 * 
	 * private boolean containsNodeRecursive(Node current, int value) {
	 * 
	 * 
	 * 
	 * if(current == null) {
	 * 
	 * return false;
	 * 
	 * }
	 * 
	 * if(value == current.value) { return true; }else {
	 * 
	 * 
	 * 
	 * if(value < current.value) { return containsNodeRecursive(current.left,
	 * value);
	 * 
	 * }else {
	 * 
	 * return containsNodeRecursive(current.right, value);
	 * 
	 * 
	 * 
	 * 
	 * }
	 * 
	 * 
	 *                    }
	 */

	/*
	 * public boolean containsNode(int value) { return containsNodeRecursive(root,
	 * value); }
	 */

	private Node deleteRecursive(Node current, int value) {
		if (current == null) {
			return null;
		}

		if (value == current.value) {
			// Node to delete found
			// ... code to delete the node will go here
		}
		if (value < current.value) {
			current.left = deleteRecursive(current.left, value);
			return current;
		}
		current.right = deleteRecursive(current.right, value);
		return current;
	}

	private int findSmallestValue(Node root) {
		return root.left == null ? root.value : findSmallestValue(root.left);
	}

	public void delete(int value) {
		root = deleteRecursive(root, value);
	}

}
