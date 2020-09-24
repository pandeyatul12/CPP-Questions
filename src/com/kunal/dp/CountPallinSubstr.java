package com.kunal.dp;

public class CountPallinSubstr {

    public static void main(String[] args) {

        System.out.println(countPallin("axha"));
    }

    public static int countPallin(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            // one for even and one for odd length
            count += countPallin(s, i, i) + countPallin(s, i, i+1);
        }

        return count;
    }

    private static int countPallin(String s, int left, int right) {
        if (left > right) {
            return 0;
        }
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
        return count;
    }

}
