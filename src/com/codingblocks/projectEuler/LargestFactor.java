package com.codingblocks.projectEuler;

import java.math.BigInteger;
import java.util.Scanner;

public class LargestFactor {
    public static void main(String[] args) {
        BigInteger n = new BigInteger("600851475143");
        long a = n.sqrt().longValue();

        while (n.mod(new BigInteger("2")).compareTo(new BigInteger("0")) == 0){
            System.out.print(2 + " ");
            n = n.divide(new BigInteger("2"));
        }
        for (int i = 3; i <= a; i++) {
            while (n.mod(new BigInteger(i+"")).compareTo(new BigInteger("0")) == 0){
                System.out.print(i + " ");
                n = n.divide(new BigInteger(i+""));
            }
        }
        if (n.compareTo(new BigInteger("2")) > 0){
            System.out.println(n);
        }
    }
}
