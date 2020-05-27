package com.kunal.mathematics;

import java.util.Scanner;

public class LegendresFormula {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for (int i = 0; i < t; i++) {
            int n = s.nextInt();
            int k = s.nextInt();
            System.out.println(findX(n, k));
         }
    }
    public static int findX(int n, int p) {
        int x = 0;
        while(n > 0) {
            n /= p;
            x += n;
        }
        return x;
    }
}
