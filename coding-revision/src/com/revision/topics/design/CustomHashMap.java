package com.revision.topics.design;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class CustomHashMap {

    List<LinkedList<Pair>> list;
    int SIZE = 1000;
    public CustomHashMap() {
        list = new ArrayList<>();
        for (int i = 0; i <SIZE; i++) {
            list.add(new LinkedList<>());
        }
    }

    private int hash(int key) {
        return key % SIZE;
    }

    public void put(int key, int value) {
        int hash = hash(key);
        LinkedList<Pair> curr = list.get(hash);

        // If key already exist
        for (Pair pair : curr) {
            if (pair.key == key) {
                pair.value = value;  // update existing key
                return;
            }
        }
        // If key does not exist
        curr.add(new Pair(key, value));  // key not found, insert
    }

    public int get(int key) {
        int hash = hash(key);
        LinkedList<Pair> curList = list.get(hash);

        // Iterate over the list, if key found then return the value.
        for (Pair pair : curList) {
            if (pair.key == key) return pair.value;
        }

        // else return -1
        return -1;
    }

    public void remove(int key) {
        int hash = hash(key);
        LinkedList<Pair> curList = list.get(hash);

        //  Always check key before removing — works for any bucket size
        for (Pair pair : curList) {
            if (pair.key == key) {
                curList.remove(pair);
                return;
            }
        }
    }

    public static void main(String[] args) {
        CustomHashMap myHashMap = new CustomHashMap();
        myHashMap.put(1, 1); // The map is now [[1,1]]
        myHashMap.put(2, 2); // The map is now [[1,1], [2,2]]
        System.out.println(myHashMap.get(1));    // return 1, The map is now [[1,1], [2,2]]
        System.out.println(myHashMap.get(3));    // return -1 (i.e., not found), The map is now [[1,1], [2,2]]
        myHashMap.put(2, 1); // The map is now [[1,1], [2,1]] (i.e., update the existing value)
        System.out.println(myHashMap.get(2));    // return 1, The map is now [[1,1], [2,1]]
        myHashMap.remove(2); // remove the mapping for 2, The map is now [[1,1]]
        System.out.println(myHashMap.get(2));    // return -1 (i.e., not found), The map is now [[1,1]]
    }

    static class Pair {
        int key;
        int value;

        public Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return key == pair.key;
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(key);
        }
    }
}
