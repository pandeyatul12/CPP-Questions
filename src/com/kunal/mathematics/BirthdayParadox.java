package com.kunal.mathematics;

import java.util.Scanner;

public class BirthdayParadox {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        double p = s.nextDouble();
        System.out.println((int)(Math.ceil(Math.sqrt(2 * 365 * Math.log(1/(1-p))))));
    }
}
