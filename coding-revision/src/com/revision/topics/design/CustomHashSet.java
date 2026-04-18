package com.revision.topics.design;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// PL - https://leetcode.com/problems/design-hashset/submissions/1981724657/
public class CustomHashSet {

    List<LinkedList<Integer>> list;
    int size = 1000;
    public CustomHashSet() {
        list = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            list.add(new LinkedList<>());
        }
    }

    private int hash(int key) {
        return key % size;
    }

    public void add(int key) {
        // find the index using hash function
        int hash = hash(key);

        // get the list from the hashed index
        LinkedList<Integer> curr = list.get(hash);

        // iterate over the list, and add in the last if does not exists, otherwise ignore
        if (!curr.contains(key)) {
            list.get(hash).addLast(key);
        }
    }

    public void remove(int key) {
        // find the index using hash function
        int hash = hash(key);

        // get the list from the hashed index
        LinkedList<Integer> curr = list.get(hash);

        // check if the key exists just remove
        if (curr.contains(key)) {
            curr.remove((Integer) key);
        }
    }

    public boolean contains(int key) {
        // find the index using hash function
        int hash = hash(key);

        // get the list from the hashed index
        LinkedList<Integer> curr = list.get(hash);

        // return the boolean if it exists into the list.
        return curr.contains(key);
    }

    public static void main(String[] args) {
        CustomHashSet myHashSet = new CustomHashSet();
        myHashSet.add(1);      // set = [1]
        myHashSet.add(2);      // set = [1, 2]
        System.out.println(myHashSet.contains(1)); // return True
        System.out.println(myHashSet.contains(3)); // return False, (not found)
        myHashSet.add(2);      // set = [1, 2]
        System.out.println(myHashSet.contains(2)); // return True
        myHashSet.remove(2);   // set = [1]
        System.out.println(myHashSet.contains(2)); // return False, (already removed)
    }
}
