package com.revision.topics.hashing.gfg.medium.practice;

import java.util.Map;
import java.util.TreeMap;

// PL - https://www.geeksforgeeks.org/batch/dsa-4/track/DSASP-Hashing/problem/relative-sorting4323
public class SortAccordingToArray {

    // TODO - Run it in gfg
    static void relativeSort(int[] a1, int[] a2) {
        Map<Integer, Integer> map = new TreeMap<>();

        for(int i : a1) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        int j = 0;
        for(int i = 0; i<a2.length; i++) {
            if(map.containsKey(a2[i])) {
                int count = map.get(a2[i]);
                while (count-- > 0) {
                    a1[j++] = a2[i];
                }
            }
            map.remove(a2[i]);
        }

        for(Integer key : map.keySet()) {
            int count = map.get(key);
            while (count-- > 0) {
                a1[j++] = key;
            }
        }

        print(a1);
    }

    static void print(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        relativeSort(new int[]{2, 1, 2, 3, 4}, new int[]{2, 1, 2});
        relativeSort(new int[]{4, 1, 3, 3, 2}, new int[]{3, 1});
        relativeSort(new int[]{34, 52, 14, 68, 37, 22, 43, 4, 68}, new int[]{68});
    }
}
