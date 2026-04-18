package com.revision.topics.hashing.gfg.easy.practise;

import java.util.HashMap;
import java.util.Map;

public class WinnersElection {

    public static String[] winner(String arr[], int n) {
        Map<String, Integer> map = new HashMap<>();
        for(String i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        int max = 0;
        String[] res = new String[2];
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            if(entry.getValue() > max) {
                res[0] = entry.getKey();
                res[1] = String.valueOf(entry.getValue());
                max = entry.getValue();
            } else if(entry.getValue() == max && entry.getKey().compareTo(res[0]) < 0) {
                res[0] = entry.getKey();
                res[1] = String.valueOf(entry.getValue());
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(winner(new String[]{"john", "johnny", "jackie",
                "johnny", "john", "jackie", "jamie", "jamie", "john", "johnny", "jamie", "johnny", "john"}, 13));
        System.out.println(winner(new String[]{"andy","blake","clark"}, 3));

    }
}
