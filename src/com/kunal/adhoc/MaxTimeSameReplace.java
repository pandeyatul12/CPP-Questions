package com.kunal.adhoc;

import java.util.Scanner;

public class MaxTimeSameReplace {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println(solution("2?:?8"));
    }
    public static String solution(String T) {
        char a = T.charAt(0);
        char b = T.charAt(1);
        char c = T.charAt(3);
        char d = T.charAt(4);

        if (a == '?'){
            return T.replace('?', '2');
        }
        if (b == '?'){
            // check if a was 2
            if (a == '2'){
                return T.replace('?', '3');
            }else{
                if (c != '?' && d != '?'){
                    return T.replace('?', '9');
                }
                if (c == '?' && d == '?'){
                    return T.replace('?', '5');
                }
                if (d == '0'){
                    return T.replace('?', '6');
                }
                if (d != '?'){
                    return T.replace('?', '5');
                }
                if (c == '6'){
                    return T.replace('?', '0');
                }
                return T.replace('?', '9');
            }
        }
        if (c == '?'){
            if (d == '?'){
                return T.replace('?', '5');
            }else{
                if (d == '0'){
                    return T.replace('?', '6');
                }else{
                    return T.replace('?', '5');
                }
            }
        }
        if (d == '?'){
            if (c == '6') {
                return T.replace('?', '0');
            }
            return T.replace('?', '9');
        }
        return T;
    }
}
