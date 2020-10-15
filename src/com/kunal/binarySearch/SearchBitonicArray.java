package com.kunal.binarySearch;

public class SearchBitonicArray {
    public static void main(String[] args) {
        int[] arr = {1, 3, 8, 4, 3};
        int target = 4;
        System.out.println(search(arr, target));
    }

    public static int search(int[] arr, int key) {
        int maxIndex = findPivot(arr);
        int keyIndex = binarySearch(arr, key, 0, maxIndex);
        if (keyIndex != -1)
            return keyIndex;
        return binarySearch(arr, key, maxIndex + 1, arr.length - 1);
    }

    // find pivot
    public static int findPivot(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] < arr[mid+1]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    // [1, 3, 8, 4, 3]
    // order-agnostic binary search
    private static int binarySearch(int[] arr, int key, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (key == arr[mid])
                return mid;

            if (arr[start] < arr[end]) { // ascending order
                if (key < arr[mid]) {
                    end = mid - 1;
                } else { // key > arr[mid]
                    start = mid + 1;
                }
            } else { // descending order
                if (key > arr[mid]) {
                    end = mid - 1;
                } else { // key < arr[mid]
                    start = mid + 1;
                }
            }
        }
        return -1; // element is not found
    }

}
