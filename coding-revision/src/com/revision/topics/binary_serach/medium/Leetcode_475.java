package com.revision.topics.binary_serach.medium;

import java.util.Arrays;

// PL - https://leetcode.com/problems/heaters/description
// reference - https://leetcode.com/problems/heaters/solutions/7234780/89-beats-easy-simple-java-solution-by-pr-yeft
public class Leetcode_475 {

    //TODO - Revisit
    public static int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int low = 0;
        int high = Math.max(houses[houses.length - 1], heaters[heaters.length - 1]);
        int ans = high;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossible(houses, heaters, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static boolean isPossible(int house[], int heater[], int rad) {
        int i = 0;//house
        int j = 0;//heater
        while (i < house.length && j < heater.length) {
            if (house[i] >= heater[j] - rad && house[i] <= heater[j] + rad) {
                i++;
            } else if (house[i] < heater[j] - rad) { // means radius is short
                return false;
            } else if (house[i] > heater[j] + rad) {
                j++;
            }
        }

        if (i == house.length) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(findRadius(new int[]{1, 2, 3, 4}, new int[]{1, 4}));
        System.out.println(findRadius(new int[]{1, 5}, new int[]{2}));
        System.out.println(findRadius(new int[]{1, 2, 3}, new int[]{2}));
    }
}
