package com.codeexercises.easy;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

public class AverageValue {

    private static double averageValue(int[] list){
        return Arrays.stream(list).average().getAsDouble();
    }

    public static void main(String ...args){
        Random random = new Random();
        int[] list = random.ints(100, 0, 100).toArray();
        System.out.println(Arrays.stream(list).mapToObj(String::valueOf).collect(Collectors.joining(",")));
        double max = averageValue(list);
        System.out.println(max);
    }
}
