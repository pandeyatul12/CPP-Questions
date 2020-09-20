package com.kunal.bitmasking;

public class ComplementBase10 {
    public static void main(String[] args) {
        System.out.println(ans(8));
        System.out.println((int)(Math.log(8) / Math.log(2)) + 1);
    }
    private static int ans(int num) {
        int bitCount = (int)(Math.log(num) / Math.log(2)) + 1;
        int temp = (int) Math.pow(2, bitCount) - 1;
        return num ^ temp;
    }
}
