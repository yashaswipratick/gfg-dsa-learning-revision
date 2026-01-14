package com.revision.topics.binary_serach.easy;

// PL - https://leetcode.com/problems/find-smallest-letter-greater-than-target/
public class Leetcode_744 {

    // TODO - Revisit
    public static char nextGreatestLetter(char[] letters, char target) {
        int expected = (int) target + 1;
        target = (char)expected;
        int index = findExpectedPosition(letters, target);
        return index == -1 ? letters[0] : letters[index];
    }

    private static int findExpectedPosition(char[] letters, char target) {
        int start = 0;
        int end = letters.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (letters[mid] == target) {
                return mid;
            }
            if (letters[mid] > target) {
                if (mid > 0 && letters[mid-1] < target) {
                    return mid;
                } else {
                    end = mid - 1;
                }
            } else {
                if (mid < letters.length - 1 && letters[mid+1] > target) {
                    return mid+1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'j'));
        System.out.println(nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'a'));
        System.out.println(nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'c'));
        System.out.println(nextGreatestLetter(new char[]{'x', 'x', 'y', 'y'}, 'z'));
        System.out.println(nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'i'));
        System.out.println(nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'd'));
        System.out.println(nextGreatestLetter(new char[]{'e','e','e','e','e','e','n','n','n','n'}, 'e'));
    }
}
