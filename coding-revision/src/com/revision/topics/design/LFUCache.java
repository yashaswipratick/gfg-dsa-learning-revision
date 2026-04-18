package com.revision.topics.design;

import com.revision.topics.heap.Pair;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LFUCache {

    int capacity;
    Map<Integer, LinkedList<Pair>> freq;
    Map<Integer, Integer> lfu;
    LinkedList<Pair> list;
    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.freq = new HashMap<>();
        this.lfu = new HashMap<>();
        this.list = new LinkedList<>();
    }

    public int get(int key) {
        return 0;
    }

    public void put(int key, int value) {
        if (lfu.containsKey(key)) {

        }

        if (lfu.size() >= capacity) {

        }
    }

    /*private void makeRecentlyUsed(int key) {
        list.remove((Integer) key);
        list.addFirst(key);
    }*/

    public static void main(String[] args) {

    }

    static class Pair {

        int key;
        int fre;

        public Pair(int key, int fre) {
            this.key = key;
            this.fre = fre;
        }
    }
}
