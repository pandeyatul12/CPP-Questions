package com.kunal.projectEuler;

public class EvenFibo {
    // 2
    public static void main(String[] args) {
        long f = 1;
        long s = 2;
        long sum = 0;
        while (f <= 4000000){
            if (f % 2 == 0){
                sum += f;
            }
            long t = f;
            f = s;
            s = t + s;
        }
        System.out.println(sum);
    }
}
