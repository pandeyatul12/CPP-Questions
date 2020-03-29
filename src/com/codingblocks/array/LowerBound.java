package com.codingblocks.array;

public class LowerBound {
    public static void main(String[] args) {
        int[] arr = { 10, 20, 30, 40, 50 };
        int low = 10;
        int high = 40;
        int l1 = lowerBound(arr, low);
        int l2 = lowerBound(arr, high);
        System.out.println(l2 - l1);
    }
    public static int lowerBound(int[] array, int value) {
        int low = 0;
        int high = array.length;
        while (low < high) {
            final int mid = (low + high) / 2;
            //checks if the value is less than middle element of the array
            if (value <= array[mid]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
    public static int lowerBound2(int[] arr, int value) {
        int n = arr.length;
        int low = 0;
        int high = n - 1;
        int first_pos = n;
        while(low <= high) {
            int mid = (low + high) / 2;
            if(arr[mid] >= value) {
                first_pos = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return first_pos;
    }
}
