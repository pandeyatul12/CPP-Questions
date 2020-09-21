package com.kunal.topKElements;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KLargestNumbers {
    public static void main(String[] args) {
        int[] list = {3, 1, 5, 12, 2, 11};
        int k = 3;
        System.out.println(kLargest(list, k));
    }
    private static List<Integer> kLargest(int[] arr, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            heap.add(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            int num = arr[i];
            if (num > heap.peek()) {
                heap.remove();
                heap.add(num);
            }
        }
        return new ArrayList<>(heap);
    }

}
