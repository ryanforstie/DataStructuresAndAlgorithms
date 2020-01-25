
public class BubbleSort {

  public static void bubbleSort(int[] array) {
    boolean isSorted = false;
    int lastUnsorted = array.length - 1;
    while (!isSorted) {
      isSorted = true;
      for (int i = 0; i < lastUnsorted; i++) {
        if (array[i] > array[i + 1]) {
          swap(array, i, i + 1);
          isSorted = false;
        }
      }
      lastUnsorted--;
    }
  }

  public static void swap(int[] array, int i, int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }

}
