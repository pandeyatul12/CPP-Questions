package com.kunal.dp;

import java.util.Arrays;

public class LongestCommonSubseq {

    public static void main(String[] args) {
        String first = "aman";
        String second = "manan";

        int[][] mem = new int[first.length() + 1][second.length() + 1];

        for (int[] ints : mem) {
            Arrays.fill(ints, -1);
        }

        System.out.println(lcsRecDP(first, second, mem));
        System.out.println(lcsItr(first, second));
    }

    // Time: O(2^(m+n))
    public static int lcsRec(String first, String second) {
        if (first.isEmpty() || second.isEmpty()) {
            return 0;
        }

        char f = first.charAt(0);
        char s = second.charAt(0);

        if (f == s) {
            return 1 + lcsRec(first.substring(1), second.substring(1));
        } else {
            return Math.max(lcsRec(first.substring(1), second), lcsRec(first, second.substring(1)));
        }
    }

    // time and space: O(mn)
    public static int lcsRecDP(String first, String second, int[][] mem) {
        if (first.isEmpty() || second.isEmpty()) {
            return 0;
        }

        if (mem[first.length()][second.length()] != -1) {
            return mem[first.length()][second.length()];
        }

        char f = first.charAt(0);
        char s = second.charAt(0);

        if (f == s) {
            mem[first.length()][second.length()] = 1 + lcsRecDP(first.substring(1), second.substring(1), mem);
        } else {
            mem[first.length()][second.length()] = Math.max(lcsRecDP(first.substring(1), second, mem), lcsRecDP(first, second.substring(1), mem));
        }
        return mem[first.length()][second.length()];
    }

    // time and space: O(mn)
    public static int lcsItr(String first, String second) {
        int[][] mem = new int[first.length() + 1][second.length() + 1];

        for (int i = 0; i <= first.length(); i++) {
            mem[i][0] = 0;
        }
        for (int i = 0; i <= second.length(); i++) {
            mem[0][i] = 0;
        }
//        mem[i][j] contains length of LCS of first[0..i-1] and second[0..j-1]
        for (int i = 1; i <= first.length(); i++) {
            for (int j = 1; j <= second.length(); j++) {
                if (first.charAt(i-1) == second.charAt(j-1)) {
                    mem[i][j] = 1 + mem[i-1][j-1];
                } else {
                    mem[i][j] = Math.max(mem[i-1][j], mem[i][j-1]);
                }
            }
        }
        print(mem);
        return mem[first.length()][second.length()];
    }

    public static void print(int[][] mem) {
        for(int[] arr : mem) {
            System.out.println(Arrays.toString(arr));
        }
    }

}
