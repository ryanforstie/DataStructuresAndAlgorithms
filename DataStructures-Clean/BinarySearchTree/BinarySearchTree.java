
public class BinarySearchTree {
	public class Node {
		Node left, right;
		int data;

		public Node(int data) {
			this.data = data;
		}
	}

	public void insert(int value) {
		if (value <= this.data) {
			if (this.left == null) {
				this.left = new Node(value);
			} else {
				this.left.insert(value);
			}
		} else {
			if (this.right == null) {
				this.right = new Node(value);
			} else {
				this.right.insert(value);
			}
		}
	}

	public boolean contains(int value) {
		if (value == this.data) {
			return true;
		} else if (value < this.data) {
			if (this.left == null) {
				return false;
			} else {
				return this.left.contains(value);
			}
		} else {
			if (this.right == null) {
				return false;
			} else {
				return this.right.contains(value);
			}
		}
	}

	public void printInOrder() {
		if (this.left != null) {
			this.left.printInOrder();
		}
		System.out.println(this.data);
		if (this.right != null) {
			this.right.printInOrder();
		}
	}

	// inOrder - left, root, right
	// preOrder - root, left, right
	// postOrder - left, right, root
}