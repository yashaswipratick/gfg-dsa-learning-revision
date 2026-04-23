package com.revision.topics.binary_serach.revision_april_2026;

public class Leetcode_744 {

    private static char nextGreatestLetter(char[] letters, char target) {
        int start = 0;
        int end = letters.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (letters[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        if (start == letters.length) {
            return letters[0];
        }
        return letters[start];
    }

    public static void main(String[] args) {
        System.out.println(nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'j')); //c
        System.out.println(nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'a')); //c
        System.out.println(nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'c')); //f
        System.out.println(nextGreatestLetter(new char[]{'x', 'x', 'y', 'y'}, 'z')); //x
        System.out.println(nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'i')); // j
        System.out.println(nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'd')); // f
        System.out.println(nextGreatestLetter(new char[]{'e','e','e','e','e','e','n','n','n','n'}, 'e')); //n
    }
}
