package com.codingblocks.recursion;

import java.util.Arrays;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        arr = Arrays.copyOfRange(arr, 1, arr.length);
        System.out.println(Arrays.toString(arr));
    }
}
