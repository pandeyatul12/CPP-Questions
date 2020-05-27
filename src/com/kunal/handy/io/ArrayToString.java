package com.kunal.handy.io;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayToString {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        char[] ch = s.toCharArray();
        Arrays.sort(ch);
        System.out.println(String.valueOf(ch));

        // OR
        StringBuilder sb = new StringBuilder();
        sb.append(ch);
    }
}
