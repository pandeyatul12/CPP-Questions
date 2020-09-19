package com.kunal.recursion;

import java.util.*;


class CountUniqueTrees {
    public static void main(String[] args) {
        CountUniqueTrees ct = new CountUniqueTrees();
        int count = ct.countTrees(2);
        System.out.print("Total trees: " + count);
    }

    public int countTrees(int n) {
        return countTrees(1, n);
    }
    private int countTrees(int start, int end) {
        int count = 0;
        if(start > end) {
            return 1;
        }
        for (int i = start; i <= end; i++) {
            count += countTrees(start, i-1) * countTrees(i+1, end);
        }
        return count;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
