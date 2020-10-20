package com.kunal.array;

import java.util.Arrays;
import java.util.Comparator;

public class PosiNegSort {

    private static class CustomComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            if (o1 > 0 && o2 > 0) {
                return o1 - o2;
            }
            if (o1 < 0 && o2 < 0) {
                return o2 - o1;
            }
            return o1 - o2;
        }
    }

    public static void main(String[] args) {
        Integer[] nums = {-1, 2, 4, -8, 10, 9, 100, -3, 2};
        Arrays.sort(nums, new CustomComparator());
        System.out.println(Arrays.toString(nums));
    }
}