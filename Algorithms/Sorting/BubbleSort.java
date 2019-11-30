public class BubbleSort {
  public static void main(String[] args) {
    int[] array = { 1, 4, 2, 1, 8, 5 };
    sort(array);
    for (int i = 0; i < array.length; i++) {
      System.out.print(array[i] + " ");
    }
  }

  public static int[] sort(int array[]) {
    boolean didSwap = false;
    for (int i = 0; i < array.length - 1; i++) {
      for (int j = 0; j < array.length - 1 - i; j++) {
        if (array[j] > array[j + 1]) {
          int temp = array[j];
          array[j] = array[j + 1];
          array[j + 1] = temp;
          didSwap = true;
        }
      }
      if (didSwap == false) {
        break;
      }
    }
    return array;
  }

}