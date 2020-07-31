package com.kunal.handy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class IntToIntegerArray {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] arr = {3,4,2,1,5};
        Integer[] list = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(list, Collections.reverseOrder());
        System.out.println(Arrays.toString(list));
    }
}
