package com.company;

import java.util.ArrayList;
import java.util.List;

public class HackerRankLIFO {

    public static void main(String[] args){
        String[] inputs = new String[]{
                "({}[])",
                "(({()})))",
                "({(){}()})()({(){}()})(){()}",
                "{}()))(()()({}}{}",
                "}}}}",
                "))))",
                "{{{",
                "(((",
                "[]{}(){()}((())){{{}}}{()()}{{}{}}",
                "[[]][][]",
                "}{"
        };

        for(String input : inputs) {
            System.out.println(input);
            List<String> lifo = new ArrayList<>();

            int size = 0;
            for (char c : input.toCharArray()) {
                if ('{' == c || '(' == c || '[' == c) {
                    lifo.add(0, String.valueOf(c));
                    size++;
                }
                else if ('}' == c || ')' == c || ']' == c) {
                    try {
                        lifo.remove(0);
                    } catch (Exception e) {
                    }
                    size --;
                }
            }
            if (lifo.isEmpty() && size == 0)
                System.out.println("true");
            else
                System.out.println("false");

        }
    }
}
