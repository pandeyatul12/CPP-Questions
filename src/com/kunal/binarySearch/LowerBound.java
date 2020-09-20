package com.kunal.binarySearch;

public class LowerBound {
    public static void main(String[] args) {
        int[] arr = { 2, 7, 11, 15 };
//        int low = 10;
//        int high = 40;
//        int l1 = lowerBound(arr, low);
//        int l2 = lowerBound(arr, high);
//        System.out.println(l2 - l1);

        int n = 32;
        System.out.println(arr[lowerBound(arr, 8)]);
    }
    public static int lowerBound(int[] array, int value) {
        int low = 0;
        int high = array.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            //checks if the value is less than middle element of the array
            if (value <= array[mid]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    // ceiling of the ‘key’ will be the smallest element in the given array greater than or equal to the ‘key’
    public static int searchCeilingOfANumber(int[] arr, int key) {
        if (key > arr[arr.length - 1]) // if the 'key' is bigger than the biggest element
            return -1;

        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (key < arr[mid]) {
                end = mid - 1;
            } else if (key > arr[mid]) {
                start = mid + 1;
            } else { // found the key
                return mid;
            }
        }
        // since the loop is running until 'start <= end', so at the end of the while loop, 'start == end+1'
        // we are not able to find the element in the given array, so the next big number will be arr[start]
        return start;
    }

    // floor of the ‘key’ will be the biggest element in the given array smaller than or equal to the ‘key’
    public static int floor(int[] arr, int value) {
        int low = 0;
        int high = arr.length - 1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(arr[mid] == value) {
                return mid;
            }
            if(arr[mid] < value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
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
