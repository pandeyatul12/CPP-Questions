package com.kunal.topKElements;

import java.util.*;

/*
    Time: O(NLogN)
    Space: O(N)
*/
public class TaskScheduler {
    public static void main(String[] args) {
        char[] tasks = new char[]{'a', 'a', 'a', 'b', 'c', 'c'};
        System.out.println("Minimum intervals needed to execute all tasks: " + scheduleTasks(tasks, 2));

        tasks = new char[]{'a', 'b', 'a'};
        System.out.println("Minimum intervals needed to execute all tasks: " + scheduleTasks(tasks, 3));
    }

    public static int scheduleTasks(char[] tasks, int k) {
        Map<Character, Integer> map = new HashMap<>();
        for (char task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(Comparator.comparingInt(o -> o.getValue()));
        maxHeap.addAll(map.entrySet());
        int ans = 0;
        while (!maxHeap.isEmpty()) {
            List<Map.Entry<Character, Integer>> waitList = new ArrayList<>();
            int n = k + 1;
            // take top k+1 elements
            while (n > 0 && !maxHeap.isEmpty()) {
                Map.Entry<Character, Integer> removed = maxHeap.remove();
                ans++;
                if (removed.getValue() > 1) {
                    removed.setValue(removed.getValue() - 1);
                    waitList.add(removed);
                }
                n--;
            }
            maxHeap.addAll(waitList);
            if (!maxHeap.isEmpty()) {
                ans += n;
            }
        }
        return ans;
    }
}
