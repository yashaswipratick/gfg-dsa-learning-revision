package com.revision.topics.hashing.gfg.easy.practise;

import java.util.HashMap;
import java.util.Map;

// Pl - https://www.geeksforgeeks.org/batch/dsa-4/track/DSASP-Hashing/problem/check-if-two-arrays-are-equal-or-not3847
public class CheckEqualArray {

    public static boolean checkEqual(int[] a, int[] b) {
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();

        for(int i : a) {
            map1.put(i, map1.getOrDefault(i, 0) + 1);
        }

        for(int i : b) {
            map2.put(i, map2.getOrDefault(i, 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry : map1.entrySet()) {
            if(!map2.containsKey(entry.getKey())) {
                return false;
            }

            if(map2.containsKey(entry.getKey()) && !map2.get(entry.getKey()).equals(entry.getValue())) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(checkEqual(new int[]{1, 2, 5, 4, 0}, new int[]{2, 4, 5, 0, 1}));
        System.out.println(checkEqual(new int[]{1, 2, 5}, new int[]{2, 4, 15}));
    }
}
