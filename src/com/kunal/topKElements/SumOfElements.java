package com.kunal.topKElements;

import java.util.Comparator;
import java.util.PriorityQueue;

// Given an array, find the sum of all numbers between the K1’th and K2’th smallest elements of that array.
/*
    Time: O(NLogK2)
    Space: O(K2)
*/
public class SumOfElements {
    public static void main(String[] args) {

    }

    public static int sumOfElements(int[] arr, int k1, int k2) {
        // maintain top k2 smallest elements
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.comparingInt(o -> -o));
        for (int i = 0; i < k2; i++) {
            maxHeap.add(arr[i]);
        }
        for (int i = k2; i < arr.length; i++) {
            int num = arr[i];
            if (num < maxHeap.peek()) {
                maxHeap.remove();
                maxHeap.add(num);
            }
        }

        // get the sum of numbers between k1 and k2 indices
        // these numbers will be at the top of the max heap
        int ans = 0;
        maxHeap.remove();
        for (int i = 0; i < k2 - k1 - 1; i++) {
            ans += maxHeap.remove();
        }
        return ans;
    }
}
