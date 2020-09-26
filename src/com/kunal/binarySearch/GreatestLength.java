package com.kunal.binarySearch;

// https://leetcode.com/discuss/interview-question/388503/Google-or-Phone-Screen-or-Cut-Ribbon/350993
public class GreatestLength {
    public static int greatestLength(int[] arr, int k) {
        int lo = 1, hi = arr[arr.length - 1];
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int len = getLen(arr, mid);
            if (len >= k) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return hi;
    }

    private static int getLen(int[] arr, int target) {
        int res = 0;
        for (int a : arr) {
            res += (a / target);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 9};
        System.out.println(greatestLength(arr, 5));
    }
}
