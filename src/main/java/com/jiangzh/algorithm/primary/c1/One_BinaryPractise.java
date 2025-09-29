package com.jiangzh.algorithm.primary.c1;

/**
 * Binary Content Review
 *
 * @author zheng.jiang
 */
public class One_BinaryPractise {

  /**
   * Print the binary representation of a number
   *
   * @param num
   */
  private static void printBinary(int num) {
    for (int i = 31; i >= 0; i--) {
      System.out.print((num & (1 << i)) == 0 ? "0" : "1");
    }
    System.out.println();
  }

  public static void main(String[] args) {
     int binaryNum = 5;
    // Print Binary representation of a number
     printBinary(binaryNum);

    System.out.println("================ 这是一条分割线 =========================");

  }
}
