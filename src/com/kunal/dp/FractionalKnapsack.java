package com.kunal.dp;

public class FractionalKnapsack {
    static float knapSack(int W, float[] wt, float[] val) {

        // maxratio will store the maximum value to weight
        // ratio we can have for any item and maxindex
        // will store the index of that element
        float maxratio = Integer.MIN_VALUE;
        int maxindex = 0;

        // Find the maximum ratio
        for (int i = 0; i < val.length; i++) {
            if ((val[i] / wt[i]) > maxratio) {
                maxratio = (val[i] / wt[i]);
                maxindex = i;
            }
        }

        // The item with the maximum value to
        // weight ratio will be put into
        // the knapsack repeatedly until full
        return (W * maxratio);
    }

    // Driver code
    public static void main(String[] args) {
        float[] val = {14, 27, 44, 19};
        float[] wt = {6, 7, 9, 8};

        int W = 50;

        System.out.println(knapSack(W, wt, val));
    }

}
