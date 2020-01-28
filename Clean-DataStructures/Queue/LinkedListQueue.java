
public class LinkedListQueue {

  public class Node {
    public int data;
    public Node next;

    public Node(int data) {
      this.data = data;
    }
  }

  public Node head; // remove from here
  public Node tail; // add things here
  public int size;

  // Basic methods
  public boolean isEmpty() {
    return this.head == null;
  }

  public int peek() {
    if (this.isEmpty()) {
      throw new IllegalArgumentException("The linked list is empty.");
    }
    return this.head.data;
  }

  public void add(int data) {
    Node newNode = new Node(data);
    if (tail != null) {
      this.tail.next = newNode;
    }
    this.tail = newNode;
    if (this.head == null) {
      this.head = newNode;
    }
    this.size++;
  }

  public int remove() {
    if (this.isEmpty()) {
      throw new IllegalArgumentException("The linked list is empty.");
    }
    int data = this.head.data;
    this.head = this.head.next;
    if (this.head == null) {
      this.tail = null;
    }
    this.size--;
    return data;
  }
  // End of basic methods

  public void enqueue(int data) {
    Node newNode = new Node(data);
    if (this.getSize() == 0) {
      this.head = newNode;
      this.tail = newNode;
      this.size++;
      return;
    }
    newNode = this.tail.next;
    this.tail = newNode;
    this.size++;
  }

  public int dequeue() {
    if (this.isEmpty()) {
      throw new IllegalArgumentException("The linked list is empty.");
    }
    if (this.getSize() == 1) {
      Node dequeueNode = this.head;
      this.head = null;
      this.tail = null;
      this.size--;
      return dequeueNode.data;
    }
    Node dequeueNode = this.head;
    this.head = this.head.next;
    this.size--;
    return dequeueNode.data;
  }

  public void deleteQueue() {
    if (this.isEmpty()) {
      throw new IllegalArgumentException("The linked list is empty.");
    }
    this.head = null;
  }

  public int getSize() {
    return this.size;
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
