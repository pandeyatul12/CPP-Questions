package com.kunal.topKElements;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SumOfElements {
    public static void main(String[] args) {

    }
    public static int sumOfElements(int[] arr, int k1, int k2) {
        // maintain top k2 smallest elements
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(o -> -o));
        for (int i = 0; i < k2; i++) {
            heap.add(arr[i]);
        }
        for (int i = k2; i < arr.length; i++) {
            int num = arr[i];
            if (num < heap.peek()) {
                heap.remove();
                heap.add(num);
            }
        }
        int ans = 0;
        heap.remove();
        for (int i = 0; i < k2 - k1 - 1; i++) {
            ans += heap.remove();
        }
        return ans;
    }
}
