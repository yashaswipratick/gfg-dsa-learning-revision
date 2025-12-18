package com.revision.topics.sliding.window.problems.revision.variable_size_window;

import java.util.HashMap;
import java.util.Map;

// PL - https://leetcode.com/problems/fruit-into-baskets/submissions/1829064259/
// VL - https://www.youtube.com/watch?v=seOKHXB_w74&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=12
public class FruitsIntoBasket {
    //variation - Pick Toys, Fruits into basket, Find longest substring with K unique characters

    //1,2,3,2,2
    //TODO - Revise again
    public static int totalFruit(int[] fruits) {
        int i = 0;
        int j = 0;
        int k = 2;
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();

        while (j < fruits.length) {
            map.put(fruits[j], map.getOrDefault(fruits[j], 0 ) + 1);

            if (map.size() < k) {
                j++;
            } else if (map.size() == k) {
                int sum = map.values().stream().mapToInt(value -> value).sum();
                max = Math.max(sum, max);
                j++;
            } else {
                if (map.containsKey(fruits[i])) {
                    map.put(fruits[i], map.get(fruits[i]) - 1);
                }
                if (map.get(fruits[i]).equals(0)) {
                    map.remove(fruits[i]);
                }
                i++;
                j++;
            }
        }
        if (map.size() == 1 && max == 0) {
            max = Math.max(max, map.values().stream().mapToInt(value -> value).sum());
        }
        return max;
    }

    public static void main(String[] args) {
        /*System.out.println(totalFruit(new int[]{1, 2, 1}));
        System.out.println(totalFruit(new int[]{0, 1, 2, 2}));
        System.out.println(totalFruit(new int[]{1,2,3,2,2}));*/
        System.out.println(totalFruit(new int[]{1,1,1,1}));
    }
}
