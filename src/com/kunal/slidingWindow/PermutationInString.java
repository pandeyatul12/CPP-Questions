package com.kunal.slidingWindow;

import java.util.Scanner;

public class PermutationInString {
    // https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3333/
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println(checkInclusion("ab", "hjsbaik"));
    }

    public static boolean checkInclusion(String s1, String s2) {
        int[] char_count = new int[26];

        for(char ch : s1.toCharArray()) char_count[ch-'a']++;

        int left = 0;
        int right = 0;
        int count = s1.length();

        while(right < s2.length()) {
            if(char_count[s2.charAt(right++)-'a']-- >= 1) count--;

            if(count == 0) return true;

            if(right - left == s1.length() && char_count[s2.charAt(left++)-'a']++ >= 0) count++;
        }

        return false;
    }
}
