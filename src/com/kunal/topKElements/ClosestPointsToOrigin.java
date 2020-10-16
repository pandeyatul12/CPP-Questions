package com.kunal.topKElements;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
/*
    Time: O(NLogK)
    Space: O(K)
*/
public class ClosestPointsToOrigin {

    public static void main(String[] args) {
        Point[] points = {new Point(1, 3), new Point(3, 4), new Point(2, -1)};
        int k = 2;
        System.out.println(kClosestPoints(points, k));
    }

    public static List<Point> kClosestPoints(Point[] points, int k) {
        PriorityQueue<Point> maxHeap = new PriorityQueue<>(Comparator.comparingInt(o -> -o.distFromOrigin()));
        for (int i = 0; i < k; i++) {
            maxHeap.add(points[i]);
        }
        for (int i = k; i < points.length; i++) {
            int dist = points[i].distFromOrigin();
            if (dist < maxHeap.peek().distFromOrigin()) {
                maxHeap.remove();
                maxHeap.add(points[i]);
            }
        }
        return new ArrayList<>(maxHeap);
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int distFromOrigin() {
            return (x * x) + (y * y);
        }

        @Override
        public String toString() {
            return "[" + x + ", " + y + "]";
        }
    }
}
