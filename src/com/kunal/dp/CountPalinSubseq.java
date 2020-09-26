package com.kunal.dp;

public class CountPalinSubseq {
    public static void main(String[] args) {
        String s = "bccd";
        System.out.println(countPalin(s));
    }
    public static int countPalin(String s) {
        return countPalin(s, 0, s.length()-1);
    }

    private static int countPalin(String s, int f, int l) {
        if (s.isEmpty() || f > l) {
            return 0;
        }
        int count = 0;

        return count;
    }
}
