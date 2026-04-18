package com.revision.topics.hashing.gfg.medium.nbykOccurence.mooreVotingAlgorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

// PL - https://www.geeksforgeeks.org/problems/count-element-occurences/1
// VL - https://www.geeksforgeeks.org/batch/dsa-4/track/DSASP-Hashing/video/MTgyNA%3D%3D
public class MoreThanNByKOccurrencesMVAlgo {

    //TODO - Revisit
    //Moore's Voting Algorithm
    public static int countOccurrence(int[] arr, int k) {
        // Phase - 1 - find out candidate element
        Map<Integer, Integer> map = new ConcurrentHashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            } else if (map.size() < k - 1 && !map.containsKey(arr[i])) {
                map.put(arr[i], 1);
            } else {
                for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                    if (entry.getValue() == 1) {
                        map.remove(entry.getKey());
                    } else {
                        map.put(entry.getKey(), entry.getValue() - 1);
                    }
                }
            }
        }

        // Phase - 2 - find the potential candidates which satisfies the requirement and return the count of such element
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
