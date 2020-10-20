package com.kunal.dp;

// https://leetcode.com/problems/decode-ways/
public class DecodeWays {

    public int numDecodingsRec(String s) {
        return numDecodingsRec(s, s.length());
    }

    private int numDecodingsRec(String s, int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        if (s.charAt(0) == '0') {
            return 0;
        }
        int count = 0;
        if (s.charAt(n - 1) > '0') {
            count = numDecodingsRec(s, n - 1);
        }
        if (s.charAt(n - 2) == '1' ||
                (s.charAt(n - 2) == '2' && s.charAt(n - 1) <= '6')) {
            count += numDecodingsRec(s, n - 2);
        }
        return count;
    }

    private int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        if (s.charAt(0) == '0') {
            return 0;
        }
        for (int i = 2; i <= n; i++) {
            dp[i] = 0;
            if (s.charAt(i-1) > '0') {
                dp[i] = dp[i-1];
            }
            if (s.charAt(i-2) == '1' ||
                    (s.charAt(i-2) == '2' && s.charAt(i-1) <= '6')) {
                dp[i] += dp[i-2];
            }
        }
        return dp[n];
    }

}
