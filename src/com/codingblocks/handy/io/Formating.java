package com.codingblocks.handy.io;

import java.text.DecimalFormat;

public class Formating {
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("0.000");
        System.out.println(df.format(2.4));
        System.out.println(df.format(4.5689));  // will round off to 4.569
        System.out.println(df.format(4.5699));  // will round off to 4.570

    }
}
