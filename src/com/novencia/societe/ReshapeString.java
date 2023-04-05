package com.novencia.societe;

import java.util.ArrayList;
import java.util.List;

public class ReshapeString {

    public static String reshapeIterateSubString(int n, String str){
        str = str.replaceAll(" ", "");
        List<String> subStrings = new ArrayList<>();
        for(int i = 0 ; i<str.length() ; i+=n){
            subStrings.add(str.substring(i, Math.min(str.length(), i + n)));
        }
        return String.join("\n", subStrings);
    }

    public static String reshapeIterateOnChars(int n, String str){
        StringBuilder buffer = new StringBuilder();

        char[] chars = str.replaceAll(" ", "").toCharArray();
        int count = 0;
        for (char aChar : chars) {
            if (count != n) {
                buffer.append(aChar);
                count++;
            } else {
                count = 1;
                buffer.append("\n").append(aChar);
            }
        }
        return buffer.toString();
    }

    public static String reshapeRegEx(int n, String str){
        str = str.replaceAll(" ", "");

        String[] temp = str.split("(?<=\\G.{"+n+"})");
        return String.join("\n", temp);
    }

    public static void main(String ...args){
        String expected = "";
        String reshaped = "";

        expected = "abc\ndef\nghi\nj";
        reshaped = reshapeIterateSubString(3, "abc def ghij");
        System.out.println(expected.equals(reshaped) );

        expected = "12\n34\n56";
        reshaped = reshapeIterateSubString(2, "1 23 456");
        System.out.println(expected.equals(reshaped));
    }
}
