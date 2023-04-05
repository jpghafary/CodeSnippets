package com.company;

public class StringSpacing {

    public static String escape(String input){
        StringBuffer buffer = new StringBuffer();

        char[] chars = input.toCharArray();

        buffer.append(chars[0]);
        for(int i=1 ; i<chars.length ; i++){
            if(Character.isLetter(chars[i-1]))
                buffer.append(" ");
            buffer.append(chars[i]);
        }

        return buffer.toString();
    }

    public static void main(String args[]){
        String input1 = "C!odi!ngGame!";
        String input2 = "CODE";
        String input3 = "!CodingGAME!";
//        String output = "C o d i n g G a m e!";

        System.out.println(escape(input1));
        System.out.println(escape(input2));
        System.out.println(escape(input3));
    }

}
