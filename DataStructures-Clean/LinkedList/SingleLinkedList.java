
public class SingleLinkedList {

	public class Node {
		public int data;
		public Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public Node head;
	public Node tail;
	public int size;

	public int getSize() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.getSize() == 0;
	}

	public void insert(int data, int index) {
		Node newNode = new Node(data);
		if (this.getSize() == 0) {
			this.head = newNode;
			this.tail = newNode;
			this.size++;
			return;
		}
		if (index == 0) {
			newNode.next = this.head;
			this.head = newNode;
		} else if (index >= this.size) {
			newNode.next = null;
			this.tail.next = newNode;
			this.tail = newNode;
		} else {
			Node currentNode = this.head;
			int counter = 0;
			while (counter < index - 1) {
				currentNode = currentNode.next;
				counter++;
			}
			newNode.next = currentNode.next;
			currentNode.next = newNode;
		}
		this.size++;
	}

	public void print() {
		if (this.isEmpty()) {
			throw new IllegalArgumentException("The linked list is empty.");
		}
		Node currentNode = this.head;
		if (this.getSize() == 1) {
			System.out.println(currentNode.data);
			return;
		}
		while (currentNode != null) {
			System.out.println(currentNode.data);
			currentNode = currentNode.next;
		}
	}

	public void deleteSingleLinkedList() {
		if (this.isEmpty()) {
			throw new IllegalArgumentException("The linked list is empty.");
		}
		this.head = null;
		this.tail = null;
	}

	public void deleteNode(int index) {
		if (this.isEmpty()) {
			throw new IllegalArgumentException("The linked list is empty.");
		}
		if (this.getSize() == 1) {
			this.head = null;
			this.tail = null;
			this.size--;
			return;
		}
		if (index == 0) {
			this.head = this.head.next;
			this.size--;
		} else if (index >= this.getSize()) {
			Node currentNode = this.head;
			while (currentNode.next != this.tail) {
				currentNode = currentNode.next;
			}
			currentNode.next = null;
			this.tail = currentNode;
			this.size--;
		} else {
			Node currentNode = this.head;
			int counter = 0;
			while (counter < index - 1) {
				currentNode = currentNode.next;
				counter++;
			}
			currentNode.next = currentNode.next.next;
			this.size--;
		}
	}
}
