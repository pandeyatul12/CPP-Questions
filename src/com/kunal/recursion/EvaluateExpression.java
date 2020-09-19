package com.kunal.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EvaluateExpression {
    public static void main(String[] args) {
        List<Integer> result = diffWaysToEvaluateExpression("1+2*3");
        System.out.println("Expression evaluations: " + result);

        result = diffWaysToEvaluateExpression("2*3-4-5");
        System.out.println("Expression evaluations: " + result);
    }

    static Map<String, List<Integer>> map = new HashMap<>();
    private static List<Integer> diffWaysToEvaluateExpression(String s) {
        List<Integer> result = new ArrayList<>();
        if (map.containsKey(s)) {
            return map.get(s);
        }
        if(!s.contains("+") && !s.contains("-") && !s.contains("*")) {
            result.add(Integer.parseInt(s));
        } else {
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if(!Character.isDigit(ch)) {
                    List<Integer> left = diffWaysToEvaluateExpression(s.substring(0, i));
                    List<Integer> right = diffWaysToEvaluateExpression(s.substring(i+1));
                    for(int l : left) {
                        for(int r : right) {
                            if (ch == '+') {
                                result.add(l + r);
                            }
                            if (ch == '-') {
                                result.add(l - r);
                            }
                            if (ch == '*') {
                                result.add(l * r);
                            }
                        }
                    }
                }
            }
        }
        map.put(s, result);
        return result;
    }

}
