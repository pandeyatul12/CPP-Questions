package com.codingblocks.numberTheory;

import java.math.BigInteger;
import java.util.Scanner;

public class LargeFactorial {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        long n = s.nextLong();
        System.out.println(ans(n));
    }

    private static BigInteger ans(long n) {
        BigInteger f = new BigInteger("1");
        BigInteger s = new BigInteger(n+"");
        BigInteger one = new BigInteger("1");
        while (n > 0){
            f = f.multiply(s);
            s = s.subtract(one);
            n--;
        }
        return f;
    }

}
