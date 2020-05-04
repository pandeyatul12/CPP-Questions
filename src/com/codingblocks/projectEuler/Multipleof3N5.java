package com.codingblocks.projectEuler;

import java.util.Scanner;

public class Multipleof3N5 {
    // 1
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = 1000;
        System.out.println(ans(n));
    }
    public static int ans(int n) {
        int sum = 0;
        for (int i = 3; i < n; i++) {
            if (i % 3 == 0 || i % 5 == 0){
                sum += i;
            }
        }
        return sum;
    }
}
