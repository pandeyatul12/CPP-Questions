package com.kunal.binarySearch;

public class RotationCount {
    public static void main(String[] args) {
        int[] arr = {3, 3, 7, 3};
        System.out.println(countRotations(arr));
    }

    public static int countRotations(int[] arr) {
        int p = pivot2(arr);
        if (p == -1) {
            return 0;
        }
        return p + 1;
    }

    // will not work if array contains duplicates
    public static int pivot(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid < high && arr[mid] > arr[mid + 1]) {
                return mid;
            }
            if (mid > low && arr[mid] < arr[mid - 1]) {
                return mid - 1;
            }
            if (arr[low] >= arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    // This will work even if array contains duplicates
    public static int pivot2(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid < high && arr[mid] > arr[mid + 1]) {
                return mid;
            }
            if (mid > low && arr[mid] < arr[mid - 1]) {
                return mid - 1;
            }

            // this is the only difference from the previous solution
            // if numbers at indices start, mid, and end are same, we can't choose a side
            // the best we can do is to skip one number from both ends if they are not the smallest number
            if (arr[low] == arr[mid] && arr[high] == arr[mid]) {
                if (arr[low] > arr[low + 1]) // if element at start+1 is not the smallest
                    return low;
                ++low;
                if (arr[high - 1] > arr[high]) // if the element at end is not the smallest
                    return high - 1;
                --high;
                // left side is sorted, so the pivot is on right side
            } else if (arr[low] < arr[mid] || (arr[low] == arr[mid] && arr[mid] > arr[high])) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
