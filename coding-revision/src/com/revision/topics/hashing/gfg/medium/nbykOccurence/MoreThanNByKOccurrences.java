package com.revision.topics.hashing.gfg.medium.nbykOccurence;

import java.util.HashMap;
import java.util.Map;

// PL - https://www.geeksforgeeks.org/problems/count-element-occurences/1
// VL - https://www.geeksforgeeks.org/batch/dsa-4/track/DSASP-Hashing/video/MTgyOQ%3D%3D
public class MoreThanNByKOccurrences {

    //TODO - Revisit
    public static int countOccurrence(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        int count = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > (arr.length / k)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countOccurrence(new int[]{3, 1, 2, 2, 1, 2, 3, 3}, 4));
        System.out.println(countOccurrence(new int[]{2, 3, 3, 2}, 3));
        System.out.println(countOccurrence(new int[]{1, 4, 7, 7}, 2));
        System.out.println(countOccurrence(new int[]{0, 5, 6, 6, 0, 4, 3, 1, 5, 3, 2, 6, 1, 2}, 11));
    }
}
