package com.kunal.slidingWindow;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PermutationInString {
    // https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3333/
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println(checkInclusion("ab", "hjsbaik"));
    }

    /*
        Time Complexity: O(N + M)
        Space Complexity: O(M) // M is length of the pattern
    */

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

    public boolean checkInclusion2(String s1, String s2) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s1.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int start = 0;
        int found = 0;
        for (int end = 0; end < s2.length(); end++) {
            char ch = s2.charAt(end);
            if (map.containsKey(ch)){
                map.put(ch, map.get(ch) - 1);
                if (map.get(ch) == 0){
                    found++;
                }
            }
            if (found == map.size()){
                return true;
            }
            if (end >= s1.length()){
                // shrink by 1
                char first = s2.charAt(start);
                if (map.containsKey(first)){
                    if (map.get(first) == 0){
                        found--;
                    }
                    map.put(first, map.get(first) + 1);
                }
                start++;
            }
        }
        return false;
    }
}
