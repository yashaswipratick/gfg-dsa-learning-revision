package com.revision.topics.design;

import java.util.HashMap;
import java.util.LinkedList;

//PL - https://leetcode.com/problems/lru-cache/description/
public class LRUCache {

    int capacity;
    LinkedList<Integer> list;
    HashMap<Integer, Integer> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.list = new LinkedList<>();
        this.map = new HashMap<>(capacity);
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        makeRecentlyUsed(key);
        return map.get(key);
    }

    private void makeRecentlyUsed(int key) {
        list.remove((Integer) key);
        list.addFirst(key);
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.put(key, value);
            makeRecentlyUsed(key);
            return;
        }

        if (map.size() >= capacity) {
            int lastKey = list.removeLast();
            map.remove(lastKey);
        }

        list.addFirst(key);
        map.put(key, value);
    }

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        System.out.println(lRUCache.get(2));    // return 1
        lRUCache.put(2, 6); // cache is {1=1}
        System.out.println(lRUCache.get(1));    // return 1
        lRUCache.put(1, 5); // cache is {1=1, 2=2}
        lRUCache.put(1, 2); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        System.out.println(lRUCache.get(1));    // returns -1 (not found)
        System.out.println(lRUCache.get(2));    // returns -1 (not found)
    }
}