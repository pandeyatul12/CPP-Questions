package com.kunal.recursion;

import java.util.ArrayList;
import java.util.List;

public class GeneralizedAbbreviation {
    public static void main(String[] args) {
        List<String> list = ans("BAT");
        System.out.println(list);
    }

    private static List<String> ans(String str) {
        List<String> list = new ArrayList<>();
        ans("", str, list);
        return list;
    }

    private static void ans(String p, String up, List<String> list) {
        if (up.isEmpty()) {
            list.add(p);
            return;
        }
        char ch = up.charAt(0);
        ans(p+ch, up.substring(1), list);
        // check if the last index contains a number
        if (p.length() > 0 && isNumeric(p.charAt(p.length() - 1) + "")) {
            p = p.substring(0, p.length()-1) + (Integer.parseInt(p.charAt(p.length() - 1) + "") + 1);
            ans(p, up.substring(1), list);
        }else{
            ans(p+1, up.substring(1), list);
        }
    }

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
}
