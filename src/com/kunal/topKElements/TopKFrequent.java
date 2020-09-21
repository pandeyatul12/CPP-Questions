package com.kunal.topKElements;

import java.util.*;

public class TopKFrequent {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 12, 11, 12, 11};
        int k = 2;
        System.out.println(ans2(arr, k));
    }

    public static List<Integer> ans2(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>(Comparator.comparingInt(o -> o.getValue()));
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            heap.add(entry);
            if (heap.size() > k) {
                heap.remove();
            }
        }

        List<Integer> ans = new ArrayList<>();
        while (!heap.isEmpty()) {
            ans.add(heap.remove().getKey());
        }
        return ans;
    }

    public static List<Integer> ans(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Unit> units = new ArrayList<>();
        for(int key : map.keySet()) {
            units.add(new Unit(key, map.get(key)));
        }
        PriorityQueue<Unit> heap = new PriorityQueue<>(Comparator.comparingInt(o -> o.freq));
        for (int i = 0; i < k; i++) {
            heap.add(units.get(i));
        }
        for (int i = k; i < units.size(); i++) {
            if (units.get(i).freq > heap.peek().freq) {
                heap.remove();
                heap.add(units.get(i));
            }
        }
        List<Integer> ans = new ArrayList<>();
        while (!heap.isEmpty()) {
            ans.add(heap.remove().num);
        }
        return ans;
    }

    static class Unit {
        int num;
        int freq;

        public Unit(int num, int freq) {
            this.num = num;
            this.freq = freq;
        }
    }
}

