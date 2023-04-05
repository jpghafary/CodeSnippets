package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static String decode(String input){
        List<String> output = new ArrayList<>();

        for(int i = 0 ; i<input.length()/2 ; i++){
            output.add(String.valueOf(input.charAt(i)));
            output.add(String.valueOf(input.charAt(input.length() - i -1)));

            if( output.size() == input.length() ){
                break;
            }else if(output.size() == input.length() - 1){
                output.add(String.valueOf(input.charAt(input.length()/2)));
            }
        }
        return String.join("", output);
    }

    public static void main(String[] args) {
        String string1 = "Hlpe";
        String decode1 = decode(string1);
        System.out.println(string1 + " - " + decode1);

        String string2 = "Hlole";
        String decoded2  = decode(string2);
        System.out.println(string2 + " - " + decoded2);

    }
}
