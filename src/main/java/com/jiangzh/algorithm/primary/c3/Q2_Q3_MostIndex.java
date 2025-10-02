package com.jiangzh.algorithm.primary.c3;

public class Q2_Q3_MostIndex {

    public static int binarySearch(int[] arr, int target, int left, int right) {
        int index = -1;
        if (arr == null || arr.length == 0) {
            return index;
        }

        if (arr.length == 1) {
            if (arr[0] == target) {
                index = 0;
            }
            return index;
        }

        while (left <= right) {
            int middle = left + ((right - left) >> 1);
            if (arr[middle] == target) {
                return middle;
            } else if (arr[middle] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        return index;
    }

    public static int leftmostValue(int[] arr, int target) {
        int leftmostIndex = -1;
        int left = 0;
        int right = arr.length - 1;

        while(true) {
            int index = binarySearch(arr, target, left, right);
            if (index == -1) {
                break;
            } else {
                right =  index - 1;
                leftmostIndex = index;
            }
        }


        return leftmostIndex;
    }

    public static int rightmostValue(int[] arr, int target) {
        int rightmostIndex = -1;
        int left = 0;
        int right = arr.length - 1;

        while(true) {
            int index = binarySearch(arr, target, left, right);
            if (index == -1) {
                break;
            } else {
                left =  index + 1;
                rightmostIndex = index;
            }
        }


        return rightmostIndex;
    }


    public static void main(String[] args) {
        int[] arr = {1,2,3,3,4,4,4,6,7,8,8,8,9,10};
        int target = 4;

        int index = binarySearch(arr, target, 0, arr.length - 1);
        System.out.println("index = " + index);

        System.out.println("================ 这是一条分割线 =========================");

        index = leftmostValue(arr, target);
        System.out.println("有序数组中找到 >=num 最左的位置 = " + index);

        System.out.println("================ 这是一条分割线 =========================");

        index = rightmostValue(arr, target);
        System.out.println("有序数组中找到 >=num 最左的位置 = " + index);
    }

}
