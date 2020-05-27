package com.kunal.leetcodemay20;

import java.util.Scanner;

public class FirstBadVersion {
    static long version;
    static long mid;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        long n = s.nextLong();
        version = s.nextLong();
        System.out.println(firstBadVersion(n));
    }
    public static long firstBadVersion(long n) {
        return firstBadVersion(0, n);
    }

    private static long firstBadVersion(long s, long e) {
        if (s > e){
            return s;
        }
        mid = (s + e) / 2;
        if (isBadVersion(mid)){
            return firstBadVersion(s, mid-1);
        }else{
            return firstBadVersion(mid+1, e);
        }
    }

    public static boolean isBadVersion(long v){
        return v >= version;
    }
}
