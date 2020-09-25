package com.kunal.dp;

public class Board {
    public static void main(String[] args) {
        int target = 6;
        Integer[] dp = new Integer[target+1];
        System.out.println(countBoardPrint(6, 6, ""));
        System.out.println(countBoard(6, 6));
        System.out.println(countBoardItr(6, 6));
    }
    public static int countBoard(int target, int faces) {
        if (target == 0) {
            return 1;
        }
        int count = 0;
        for (int i = 1; i <= faces && i <= target; i++) {
            count += countBoard(target-i, faces);
        }
        return count;
    }

    public static int countBoardDP(int target, int faces, Integer[] dp) {
        if (target == 0) {
            return 1;
        }
        if (dp[target] != null) {
            return dp[target];
        }
        int count = 0;
        for (int i = 1; i <= faces && i <= target; i++) {
            count += countBoardDP(target-i, faces, dp);
        }
        dp[target] = count;
        return count;
    }

    public static int countBoardPrint(int target, int faces, String path) {
        if (target == 0) {
            System.out.println(path);
            return 1;
        }
        int count = 0;
        for (int i = 1; i <= faces && i <= target; i++) {
            count += countBoardPrint(target-i, faces, path+i);
        }
        return count;
    }

    public static int countBoardItr(int target, int faces) {
        int[] dp = new int[target+1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) { // this is for faces, say you had only i faces, etc.
            int count = 0;
            for (int face = 1; face <= i && face <= faces; face++) { // this is the one in our recursion call
                count += dp[i-face];
            }
            dp[i] = count;
        }
        return dp[target];
    }
}
