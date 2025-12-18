package com.revision.topics.heap;

import java.util.TreeMap;

//PL - 
//VL - https://takeuforward.org/data-structure/hands-of-straights
public class HandOfStraights {

    /**
     * Algorithm
     * To determine whether a hand of cards can be rearranged into groups of size `groupSize`,
     * we can sort the cards and always try to build a group starting from the smallest available card.
     * We greedily check if the next `groupSize - 1` consecutive cards exist and reduce their count.
     * A `TreeMap` (in C++ or Java) or a sorted map can help maintain keys in sorted order while efficiently
     * accessing and updating the card counts.
     * <p>
     * Check if total number of cards is divisible by groupSize; if not, return false.
     * Store the frequency of each card in a sorted data structure.
     * Iterate over the sorted keys (card values) from smallest to largest.
     * For each key, try to form a group of groupSize starting from that key.
     * If there are not enough cards to build a group, return false.
     * Decrement the counts for each card used in the group.
     * If all groups are successfully formed, return true.
     */
    public static boolean isNStraightHand(int[] hand, int groupSize) {
        // If total cards can't be divided evenly, return false
        if (hand.length % groupSize != 0) return false;

        // Store the frequency of each card
        TreeMap<Integer, Integer> freq = new TreeMap<>();
        for (int card : hand) {
            freq.put(card, freq.getOrDefault(card, 0) + 1);
        }

        // Loop through all keys in the map
        while (!freq.isEmpty()) {

            // Start of the current group
            int start = freq.firstKey();

            // Number of groups to form starting from this card
            int count = freq.get(start);

            // Try to build a group of size groupSize
            for (int i = 0; i < groupSize; i++) {
                int card = start + i;

                // If the card is not present or has fewer frequency
                if (!freq.containsKey(card) || freq.get(card) < count) return false;

                // Decrease the frequency
                if (freq.get(card) == count) freq.remove(card);
                else freq.put(card, freq.get(card) - count);
            }
        }

        // All groups formed successfully
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isNStraightHand(new int[]{1, 2, 3, 6, 2, 3, 4, 7, 8}, 3));
        System.out.println(isNStraightHand(new int[]{1, 2, 3, 4, 5}, 4));
        System.out.println(isNStraightHand(new int[]{8,10,12}, 3));
    }
}
