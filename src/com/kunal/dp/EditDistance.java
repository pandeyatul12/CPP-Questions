package com.kunal.dp;

public class EditDistance {
    public static void main(String[] args) {
        String a = "teh";
        String b = "the";
        System.out.println(editDisItr(a, b));
        System.out.println(editDis2(a, b));
    }

    public static int editDis(String a, String b) {
        return editDis(a, b, 0, 0);
    }

    // time: O(3^(m+n))
    private static int editDis(String a, String b, int i, int j) {
        if (i == a.length()) {
            return b.length() - j;
        }
        if (j == b.length()) {
            return a.length() - i;
        }
        if (a.charAt(i) == b.charAt(j)) {
            return editDis(a, b, i + 1, j + 1);
        }
        int change = editDis(a, b, i + 1, j + 1);
        int addChar = editDis(a, b, i, j + 1);
        int delChar = editDis(a, b, i + 1, j);

        return 1 + Math.min(
                change,
                Math.min(addChar, delChar)
        );
    }

    private static int editDis2(String a, String b) {
        if (a.isEmpty()) {
            return b.length();
        }
        if (b.isEmpty()) {
            return a.length();
        }
        if (a.charAt(0) == b.charAt(0)) {
            return editDis2(a.substring(1), b.substring(1));
        }
        int change = editDis2(a.substring(1), b.substring(1));
        int addChar = editDis2(a, b.substring(1));
        int delChar = editDis2(a.substring(1), b);

        return 1 + Math.min(
                change,
                Math.min(addChar, delChar)
        );
    }

    // Time & Space: O(N * M)
    public static int editDisDP(String a, String b) {
        Integer[][] dp = new Integer[a.length()][b.length()];
        return editDisDP(a, b, 0, 0, dp);
    }

    private static int editDisDP(String a, String b, int i, int j, Integer[][] dp) {
        if (i == a.length()) {
            return b.length() - j;
        }
        if (j == b.length()) {
            return a.length() - i;
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        if (a.charAt(i) == b.charAt(j)) {
            return editDisDP(a, b, i + 1, j + 1, dp);
        }
        int change = editDisDP(a, b, i + 1, j + 1, dp);
        int addChar = editDisDP(a, b, i, j + 1, dp);
        int delChar = editDisDP(a, b, i + 1, j, dp);

        dp[i][j] = 1 + Math.min(
                change,
                Math.min(addChar, delChar)
        );
        return dp[i][j];
    }

    // Time & Space: O(N * M)
    public static int editDisItr(String a, String b) {
        int[][] dp = new int[a.length() + 1][b.length() + 1];

        for (int i = 0; i < a.length(); i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < b.length(); i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(
                            dp[i - 1][j - 1],
                            Math.min(dp[i][j - 1], dp[i - 1][j])
                    );
                }
            }
        }
        return dp[a.length()][b.length()];
    }

}
