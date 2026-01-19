package com.revision.topics.binary_serach.medium.design_based_problem;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

// PL - https://leetcode.com/problems/time-based-key-value-store/description/
// VL - https://www.youtube.com/watch?v=lqSJPJUR9bQ
public class Leetcode_981 {

    Map<String, TreeMap<Integer, String>> map;
    public Leetcode_981() {
        map = new HashMap<>();
    }

    //TODO - Revisit
    public void set(String key, String value, int timestamp) {
        //we are using computeIfAbsent, so the description
        //If map contains a treeMap object value then get that treemap object value and override the key inside treemap(put method) and if value not present then first put new treemap into value and then put new data into treemap.
        map.computeIfAbsent(key, x -> new TreeMap<>()).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        //floorKey -> If the key is present and the associated value is a TreeMap, this method is called on that TreeMap. The floorKey method in TreeMap returns the greatest key less than or equal to the given key (timestamp). It essentially finds the largest key in the map that is less than or equal to the specified timestamp.
        Integer i = map.containsKey(key) ? map.get(key).floorKey(timestamp) : null;
        return i != null ? map.get(key).get(i) : "";
    }

    public static void main(String[] args) {
        Leetcode_981 lc = new Leetcode_981();
        lc.set("foo", "bar", 1);
        System.out.println(lc.get("foo", 1));         // return "bar"
        System.out.println(lc.get("foo", 3));
        lc.set("foo", "bar2", 4); // store the key "foo" and value "bar2" along with timestamp = 4.
        System.out.println(lc.get("foo", 4));         // return "bar2"
        System.out.println(lc.get("foo", 5));         // return "bar2"
    }
}
