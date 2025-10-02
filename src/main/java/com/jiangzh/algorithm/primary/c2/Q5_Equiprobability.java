package com.jiangzh.algorithm.primary.c2;

import java.util.HashMap;

public class Q5_Equiprobability {


    public static int equiprobability() {
        int result;
        do {
            result = randomProbability();
        } while (result == randomProbability());

        return result;
    }

    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<10000; i++) {
            int value = equiprobability();
            map.put(value, map.getOrDefault(value, 0) + 1);
        }

        for (int i=0; i<=10; i++) {
            System.out.println(i + " 出现次数： " + map.getOrDefault(i, 0));
        }
    }


    public static int randomProbability(){
        double probbility = 0.84;

        if (Math.random() < probbility) {
            return 0;
        } else {
            return 1;
        }
    }

}
