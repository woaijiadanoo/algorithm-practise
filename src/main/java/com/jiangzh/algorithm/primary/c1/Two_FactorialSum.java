package com.jiangzh.algorithm.primary.c1;

/**
 * Calculate the sum of factorials from 1 to N
 *
 * @author: Jiang Zheng
 * @date: 2025-09-23
 * @version: 1.0
 */
public class Two_FactorialSum {

  /**
   * Calculate the sum of factorials from 1 to num
   *
   * @param num
   */
  private static void factorialSum(int num) {
    if (num < 2) {
      System.out.println("finbonacci result = " + num);
    }
    long sum = 1L;
    long tempVal = 1l;

    for (int i = 2; i <= num; i++) {
      tempVal = tempVal * i;
      sum += tempVal;
    }

    System.out.println("finbonacci result = " + sum);
  }

  public static void main(String[] args) {
    // Print the fibonacci sequence result
    factorialSum(9);
  }
}
