package com.jiangzh.algorithm.primary.c1;

import java.util.Arrays;

/**
 * Sort an array using multiple algorithms
 *
 * @author: Jiang Zheng
 * @date: 2025-09-23
 * @version: 1.0
 */
public class Three_SortArray {

  /**
   * Sort an array using bubble sort algorithm The process of bubble sort: 1. Compare adjacent
   * elements, if the first is greater than the second, swap them. 2. Repeat this process for each
   * pair of adjacent elements from the beginning to the end of the array. 3. After each pass, the
   * largest unsorted element will "bubble up" to its correct position. 4. Repeat the entire process
   * for the remaining unsorted elements until the entire array is sorted.
   *
   * @param arr
   * @return
   */
  public static void bubbleSort(int[] arr) {
    if (arr == null || arr.length < 2) {
      return;
    }

    int arrSize = arr.length;

    for (int i = arrSize; i > 0; i--) {
      for (int j = 0; j < i - 1; j++) {
        if (arr[j] > arr[j + 1]) {
          swap(arr, j, j + 1);
        }
      }
    }
  }

  /**
   * Sort an array using selection sort algorithm The process of selection sort: 1. Find the
   * smallest element in the unsorted array. 2. Swap it with the first unsorted element. 3. Move the
   * boundary of the sorted and unsorted array one position to the right. 4. Repeat the process for
   * the remaining unsorted elements until the entire array is sorted.
   *
   * @param arr
   * @return
   */
  public static void selectionSort(int[] arr) {
    if (arr == null || arr.length < 2) {
      return;
    }

    int arrSize = arr.length;

    for (int i = 0; i < arrSize; i++) {
      int minimum = arr[i];
      int minimumIndex = i;

      for (int j = i + 1; j < arrSize; j++) {
        if (arr[j] < minimum) {
          minimum = arr[j];
          minimumIndex = j;
        }
      }

      if (minimumIndex != i) {
        swap(arr, i, minimumIndex);
      }
    }
  }

  /**
   * Sort an array using insertion sort algorithm The process of insertion sort: 1. Start from the
   * second element, compare it with the elements before it. 2. If the current element is smaller
   * than the previous elements, shift the larger elements one position to the right to make space
   * for the current element. 3. Insert the current element into its correct position in the sorted
   * part of the array. 4. Repeat the process for all elements in the array until the entire array
   * is sorted.
   *
   * @param arr
   * @return
   */
  public static void insertionSort(int[] arr) {
    if (arr == null || arr.length < 2) {
      return;
    }

    int arrSize = arr.length;

    for (int i = 0; i < arrSize - 1; i++) {
      for (int j = i; j >= 0; j--) {
        if (arr[j + 1] < arr[j]) {
          swap(arr, j + 1, j);
        } else {
          break;
        }
      }
    }
  }

  public static void main(String[] args) {
    int[] arr = new int[] {3, 5, 1, 4, 2, 6, 4, 6, 7, 8, 9, 4, 1, 4, 5, 7, 8};
    int[] arr1;
    printArray(arr);

    System.out.println("================ 这是一条分割线 =========================");
    arr = generateRandomArray(100, 100);
    arr1 = copyArray(arr);
    comparator(arr1);
    bubbleSort(arr);
    System.out.println("bubbleSort result : " + isEqual(arr, arr1));

    System.out.println("================ 这是一条分割线 =========================");
    arr = generateRandomArray(100, 100);
    arr1 = copyArray(arr);
    comparator(arr1);
    selectionSort(arr);
    System.out.println("selectionSort result : " + isEqual(arr, arr1));

    System.out.println("================ 这是一条分割线 =========================");
    arr = generateRandomArray(100, 100);
    arr1 = copyArray(arr);
    comparator(arr1);
    insertionSort(arr);
    System.out.println("insertionSort result : " + isEqual(arr, arr1));
  }

  private static void printArray(int[] arr) {
    if (arr == null) {
      return;
    }

    for (int j : arr) {
      System.out.print(j + " ");
    }
    System.out.println();
  }

  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  // for test
  public static void comparator(int[] arr) {
    Arrays.sort(arr);
  }

  // for test
  public static int[] generateRandomArray(int maxSize, int maxValue) {
    // Math.random() [0,1)
    // Math.random() * N [0,N)
    // (int)(Math.random() * N) [0, N-1]
    int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
    for (int i = 0; i < arr.length; i++) {
      // [-? , +?]
      arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
    }
    return arr;
  }

  // for test
  public static int[] copyArray(int[] arr) {
    if (arr == null) {
      return null;
    }
    int[] res = new int[arr.length];
    for (int i = 0; i < arr.length; i++) {
      res[i] = arr[i];
    }
    return res;
  }

  // for test
  public static boolean isEqual(int[] arr1, int[] arr2) {
    if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
      return false;
    }
    if (arr1 == null && arr2 == null) {
      return true;
    }
    if (arr1.length != arr2.length) {
      return false;
    }
    for (int i = 0; i < arr1.length; i++) {
      if (arr1[i] != arr2[i]) {
        return false;
      }
    }
    return true;
  }
}
