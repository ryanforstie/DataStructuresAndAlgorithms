
public class DynamicArray<String> {

  private Object[] data;
  private int size = 0;
  private int setCapacity;

  public DynamicArray(int setCapacity) {
    this.setCapacity = setCapacity;
    this.data = new Object[setCapacity];
  }

  public String get(int index) {
    return (String) this.data[index];
  }

  public void set(int index, String value) {
    this.data[index] = value;
  }

  public void insert(int index, String value) {

    // Check size
    if (this.size == this.setCapacity) {
      resize();
    }

    // Copy up
    for (int i = this.size; i > index; i--) {
      this.data[i] = this.data[i - 1];
    }

    // Insert
    this.data[index] = value;
    this.size++;
  }

  private void resize() {
    Object[] newData = new Object[this.setCapacity * 2];
    for (int i = 0; i < this.setCapacity; i++) {
      newData[i] = this.data[i];
    }
    this.data = newData;
  }

  public int size() {
    return size;
  }

  public void print() {
    for (int i = 0; i < this.size; i++) {
      System.out.println(data[i]);
    }
  }

  public void delete(int index) {
    // Copy down
    for (int i = index; i < this.size - 1; i++) {
      this.data[i] = this.data[i + 1];
    }
    this.size--;

    // Clear if last element in array
    if (index == this.size) {
      this.data[index] = null;
    }
  }

  public boolean isEmpty() {
    return this.size == 0;
  }

  public boolean Contains(String value) {
    for (int i = 0; i < this.size; i++) {
      String currentValue = (String) data[i];
      if (currentValue.equals(value)) {
        return true;
      }
    }
    return false;
  }
}