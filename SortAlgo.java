import java.io.*;
import java.util.*;

class MergeSort {
  public static void mergeSort(Integer[] a, int p, int r, int debug) {
    System.out.println(p + " " + r + " " + debug);
    if (p < r) {
      int mid = p + (r - p) / 2;

      mergeSort(a, p, mid, 0);
      mergeSort(a, mid + 1, r, 1);
      merge(a, p, mid, r);
    }
    System.out.println("Final Output");
    printOutput(a);
  }

  public static void merge(Integer[] a, int p, int q, int r) {
    /*
     * range-1 [p..q]
     * range-2 [q+1..r]
     */
    int range_1 = q - p + 1;
    int range_2 = r - q;
    int i = 0, j = 0, k = p;
    Integer left_arr[] = new Integer[range_1];
    Integer right_arr[] = new Integer[range_2];
    for (int m = 0; m < range_1; m++)
      left_arr[m] = a[p + m];
    for (int m = 0; m < range_2; m++)
      right_arr[m] = a[q + 1 + m];

    while (i < range_1 && j < range_2) {
      if (left_arr[i] < right_arr[j]) {
        a[k++] = left_arr[i++];
      } else {
        a[k++] = right_arr[j++];
      }
    }
    for (int m = i; m < range_1; m++)
      a[k++] = left_arr[m];
    for (int m = j; m < range_2; m++)
      a[k++] = right_arr[m];

  }

  public static void printOutput(Integer arr[]) {
    System.out.println("\nItems in the list");
    for (int i : arr) {
      System.out.print(i + "\t");
    }
  }
}

class SortAlgo {
  Integer item[] = new Integer[15];

  public SortAlgo(Integer... E) {
    item = E;
  }

  public void bubbleSort() {
    int temp;
    for (int i = 0; i < item.length; i++) {
      for (int j = i + 1; j < item.length; j++) {
        if (item[i] > item[j]) {
          temp = item[i];
          item[i] = item[j];
          item[j] = temp;
        }
      }
    }
  }

  public void printOutput() {
    System.out.println("Items in the list");
    for (int i : item) {
      System.out.print(i + "\t");
    }
  }

  public void selectionSort() {
    int pos = 0, temp = 0;
    for (int i = 0; i < item.length; i++) {
      pos = i;
      for (int j = i + 1; j < item.length; j++) {
        if (item[pos] > item[j]) {
          pos = j;
        }
      }
      temp = item[i];
      item[i] = item[pos];
      item[pos] = temp;
      // this.printOutput();
    }
  }

  public void insertionSort() {
    int curval = 0, pos = 0;
    for (int i = 0; i < item.length; i++) {
      curval = item[i];
      pos = i;
      /* push all values greater than curval by 1 position */
      while (pos > 0 && item[pos - 1] > curval) {
        item[pos] = item[pos - 1];
        pos = pos - 1;
      }
      item[pos] = curval;
      // this.printOutput();
    }

  }

  /*
   * public void mergeSort() {
   * 
   * }
   * 
   * public void quickSort() {
   * 
   * }
   * 
   * public void quickSort() {
   * 
   * }
   */

  public static void main(String args[]) {
    Scanner s = new Scanner(System.in);
    Integer arr[] = new Integer[] { 12, 32, 4, 1, 55, 32, 5, 22, 45, 100, 33, 45, 90, 98, 96 };

    SortAlgo obj = new SortAlgo(new Integer[] { 12, 32, 4, 1, 55, 32, 5, 22, 45, 100, 33, 45, 90, 98, 96 });
    System.out.println("1. Bubble Sort \n 2. Selection Sort\n" +
        "3.Insertion Sort\n 4. Merge Sort\n");
    switch (s.nextInt()) {
      case 1:
        obj.bubbleSort();
        break;
      case 2:
        obj.selectionSort();
        break;
      case 3:
        obj.insertionSort();
        break;
      case 4:
        MergeSort.mergeSort(arr, 0, arr.length - 1, 2);
        // MergeSort.printOutput(arr);
        break;
      default:
        System.out.println("No options selected");
    }
    obj.printOutput();
    /* BubbleSort Execution Block */
    long startTime = System.currentTimeMillis();
  }

}