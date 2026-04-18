package com.revision.topics.hashing.gfg.medium.practice;

import java.util.*;

public class SortElementsByDecreasingOrder {

    public static ArrayList<Integer> sortByFreq(int arr[]) {
        Map<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> list =new ArrayList<>();

        // store the frequency
        for(int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        // Add element to the list to run custom comparator on sort method
        for(int i : arr) {
            list.add(i);
        }

        // custom comparator logic to sort based on higher frequency first
        // then the smaller number comes first.
        list.sort((a,b) -> {
            int freqA = map.get(a);
            int freqB = map.get(b);

            if(freqA != freqB) {
                return freqB-freqA; //higher freq first
            }
            return a-b;// smallest number first if freq is same
        });
        return list;
    }

    public static void main(String[] args) {
        System.out.println(sortByFreq(new int[]{5, 5, 4, 6, 4}));
        System.out.println(sortByFreq(new int[]{9, 9, 9, 2, 5}));
    }
}
