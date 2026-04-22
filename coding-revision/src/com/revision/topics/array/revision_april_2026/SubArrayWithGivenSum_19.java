package com.revision.topics.array.revision_april_2026;

import java.util.ArrayList;

public class SubArrayWithGivenSum_19 {

    private static boolean isSubarraySum(int[] arr, int target) {
        int i = 0;
        int j = 0;

        int sum = 0;

        while (j <= arr.length) {
            sum += arr[j];

            while (sum > target) {
                sum -= arr[i];
                i++;
            }

            if (sum == target) {
                return true;
            }
            j++;
        }

        return false;
    }

    private static ArrayList<Integer> subarraySum(int[] arr, int target) {
        int i = 0;
        int j = 0;

        int sum = 0;

        ArrayList<Integer> list = new ArrayList<>();

        while (j < arr.length) {
            sum += arr[j];

            while (sum > target) {
                sum -= arr[i];
                i++;
            }

            if (sum == target) {
                list.add(i+1);
                list.add(j+1);
                return list;
            }
            j++;
        }

        if (list.isEmpty()) {
            list.add(-1);
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(isSubarraySum(new int[]{4, 8, 12, 5}, 17));
        System.out.println(isSubarraySum(new int[]{1, 4, 20, 3, 10, 5}, 33));

        System.out.println(subarraySum(new int[]{4, 8, 12, 5}, 17));
        System.out.println(subarraySum(new int[]{1, 4, 20, 3, 10, 5}, 33));
        System.out.println(subarraySum(new int[]{26, 3, 28, 7}, 52));
    }
}
