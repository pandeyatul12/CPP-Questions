package com.kunal;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int p = 0;
        int x = 0;
        for (int i = 1; i <= n; i++) {
            if (2*p+1<=n){
                for (int j = 10*p+1; j <= 10*p+5; j++) {
                    System.out.print(j + " ");
                }
                System.out.println();
                p++;
            }
            else {
                for (int j = 5*(p-x+1)+1; j <= 5*(p-x+1)+5; j++) {
                    System.out.print(j + " ");
                }
                System.out.println();
                x += 2;
                if (x > p){
                    break;
                }

//                for (int j = 5*((p)-x+1)+1; j <= 5*((p)-x+1)+5; j++) {
//                    System.out.print(j + " ");
//                }
//                System.out.println();
//                x += 2;
//                if (x > p){
//                    break;
//                }
            }
        }
    }
}
