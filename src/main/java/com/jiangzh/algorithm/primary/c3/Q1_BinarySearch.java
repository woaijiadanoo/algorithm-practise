package com.jiangzh.algorithm.primary.c3;

import com.jiangzh.algorithm.primary.c1.Three_SortArray;
import com.jiangzh.algorithm.utils.ArrayUtils;

/**
 * 二分法查找
 *
 * @author: Jiang Zheng
 * @date: 2025-09-29
 * @version: 1.0
 */
public class Q1_BinarySearch {

  private static int binarySearch(int[] arr, int target) {
    int index = -1;
    if (arr == null || arr.length == 0) {
      return index;
    }

    if (arr.length == 1) {
      return arr[0] == target ? 0 : index;
    }

    int left = 0;
    int right = arr.length - 1;
    while (left <= right) {
      int middle = left + ((right - left) >> 1);
      if (arr[middle] == target) {
        return middle;
      }

      if (arr[middle] > target) {
        right = middle - 1;
      } else {
        left = middle + 1;
      }
    }

    return index;
  }

  public static void main(String[] args) {
    int[] arr = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};

    ArrayUtils.printArray(arr);
    int index = binarySearch(arr, 3);
    System.out.println("index = " + index);
  }
}
