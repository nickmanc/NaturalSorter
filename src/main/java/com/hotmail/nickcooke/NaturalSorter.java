package com.hotmail.nickcooke;

import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NaturalSorter implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
        System.out.println("comparing " + s1 + " and " + s2);
        if (isNumber(s1) && isNumber(s2)) {
            Long number1 = Long.parseLong(s1);
            Long number2 = Long.parseLong(s2);
            return number1.compareTo(number2);

        } else {
            for (int i = 0; i < s1.length() || i < s2.length();i++){
                if (s1.length() <= i) return -1;
                if (s2.length() <= i) return 1;
                char char1 = s1.toCharArray()[i];
                char char2 = s2.toCharArray()[i];
                System.out.println("char1 is " + char1 + ", and char2 is " + char2);
                if (isNumber(char1) && isNumber(char2)){
                    Long num1 = extractNumber(s1.substring(i));
                    Long num2 = extractNumber(s2.substring(i));
                    System.out.println("num1: " + num1);
                    System.out.println("num2: " + num2);

                    if ( num1.compareTo(num2) == 0) continue;
                    return  num1.compareTo(num2);
                }
                if (char1==char2) continue;
                return char1>char2?1:-1;
            }
            return 0;
        }
    }
//       if ( s1.toCharArray()[0] == s2.toCharArray()[0] ) return 0;
//       if ( s1.toCharArray()[0] > s2.toCharArray()[0] ) return 1;
//       return -1;

    private boolean isNumber(String string) {
        return string.matches("\\d+");
    }
    private boolean isNumber(char ch) {
        return Character.isDigit(ch);
    }

    private boolean containsNumber(String string) {
        return string.matches("\\d");
    }

    private Long extractNumber (String str) {
        Pattern p = Pattern.compile("(\\d*).*");
        Matcher m = p.matcher(str);
        m.find();
        System.out.println("result is " + m.group(1));
        Long result =  Long.parseLong(m.group(1));
        System.out.println("was looking at " + str + " and found " + result);
        return result;
    }


}
