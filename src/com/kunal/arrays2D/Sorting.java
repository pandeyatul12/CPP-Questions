package com.kunal.arrays2D;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Sorting {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[][] matrix = { { 39, 27, 11, 42 },
                { 10, 93, 91, 90 },
                { 54, 78, 56, 89 },
                { 24, 64, 20, 65 } };
        sortMatrix(matrix, 0);
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
    public static void sortMatrix(int[][] arr, int col) {
//        Arrays.sort(arr, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return o1[col] - o2[col];
//            }
//        });

//        Arrays.sort(arr, (o1, o2) -> o1[col] - o2[col]);

        Arrays.sort(arr, Comparator.comparingInt(o -> o[col]));
    }
}
