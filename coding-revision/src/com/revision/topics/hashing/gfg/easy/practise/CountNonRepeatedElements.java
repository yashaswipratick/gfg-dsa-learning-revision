package com.revision.topics.hashing.gfg.easy.practise;

import java.util.HashMap;
import java.util.Map;

public class CountNonRepeatedElements {

    public static int countNonRepeated(int arr[]) {
        //  code here
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i: arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        int count = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() == 1) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countNonRepeated(new int[]{1, 1, 2, 2, 3, 3, 4, 5, 6, 7}));
        System.out.println(countNonRepeated(new int[]{10, 20, 30, 40, 10}));
    }
}
