package com.kunal.recursion;
import java.util.*;


public class UniqueTrees {
    public static List<TreeNode> findUniqueTrees(int n) {
        List<TreeNode> nodes = findUniqueTrees(1, n);
        return nodes;
    }
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    };

    private static List<TreeNode> findUniqueTrees(int start, int end) {
        List<TreeNode> nodes = new LinkedList<>();

        if (start > end) {
            nodes.add(null);
            return nodes;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> left = findUniqueTrees(start, i-1);
            List<TreeNode> right = findUniqueTrees(i+1, end);
            for(TreeNode l : left) {
                for(TreeNode r : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    nodes.add(root);
                }
            }
        }

        return nodes;
    }

    public static void main(String[] args) {
        List<TreeNode> result = UniqueTrees.findUniqueTrees(2);
        System.out.print("Total trees: " + result.size());
    }
}
