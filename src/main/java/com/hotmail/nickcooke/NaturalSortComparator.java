package com.hotmail.nickcooke;

import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NaturalSortComparator implements Comparator<String> {

    @Override
    public int compare(String s1, String s2) {
        for (int i = 0; i < s1.length() && i < s2.length(); i++) {
            char char1 = s1.toCharArray()[i];
            char char2 = s2.toCharArray()[i];
            if (Character.isDigit(char1) && Character.isDigit(char2) ) {
                Long num1 = extractNumber(s1.substring(i));
                Long num2 = extractNumber(s2.substring(i));
                if (num1.equals(num2)) continue;
                return num1.compareTo(num2);
            }
            if (char1 == char2) continue;
            return char1 > char2 ? 1 : -1;
        }
        if (s1.length() == s2.length()) return 0;
        if (s1.length() > s2.length()) return 1;
        return -1;
    }

    private Long extractNumber(String str) {
        Pattern p = Pattern.compile("(\\d*).*");
        Matcher m = p.matcher(str);
        m.find();
        return Long.parseLong(m.group(1));
    }

    private boolean isDigit(char c) {
        return Character.isDigit(c);
    }
}
