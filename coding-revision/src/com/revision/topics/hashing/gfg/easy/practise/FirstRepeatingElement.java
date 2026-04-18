package com.revision.topics.hashing.gfg.easy.practise;

import java.util.HashMap;
import java.util.Map;


// PL - https://www.geeksforgeeks.org/batch/dsa-4/track/DSASP-Hashing/problem/first-repeating-element4018
public class FirstRepeatingElement {

    // TODO - Run it in gfg
    public static int firstRepeated(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0)  + 1);
        }

        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i]) && map.get(arr[i]) > 1) {
                return i+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstRepeated(new int[]{1, 5, 3, 4, 3, 5, 6}));
        System.out.println(firstRepeated(new int[]{1, 2, 3, 4}));
    }
}
