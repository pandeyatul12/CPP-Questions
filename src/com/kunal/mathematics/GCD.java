package com.kunal.mathematics;

import java.util.Scanner;

public class GCD {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int a = 98;
        int b = 56;
        System.out.println(gcd(a, b));
    }

    private static int gcd(int a, int b) {
        if (b == 0){
            return a;
        }
        return gcd(b, a % b);
    }

    static int gcdMultiple(int[] arr) {
        int ans = arr[0];
        for (int i = 1; i < arr.length; i++){
            ans = gcd(arr[i], ans);
            if(ans == 1) {
                return 1;
            }
        }
        return ans;
    }
}
