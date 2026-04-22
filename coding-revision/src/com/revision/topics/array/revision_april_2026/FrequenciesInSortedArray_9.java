package com.revision.topics.array.revision_april_2026;

import java.util.HashMap;

public class FrequenciesInSortedArray_9 {

    private static int findFrequency(int[] arr, int x) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        return map.getOrDefault(x, 0);
    }

    public static void main(String[] args) {
        System.out.println(findFrequency(new int[]{10, 10, 10, 25, 30, 30}, 30));
        System.out.println(findFrequency(new int[]{10, 10, 10, 25, 30, 30}, 40));
    }
}
