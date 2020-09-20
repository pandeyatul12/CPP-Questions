package com.kunal.binarySearch;

public class RBS {
    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 6, 1, 2};
        System.out.println(findPivot(arr));
        System.out.println(rbs(arr, 5));
    }

    public static int rbs2(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[low] <= arr[mid]) {
                if (target < arr[mid] && target >= arr[low]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (target > arr[mid] && target <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    public static int rbs(int[] arr, int target) {
        int pivot = findPivot(arr);
        if (arr[pivot] == target) {
            return pivot;
        }
        if (arr[0] < target) {
            return bs(arr, target, 0, pivot - 1);
        }
        return bs(arr, target, pivot + 1, arr.length - 1);
    }

    public static int findPivot(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        while (low < high) {
            int mid = low + (high - low) /2;
            if (mid < high && arr[mid] > arr[mid+1]) {
                return mid;
            }
            if (mid > low && arr[mid] < arr[mid-1]) {
                return mid -1;
            }
            if (arr[mid] > arr[low]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public static int bs(int[] arr, int target, int s, int e) {
        int low = s;
        int high = e;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
