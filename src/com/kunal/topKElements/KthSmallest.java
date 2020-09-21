package com.kunal.topKElements;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallest {
    public static void main(String[] args) {
        int[] arr = {1, 5, 12, 2, 11, 5};
        int k = 3;
        System.out.println(kthSmallestNumber(arr, k));
    }
    private static int kthSmallestNumber(int[] arr, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(o -> -o));
        for (int i = 0; i < k; i++) {
            heap.add(arr[i]);
        }
        // need to maintain top k smallest numbers in the heap
        for (int i = k; i < arr.length; i++) {
            int num = arr[i];
            if (num < heap.peek()) {
                heap.remove();
                heap.add(num);
            }
        }
        // now we have top k smallest numbers in the heap
        System.out.println(heap);
        return heap.peek();
    }

}
