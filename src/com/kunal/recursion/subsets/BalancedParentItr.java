package com.kunal.recursion.subsets;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BalancedParentItr {
    public static void main(String[] args) {
        List<String> ans = getAns(2);
        System.out.println(ans);
    }

    private static List<String> getAns(int num) {
        List<String> ans = new ArrayList<>();
        Queue<Parenthesis> queue = new LinkedList<>();
        queue.add(new Parenthesis(0, 0, ""));
        while (!queue.isEmpty()) {
            Parenthesis removed = queue.remove();
            if (removed.open == num && removed.closed == num) {
                ans.add(removed.str);
            } else {
                if (removed.open < num) {
                    queue.add(new Parenthesis(removed.open + 1, removed.closed, removed.str + "("));
                }
                if (removed.closed < removed.open) {
                    queue.add(new Parenthesis(removed.open, removed.closed + 1, removed.str + ")"));
                }
            }
        }
        return ans;
    }

    static class Parenthesis {
        int open;
        int closed;
        String str;

        public Parenthesis(int open, int closed, String str) {
            this.open = open;
            this.closed = closed;
            this.str = str;
        }
    }
}
