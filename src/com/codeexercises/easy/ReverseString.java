package com.codeexercises.easy;

public class ReverseString {

    public static String reserveString(String string){
        StringBuilder builder = new StringBuilder(string).reverse();
        return builder.toString();
    }

    public static void main(String ...args){
        String string = "Hello World";
        System.out.println(reserveString(string));
    }
}
