package com.jiangzh.algorithm.primary.c2;

/**
 * Prefix sum of an array
 *
 * @author: Jiang Zheng
 * @date: 2025-09-26
 * @version: 1.0
 */
public class Q1_PrefixSum {

  /**
   * 重构一个数组，里面每一个元素都是前N位数字的和 前缀和就是取第N-1位的值
   *
   * @param prefixNum
   * @param arr
   * @return
   */
  private static int prefixsum(int prefixNum, int[] arr) {
    int result = -1;
    if (arr == null || prefixNum < 1 || arr.length < prefixNum) {
      return result;
    }

    int arrayLength = arr.length;
    for (int i = 1; i < arrayLength; i++) {
      arr[i] = arr[i - 1] + arr[i];
    }

    return arr[prefixNum - 1];
  }

  private static int sumFromRtoL(int L, int R, int[] arr) {
    int result = -1;
    if (arr == null || L < 1 || L > R || arr.length < R) {
      return result;
    }

    int arrayLength = arr.length;
    int[] preSum = new int[arrayLength];
    preSum[0] = arr[0];
    for (int i = 1; i < arrayLength; i++) {
      preSum[i] = preSum[i - 1] + arr[i];
    }

    return preSum[R] - preSum[L - 1];
  }

  public static int rangeSum(int L, int R, int[] arr) {
    int sum = 0;
    for (int i = L; i <= R; i++) {
      sum += arr[i];
    }
    return sum;
  }

  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    int prefixNum = 9;
    int result = prefixsum(prefixNum, arr);
    System.out.println("Prefix sum result = " + result);

    System.out.println("================ 这是一条分割线 =========================");
    int l = 1;
    int r = 3;

    int result2 = sumFromRtoL(l, r, arr);
    int result3 = rangeSum(l, r, arr);
    System.out.println("Sum from r to l result2 = " + result2);
    System.out.println("Sum from r to l result3 = " + result3);
    System.out.println("result is : " + (result2 == result3));
  }
}
