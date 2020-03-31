package com.codingblocks.mathematics;

import java.math.BigInteger;
import java.util.Scanner;

public class Marbles {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for (int i = 0; i < t; i++) {
            int n = s.nextInt();
            int k = s.nextInt();
            System.out.println((factorial(n-1).divide(factorial(k-1))).divide(factorial(n-k)));
        }
    }
    public static BigInteger factorial(int a) {
        BigInteger f = new BigInteger(String.valueOf(1));
        while(a > 0) {
            f = f.multiply(new BigInteger(String.valueOf(a)));
            a--;
        }
        return f;
    }
}