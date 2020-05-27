package com.kunal.numberTheory;

import java.util.Scanner;

public class FastModuloExponentiation {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        int b = s.nextInt();
        int m = s.nextInt();
        // calculate (a^b)%m
        System.out.println(ans(a,b,m));
    }
    public static int ans(int a, int b, int m){
        int res = 1;
        while (b > 0){
            if ((b & 1) == 1){
                res = (res*a)%m;
            }
            b = b >> 1;
            a = (a*a)%m;
        }
        return res;
    }
}
