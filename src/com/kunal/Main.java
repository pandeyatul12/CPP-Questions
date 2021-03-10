package com.kunal;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {4,3,2,1};
        s(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void s(int[] arr) {
        int[] temp = arr.clone();
        Arrays.sort(temp);
    }

}
