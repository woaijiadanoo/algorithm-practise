package com.jiangzh.algorithm.primary.c3;

import com.jiangzh.algorithm.utils.ArrayUtils;

public class Q4_MinimumValue {


    public static int findMinimumValue(int[] arr) {
        int index = -1;
        if (arr == null || arr.length < 2) {
            return index;
        }

        int length = arr.length;
        // 判断两个边界值
        if (arr[0] < arr[1]) {
            return 0;
        } else if (arr[length - 1] < arr[length - 2]) {
            return length - 1;
        }

        // 如果两个边界值不是最小，那么要在中间位置寻找最小
        int left = 0;
        int right = length - 1;
        while (left <= right) {
            int middle = left + ((right - left) >> 1);
            if (arr[middle] < arr[middle + 1] && arr[middle] < arr[middle - 1]) {
                return middle;
            } else if (arr[middle] > arr[middle + 1]) {
                left = middle + 1;
            } else if (arr[middle] > arr[middle - 1]) {
                right = middle -1;
            }
        }

        return index;
    }

    public static void main(String[] args) {
        int[] arr = ArrayUtils.generateRandomArray(10, 100);
        ArrayUtils.printArray(arr);

        int minimumIndex = findMinimumValue(arr);
        System.out.println("minimumIndex = " + minimumIndex);
    }

}
