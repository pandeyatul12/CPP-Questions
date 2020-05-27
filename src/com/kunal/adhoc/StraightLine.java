package com.kunal.adhoc;

import java.util.Scanner;

public class StraightLine {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[][] coordinates = {{1,2},{2,3},{3,4},{4,5},{5,6},{6,7}};
        System.out.println(checkStraightLine(coordinates));
    }

    public static boolean checkStraightLine(int[][] coordinates) {
        int[] first = coordinates[0];
        int[] second = coordinates[1];
        Integer s = slope(first, second);
        for (int i = 2; i < coordinates.length; i++) {
            Integer s2 = slope(coordinates[i], second);
            if (s2 == null){
                return false;
            }
            if (!s2.equals(s)){
                return false;
            }
        }
        return true;
    }

    public static Integer slope(int[] first, int[] second){
        if (second[0] - first[0] == 0){
            return null;
        }
        return (second[1] - first[1])/(second[0] - first[0]);
    }

}
