package com.hotmail.nickcooke;

import java.util.Comparator;

public class NaturalSortComparatorCharArray implements Comparator<String> {

    @Override
    public int compare(String str1, String str2) {
        char[] ca1 = str1.toCharArray(), ca2 = str2.toCharArray();
        int idx1=0, idx2 = 0;

        System.out.println("comparing ^" + str1 + "^ and ^" + str2 + "^");
        while (ca1.length > idx1 && ca2.length > idx2) {
            if (Character.isDigit(ca1[idx1]) && Character.isDigit(ca2[idx2])) {
                String numberString1 = extractNumber(ca1, idx1);
                String numberString2 = extractNumber(ca2, idx2);
                Long number1 = Long.parseLong(numberString1);
                Long number2 = Long.parseLong(numberString2);
                if (number1.equals(number2)) {
                    idx1 += numberString1.length();
                    idx2 += numberString2.length();
                    continue;
                }
                return number1.compareTo(number2);
            }
            if (ca1[idx1] == ca2[idx2]) {
                idx1++;
                idx2++;
                continue;
            }
            return ca1[idx1] > ca2[idx2] ? 1 : -1;
        }

        if (ca1.length == idx1 && ca2.length == idx2) return 0;
        if (ca1.length > idx1) return 1;
        return -1;
    }

    private String extractNumber(char[] ca, int index) {
        String result = "";
        while (index < ca.length && Character.isDigit(ca[index])) {
            result += ca[index];
            index++;
        }
        return result;
    }
}
