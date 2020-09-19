package com.kunal.twoPointer;

public class HappyNumber {
    public static boolean find(int num) {
        int slow = num;
        int fast = num;
        do{
            slow = getSum(slow);
            fast = getSum(getSum(fast));
        }while(slow != fast);
        return slow == 1;
    }
    public static int getSum(int num){
        int sum = 0;
        while(num > 0){
            int rem = num % 10;
            num /= 10;
            sum += rem * rem;
        }
        return sum;
    }
    public static void main(String[] args) {
        System.out.println(HappyNumber.find(23));
        System.out.println(HappyNumber.find(12));
    }
}
