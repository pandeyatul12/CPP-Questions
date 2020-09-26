package com.kunal.dp;

public class TravellingSalesman {
    public static void main(String[] args) {
        int[][] distances = {
                {0, 10, 20},
                {12, 0, 10},
                {19, 11, 0}
        };
        System.out.println(tsp(distances));
    }

    // Time: O(N!), Space: O(N) where N is the dimension of array, number of cities.
    private static int tsp(int[][] distances) {
        Integer[] check = new Integer[distances.length];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < distances.length; i++) {
            min = Math.min(min, tsp(distances, check, i, i));
        }
        return min;
    }
    private static int tsp(int[][] distances, Integer[] check, int index, int start) {
        int minimum = Integer.MAX_VALUE;
        for (int i = 0; i < distances.length; i++) {
            if (i != index && i != start && check[i] == null) {
                check[i] = 1;
                minimum = Math.min(minimum, distances[index][i] + tsp(distances, check, i, start));
                check[i] = null;
            }
        }
        return minimum == Integer.MAX_VALUE ? distances[index][start] : minimum;
    }

}
