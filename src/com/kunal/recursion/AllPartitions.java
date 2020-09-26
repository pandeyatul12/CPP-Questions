package com.kunal.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AllPartitions {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String str = input.next();

        ArrayList<String> list = new ArrayList<>();

        partitions(list, str);

    }

    public static void partitions(ArrayList<String> list, String unprocessed) {

        if (unprocessed.isEmpty()) {
            System.out.println(list);
            return;
        }

        for (int i = 1; i <= unprocessed.length(); i++) {
            String processed = unprocessed.substring(0, i);
            ArrayList<String> temp = new ArrayList<>(list);
            temp.add(processed);
            partitions(temp, unprocessed.substring(i));
        }
    }

    public static List<List<String>> partitionsRet(String s) {
        ArrayList<String> list = new ArrayList<>();
        return partitionsRet(s, list);
    }

    private static List<List<String>> partitionsRet(String s, List<String> list) {
        if (s.isEmpty()) {
            List<List<String>> temp = new ArrayList<>();
            temp.add(list);
            return temp;
        }
        List<List<String>> ans = new ArrayList<>();
        for (int i = 1; i <= s.length(); i++) {
            String temp = s.substring(0, i);
            ArrayList<String> curr = new ArrayList<>(list);
            curr.add(temp);
            ans.addAll(partitionsRet(s.substring(i), curr));
        }
        return ans;
    }
}
