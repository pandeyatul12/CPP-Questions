package com.kunal.topKElements;

import java.util.PriorityQueue;

public class ConnectRopes {
    public static void main(String[] args) {
        int[] nums = {1, 3, 11, 5, 2};
        System.out.println(ans(nums));
    }

    public static int ans(int[] nums) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int num : nums) {
            heap.add(num);
        }
        int cost = 0;
        while (heap.size() > 1) {
            int removed = heap.remove() + heap.remove();
            cost += removed;
            heap.add(removed);
        }
        return cost;
    }

}
