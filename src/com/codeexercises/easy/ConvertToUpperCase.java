package com.codeexercises.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ConvertToUpperCase {

    private static List<String> convertToUpperCase(List<String> list){
        return list.stream().map(String::toUpperCase).collect(Collectors.toList());
    }

    public static void main(String ...args){
        List<String> list = new ArrayList<>();
        list.add("Hello World");
        list.add("hello WorLd");
        list.add("Hell@ W@rld");
        list.add("HEllo WoRld");

        List<String> upperCaseList = convertToUpperCase(list);
        upperCaseList.forEach(System.out::println);
    }
}
