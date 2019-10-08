package com.hotmail.nickcooke;

import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NaturalSortComparatorStringBuilder  implements Comparator<String> {
    @Override
    public int compare(String str1, String str2) {
        StringBuilder sb1 = new StringBuilder (str1);
        StringBuilder  sb2 = new StringBuilder (str2);

        while (sb1.length() > 0 && sb2.length() > 0) {
            if (isDigit(sb1.charAt(0)) && isDigit(sb2.charAt(0))) {
                String numberString1 = extractNumber(sb1.toString());
                String numberString2 = extractNumber(sb2.toString());
                Long number1 = Long.parseLong(numberString1);
                Long number2 = Long.parseLong(numberString2);
                System.out.println("comparing *" + numberString1 + "* and *" + numberString2 + "*");
                if (number1.equals(number2)) {//strings could be different if they have leading zeroes
                    sb1.delete(0, numberString1.length());
                    sb2.delete(0, numberString2.length());
                    continue;
                }
                return number1.compareTo(number2);
            }
            if (sb1.charAt(0) == sb2.charAt(0)) {
                sb1.deleteCharAt(0);
                sb2.deleteCharAt(0);
                continue;
            }
            return sb1.charAt(0) > sb2.charAt(0) ? 1 : -1;
        }

        if (sb1.length() >0) return 1;
        if (sb2.length() >0) return -1;
        return 0;
    }

    private String extractNumber(String str) {
        Pattern p = Pattern.compile("(\\d*).*");
        Matcher m = p.matcher(str);
        m.find();
        return m.group(1);
    }

    private boolean isDigit(char c) {
        return Character.isDigit(c);
    }
}