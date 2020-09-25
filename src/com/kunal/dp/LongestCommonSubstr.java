package com.kunal.dp;

public class LongestCommonSubstr {
    public static void main(String[] args) {
        System.out.println(lcs("hello", "ellf"));
        System.out.println(lcsDP("hello", "ellf"));
        System.out.println(lcsItr("hello", "ellf"));
    }

    // Time: O(3^(m+n))
    private static int lcs(String a, String b) {
        if (a.isEmpty() || b.isEmpty()) {
            return 0;
        }
        int first = 0;
        if (a.charAt(0) == b.charAt(0)) {
            first = 1 + lcs(a.substring(1), b.substring(1));
        }
        int second = Math.max(lcs(a.substring(1), b), lcs(a, b.substring(1)));
        return Math.max(first, second);
    }

//    Time & Space: O(mn^2)
    public static int lcsDP(String a, String b) {
        Integer[][] dp = new Integer[a.length()+1][b.length()+1];
        return lcsDP(a, b, dp);
    }
    private static int lcsDP(String a, String b, Integer[][] dp) {
        if (a.isEmpty() || b.isEmpty()) {
            return 0;
        }
        if (dp[a.length()][b.length()] != null){
            return dp[a.length()][b.length()];
        }
        int first = 0;
        if (a.charAt(0) == b.charAt(0)) {
            first = 1 + lcsDP(a.substring(1), b.substring(1), dp);
        }
        int second = Math.max(lcsDP(a.substring(1), b, dp), lcsDP(a, b.substring(1), dp));
        dp[a.length()][b.length()] = Math.max(first, second);
        return dp[a.length()][b.length()];
    }

    //    Time & Space: O(mn)
    public static int lcsItr(String a, String b) {
        int[][] dp = new int[a.length()+1][b.length()+1];
        for (int i = 0; i <= a.length(); i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= b.length(); i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {
                int first = 0;
                if (a.charAt(i-1) == b.charAt(j-1)) {
                    first = 1 + dp[i-1][j-1];
                }
                int second = Math.max(dp[i][j-1], dp[i-1][j]);
                dp[i][j] = Math.max(first, second);
            }
        }
        return dp[a.length()][b.length()];
    }
}
