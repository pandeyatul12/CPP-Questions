package com.kunal.mathematics;

import java.util.Scanner;

public class FiboSum {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for (int i = 0; i < t; i++) {
            int n = s.nextInt();
            int m = s.nextInt();
            long ans = sum(m) - sum(n-1);

            System.out.println(ans % 1000000007);
        }
    }
    public static long fibo(int n){
        return (long) ((Math.pow((Math.sqrt(5)+1)/2, n) - Math.pow((1-Math.sqrt(5))/2, n))/Math.sqrt(5));
    }
    public static long sum(int n) {
        return fibo(n+2) - 1;
    }
}
