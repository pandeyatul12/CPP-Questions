package com.kunal.dp;

import java.util.Arrays;
import java.util.Comparator;

class Entry {
    int start;
    int end;
    int value;

    public Entry(int start, int end, int value) {
        this.start = start;
        this.end = end;
        this.value = value;
    }

}

public class WeightedScheduling {
    public static void main(String[] args) {
        Entry[] entries = {new Entry(0, 2, 25), new Entry(1, 5, 40), new Entry(6, 8, 170), new Entry(3, 7, 220)};
        Arrays.sort(entries, Comparator.comparingInt(o -> o.end));
        System.out.println(findMaxProfitItr(entries)); // 245
        System.out.println(findMaxProfitRec(entries)); // 245
        System.out.println(findMaxProfitRecDP(entries)); // 245
    }

    public static int weightedSchedule(Entry[] entries) {
        Arrays.sort(entries, Comparator.comparingInt(o -> o.start));
        return weightedSchedule(entries, 0, 0, null);
    }

    private static int weightedSchedule(Entry[] entries, int index, int sum, Entry prev) {
        if (index == entries.length) {
            return sum;
        }
        int first = 0;

        if (prev == null || prev.end <= entries[index].start) {
            first = weightedSchedule(entries, index + 1, sum + entries[index].value, entries[index]);
        }

        int second = weightedSchedule(entries, index + 1, sum, prev);
        return Math.max(first, second);
    }

    // Better Way: Must be sorted according to end time
    public static int findMaxProfitRec(Entry[] entries) {
        return findMaxProfitRec(entries, entries.length);
    }

    public static int findMaxProfitRec(Entry[] entries, int n) {
        // Base case
        if (n == 1) return entries[n - 1].value;

        // Find profit when current job is included
        int inclProf = entries[n - 1].value;
        int i = latestNonConflict(entries, n);
        if (i != -1)
            inclProf += findMaxProfitRec(entries, i + 1);

        // Find profit when current job is excluded
        int exclProf = findMaxProfitRec(entries, n - 1);

        return Math.max(inclProf, exclProf);
    }

    public static int findMaxProfitRecDP(Entry[] entries) {
        Integer[] dp = new Integer[entries.length];
        return findMaxProfitRecDP(entries, entries.length, dp);
    }

    public static int findMaxProfitRecDP(Entry[] entries, int n, Integer[] dp) {
        // Base case
        if (n == 1) return entries[n - 1].value;

        if (dp[n - 1] != null) {
            return dp[n - 1];
        }
        // Find profit when current job is included
        int inclProf = entries[n - 1].value;
        int i = latestNonConflict(entries, n);
        if (i != -1)
            inclProf += findMaxProfitRecDP(entries, i + 1, dp);

        // Find profit when current job is excluded
        int exclProf = findMaxProfitRecDP(entries, n - 1, dp);

        dp[n - 1] = Math.max(inclProf, exclProf);
        return dp[n - 1];
    }

    public static int findMaxProfitItr(Entry[] arr) {
        int n = arr.length;
        // Sort jobs according to finish time
        Arrays.sort(arr, Comparator.comparingInt(o -> o.end));

        // Create an array to store solutions of sub-problems.
        // dp[i] stores the profit for jobs till arr[i] (including arr[i])
        int[] dp = new int[n + 1];
        dp[0] = arr[0].value;

        // Fill entries in M[] using recursive property
        for (int i = 1; i <= n; i++) {
            // Find profit including the current job
            int inclProf = arr[i - 1].value;
            int l = latestNonConflict(arr, i);
            if (l != -1)
                inclProf += dp[l];

            // Store maximum of including and excluding
            dp[i] = Math.max(inclProf, dp[i - 1]);
        }

        return dp[n];
    }

    public static int latestNonConflict(Entry[] entries, int i) {
        for (int j = i - 1; j >= 0; j--) {
            if (entries[j].end <= entries[i - 1].start)
                return j;
        }
        return -1;
    }
}
