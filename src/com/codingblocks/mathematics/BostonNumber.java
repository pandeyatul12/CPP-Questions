package com.codingblocks.mathematics;

import java.util.Scanner;

public class BostonNumber {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        System.out.println(solve(n));
    }
    public static int solve(int n){
        int s = sum(n);
        int p = primeFactors(n);
        if (s == p) {
            return 1;
        }
        return 0;
    }
    public static int primeFactors(int n) {
        int sum = 0;
        int i = 2;
        int nn = n;
        while(i <= Math.sqrt(nn) && n > 0) {
            if (checkPrime(i)) {
                // check if it divides
                while(n % i == 0) {
                    sum += i;
                    n = n / i;
                }
            }
            i++;
        }
        return sum;
    }
    public static int sum(int n) {
        int s = 0;
        while(n > 0) {
            s += n % 10;
            n = n / 10;
        }
        return s;
    }
    public static boolean checkPrime(int n) {
        if(n == 4) {
            return false;
        }
        for (int i = 2; i < Math.sqrt(n); i++) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
