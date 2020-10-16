package com.kunal.recursion.subsets;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
      Time Complexity: O(N * 2^N)
      Space Complexity: O(2 ^ N)
    */
public class BalancedParenthesis {
    int n;

    public void solve() {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        ans("", 0, 0);
        List<String> list = new ArrayList<>();
        ansList("", 0, 0, list);
        System.out.println(list);
    }

    private void ansList(String str, int open, int close, List<String> list) {
        if (close == n) {
            list.add(str);
            return;
        }
        if (open < n) {
            ansList(str + "(", open + 1, close, list);
        }
        if (close < open) {
            ansList(str + ")", open, close + 1, list);
        }
    }

    private void ans(String s, int open, int closed) {
        if (closed == n) {
            System.out.println(s);
            return;
        }
        if (open < n) {
            ans(s + "(", open + 1, closed);
        }
        if (closed < open) {
            ans(s + ")", open, closed + 1);
        }
    }

    public List<String> generateParenthesis(int n) {
        return generateParenthesis(n, 0, 0, "");
    }

    private List<String> generateParenthesis(int n, int open, int closed, String s) {
        if (closed == n) {
            List<String> list = new ArrayList<>();
            list.add(s);
            return list;
        }

        List<String> ans = new ArrayList<>();

        if (open < n) {
            ans.addAll(generateParenthesis(n, open + 1, closed, s + "("));
        }
        if (closed < open) {
            ans.addAll(generateParenthesis(n, open, closed + 1, s + ")"));
        }
        return ans;
    }

}