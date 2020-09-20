package com.kunal.bitmasking;

import java.util.Arrays;

public class TwoSame {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new int[]{1, 4, 2, 1, 3, 5, 6, 2, 3, 5}));
    }
    public static int[] ans(int[] arr) {
        int xor = 0;
        for(int num : arr) {
            xor ^= num;
        }
        int rightmost = xor & (-xor);

        int xor1 = 0;
        int xor2 = 0;

        for(int num : arr) {
            if ((rightmost & num) == 0) {
                xor1 ^= num;
            } else {
                xor2 ^= num;
            }
        }
        return new int[]{xor1, xor2};
    }
}
