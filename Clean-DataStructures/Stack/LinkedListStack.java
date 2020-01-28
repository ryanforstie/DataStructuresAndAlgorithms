
public class LinkedListStack {

  public class Node {
    public int data;
    public Node next;

    public Node(int data) {
      this.data = data;
    }
  }

  public Node head;
  public int size;

  // Basic methods
  public boolean isEmpty() {
    return this.getSize() == 0;
  }

  public int peek() {
    if (this.isEmpty()) {
      throw new IllegalArgumentException("The linked list is empty.");
    }
    return this.head.data;
  }

  public void push(int data) {
    Node newNode = new Node(data);
    newNode.next = this.head;
    this.head = newNode;
    this.size++;
  }

  public int pop() {
    if (this.isEmpty()) {
      throw new IllegalArgumentException("The linked list is empty.");
    }
    int data = this.head.data;
    this.head = this.head.next;
    this.size--;
    return data;
  }
  // End of basic methods

  public int getSize() {
    return this.size;
  }

  public void deleteStack() {
    if (this.isEmpty()) {
      throw new IllegalArgumentException("The linked list is empty.");
    }
    this.head = null;
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
}
