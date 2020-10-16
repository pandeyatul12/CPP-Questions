package com.kunal.topKElements;

import java.util.*;
// Given a string, find if its letters can be rearranged in such a way that no two same characters come next to each other.
/*
    Time: O(NLogN)
    Space: O(N)
*/
public class RearrangeString {
    public static void main(String[] args) {
        String str = "Programming";
        System.out.println(ans(str));
    }

    public static String ans(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : str.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(Comparator.comparingInt(o -> -o.getValue()));
        maxHeap.addAll(map.entrySet());
        Map.Entry<Character, Integer> previous = null;
        StringBuilder builder = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> current = maxHeap.remove();
            if (previous != null && previous.getValue() > 0) {
                maxHeap.add(previous);
            }
            builder.append(current.getKey());
            current.setValue(current.getValue() - 1);
            previous = current;
        }
        return builder.length() == str.length() ? builder.toString() : "";
    }

    // if characters need to be K distance apart
    public static String ansKDist(String str, int k) {
        if (k <= 1) {
            return str;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : str.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(Comparator.comparingInt(o -> -o.getValue()));
        maxHeap.addAll(map.entrySet());
        Queue<Map.Entry<Character, Integer>> queue = new LinkedList<>();
        StringBuilder builder = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> current = maxHeap.remove();
            builder.append(current.getKey());
            current.setValue(current.getValue() - 1);
            queue.add(current);
            if (queue.size() == k) {
                Map.Entry<Character, Integer> removed = queue.remove();
                if (removed.getValue() > 0) {
                    maxHeap.add(removed);
                }
            }
        }
        return builder.length() == str.length() ? builder.toString() : "";
    }
}
