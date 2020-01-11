
public class LinkedListStack {

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

  public void push(int data) {
    Node newNode = new Node(data);
    if (this.getSize() == 0) {
      this.head = newNode;
      this.tail = newNode;
      this.size++;
      return;
    }
    newNode.next = this.head;
    this.head = newNode;
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

  public void deleteStack() {
    if (this.isEmpty()) {
      throw new IllegalArgumentException("The linked list is empty.");
    }
    this.head = null;
    this.tail = null;
  }

  public int pop() {
    if (this.isEmpty()) {
      throw new IllegalArgumentException("The linked list is empty.");
    }
    Node deletedNode = this.head;
    if (this.getSize() == 1) {
      this.head = null;
      this.tail = null;
      this.size--;
      return deletedNode.data;
    }
    this.head = this.head.next;
    this.size--;
    return deletedNode.data;
  }
}
