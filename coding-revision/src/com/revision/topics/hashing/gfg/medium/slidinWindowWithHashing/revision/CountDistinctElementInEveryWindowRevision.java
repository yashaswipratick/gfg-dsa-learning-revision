package com.revision.topics.hashing.gfg.medium.slidinWindowWithHashing.revision;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CountDistinctElementInEveryWindowRevision {

    public static ArrayList<Integer> countDistinct(int arr[], int k) {
        ArrayList<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        int i = 0;
        int j = 0;

        while (j < arr.length) {
            map.put(arr[j], map.getOrDefault(arr[j], 0) + 1);

            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {
                list.add(map.size());
                if (map.containsKey(arr[i])) {
                    map.put(arr[i], map.get(arr[i]) - 1);
                    if (map.get(arr[i]) == 0) {
                        map.remove(arr[i]);
                    }
                }
                j++;
                i++;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(countDistinct(new int[]{1, 2, 1, 3, 4, 2, 3}, 4));
        System.out.println(countDistinct(new int[]{4, 1, 1}, 2));
        System.out.println(countDistinct(new int[]{1, 1, 1, 1, 1}, 3));
    }
}
