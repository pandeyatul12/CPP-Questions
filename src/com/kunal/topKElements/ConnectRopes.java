package com.kunal.topKElements;

import java.util.PriorityQueue;
/*
    Time: O(NLogN)
    Space: O(N)
*/
public class ConnectRopes {
    public static void main(String[] args) {
        int[] nums = {1, 3, 11, 5, 2};
        System.out.println(ans(nums));
    }

    public static int ans(int[] nums) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int num : nums) {
            minHeap.add(num);
        }
        int cost = 0;
        while (minHeap.size() > 1) {
            int removed = minHeap.remove() + minHeap.remove();
            cost += removed;
            minHeap.add(removed);
        }
        return cost;
    }

}
