package com.kunal.mergeIntervals;

import java.util.*;
/*
    Time Complexity: O(nlogn)
    Space Complexity: O(n)
*/

public class MaximumCPULoad {
    static class Job {
        int start;
        int end;
        int cpuLoad;

        public Job(int start, int end, int cpuLoad) {
            this.start = start;
            this.end = end;
            this.cpuLoad = cpuLoad;
        }
    };

    public static int findMaxCPULoad(List<Job> jobs) {
        jobs.sort(Comparator.comparingInt(o -> o.start));
        int maxLoad = 0;
        int currentLoad = 0;
        PriorityQueue<Job> heap = new PriorityQueue<>(Comparator.comparingInt(o -> o.end));

        for(Job job : jobs){
            // remove all jobs that are done
            while (!heap.isEmpty() && heap.peek().end <= job.start){
                currentLoad -= heap.remove().cpuLoad;
            }
            heap.add(job);
            currentLoad += job.cpuLoad;
            maxLoad = Math.max(maxLoad, currentLoad);
        }
        return maxLoad;
    }

    public static void main(String[] args) {
        List<Job> input = new ArrayList<>(Arrays.asList(new Job(1, 4, 3), new Job(2, 5, 4), new Job(7, 9, 6)));
        System.out.println("Maximum CPU load at any time: " + MaximumCPULoad.findMaxCPULoad(input));

        input = new ArrayList<>(Arrays.asList(new Job(6, 7, 10), new Job(2, 4, 11), new Job(8, 12, 15)));
        System.out.println("Maximum CPU load at any time: " + MaximumCPULoad.findMaxCPULoad(input));

        input = new ArrayList<>(Arrays.asList(new Job(1, 4, 2), new Job(2, 4, 1), new Job(3, 6, 5)));
        System.out.println("Maximum CPU load at any time: " + MaximumCPULoad.findMaxCPULoad(input));
    }
}
