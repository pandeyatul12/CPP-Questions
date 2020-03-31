package com.codingblocks.mathematics;

import java.text.DecimalFormat;
import java.util.Scanner;

public class CoupleCollector {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        DecimalFormat df = new DecimalFormat("0.00");
        for (int j = 0; j < t; j++) {
            int n = s.nextInt();    // number of distinct coupons
            float sum = 0.0f;
            for (int i = 1; i <= n; i++) {
                sum += (n*1.0) / (n+1-i);
            }
            System.out.println(df.format(sum));
        }
    }
}
