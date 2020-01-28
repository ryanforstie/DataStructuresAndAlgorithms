import java.util.Arrays;

public class MinHeap {
  private int capacity = 10;
  private int size = 0;

  int[] items = new int[this.capacity];

  // Helper methods
  private int getLeftChildIndex(int parentIndex) {
    return 2 * parentIndex + 1;
  }

  private int getRightChildIndex(int parentIndex) {
    return 2 * parentIndex + 2;
  }

  private int getParentIndex(int childIndex) {
    return (childIndex - 1) / 2;
  }

  private boolean hasLeftChild(int index) {
    return this.getLeftChildIndex(index) < this.size;
  }

  private boolean hasRightChild(int index) {
    return this.getRightChildIndex(index) < this.size;
  }

  private boolean hasParent(int index) {
    return this.getParentIndex(index) >= 0;
  }

  private int leftChild(int index) {
    return this.items[this.getLeftChildIndex(index)];
  }

  private int rightChild(int index) {
    return this.items[this.getRightChildIndex(index)];
  }

  private int parent(int index) {
    return this.items[this.getParentIndex(index)];
  }

  private void swap(int indexOne, int indexTwo) {
    int temp = items[indexOne];
    items[indexOne] = items[indexTwo];
    items[indexTwo] = temp;
  }

  private void ensureExtraCapacity() {
    if (this.size == this.capacity) {
      this.items = Arrays.copyOf(this.items, this.capacity * 2);
      this.capacity *= 2;
    }
  }
  // End of helper methods

  public int peek() {
    if (this.size == 0)
      throw new IllegalStateException();
    return this.items[0];
  }

  public int poll() {
    if (this.size == 0)
      throw new IllegalStateException();
    int item = this.items[0];
    this.items[0] = this.items[this.size - 1];
    this.size--;
    this.heapifyDown();
    return item;
  }

  public void add(int item) {
    this.ensureExtraCapacity();
    this.items[this.size] = item;
    this.size++;
    this.heapifyUp();
  }

  public void heapifyUp() {
    int index = this.size - 1;
    while (this.hasParent(index) && this.parent(index) > this.items[index]) {
      this.swap(this.getParentIndex(index), index);
      index = this.getParentIndex(index);
    }
  }

  public void heapifyDown() {
    int index = 0;
    while (this.hasLeftChild(index)) {
      int smallerChildIndex = this.getLeftChildIndex(index);
      if (this.hasRightChild(index) && this.rightChild(index) < this.leftChild(index)) {
        smallerChildIndex = this.getRightChildIndex(index);
      }

      if (this.items[index] < this.items[smallerChildIndex]) {
        break;
      } else {
        this.swap(index, smallerChildIndex);
      }
      index = smallerChildIndex;
    }
  }

}