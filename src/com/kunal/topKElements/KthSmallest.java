package com.kunal.topKElements;

import java.util.Comparator;
import java.util.PriorityQueue;
/*
    Time: O(NLogK)
    Space: O(K)
*/
public class KthSmallest {
    public static void main(String[] args) {
        int[] arr = {1, 5, 12, 2, 11, 5};
        int k = 3;
        System.out.println(kthSmallestNumber(arr, k));
    }
    private static int kthSmallestNumber(int[] arr, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.comparingInt(o -> -o));
        for (int i = 0; i < k; i++) {
            maxHeap.add(arr[i]);
        }
        // need to maintain top k smallest numbers in the maxHeap
        for (int i = k; i < arr.length; i++) {
            int num = arr[i];
            if (num < maxHeap.peek()) {
                maxHeap.remove();
                maxHeap.add(num);
            }
        }
        // now we have top k smallest numbers in the maxHeap
        System.out.println(maxHeap);
        return maxHeap.peek();
    }

}
