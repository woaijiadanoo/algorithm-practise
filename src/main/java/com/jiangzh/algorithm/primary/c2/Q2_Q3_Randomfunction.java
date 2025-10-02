package com.jiangzh.algorithm.primary.c2;

import java.util.HashMap;

public class Q2_Q3_Randomfunction {

    /**
     * 从3-10等概率随机
     * @return
     */
    public static int randomFrom3To10() {
        int result;
        // 首先获取 0 - 7 的随机数
        result = (randomZeroAndOne() << 2) + (randomZeroAndOne() << 1) + randomZeroAndOne();

        // 输出 3-10
        return result + 3;
    }

    /**
     * 从1-7等概率随机
     * @return
     */
    public static int randomFromOneToSeven() {
        int result;
        // 首先获取 0 - 6 的随机数
        do {
            result = (randomZeroAndOne() << 2) + (randomZeroAndOne() << 1) + randomZeroAndOne();
        } while (result == 7);

        // 输出 1-7
        return result + 1;
    }


    /**
     * 0 和 1 等概率随机
     * @return
     */
    public static int randomZeroAndOne() {
        int randomValue;
        do {
            randomValue = f();
        } while (randomValue == 3);

        return randomValue < 3 ? 0 : 1;
    }

    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<10000; i++) {
            int value = randomFrom3To10();
            map.put(value, map.getOrDefault(value, 0) + 1);
        }

        for (int i=0; i<=10; i++) {
            System.out.println(i + " 出现次数： " + map.getOrDefault(i, 0));
        }

    }

    public static int f() {
        return (int) (Math.random() * 5) + 1;
    }

}
