package com.codeexercises.easy;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

public class FindMaximum {

    private static int findMaximum(int[] list){
        return Arrays.stream(list).max().getAsInt();
    }

    public static void main(String ...args){
        Random random = new Random();
        int[] list = random.ints(100, 0, 100).toArray();
        System.out.println(Arrays.stream(list).mapToObj(String::valueOf).collect(Collectors.joining(",")));
        int max = findMaximum(list);
        System.out.println(max);
    }
}
