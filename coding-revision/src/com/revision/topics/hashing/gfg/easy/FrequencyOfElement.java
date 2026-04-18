package com.revision.topics.hashing.gfg.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// PL - https://www.geeksforgeeks.org/problems/frequency-of-elements--111353/1
public class FrequencyOfElement {

    public static ArrayList<ArrayList<Integer>> countFreq(int[] arr) {
        // code here
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();

        for(int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            ArrayList<Integer> cur = new ArrayList<>();
            cur.add(entry.getKey());
            cur.add(entry.getValue());
            list.add(cur);
        }

        return list;
    }
    public static void main(String[] args) {
        System.out.println(countFreq(new int[]{1, 2, 2, 3, 3, 5}));
        System.out.println(countFreq(new int[]{1, 5, 6, 7, 7}));
    }
}
