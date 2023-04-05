package com.codeexercises.easy;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

public class LinearSearch {

    private static int search(int n, int[] list){
        int result = Arrays.binarySearch(list, n);
        return result < 0 ? -1 : result;
    }

    public static void main(String ...args){
        Random random = new Random();
        int[] list = random.ints(100, 0, 100).toArray();
        String concat = Arrays.stream(list).mapToObj(String::valueOf).collect(Collectors.joining(",", "Numbers: ", "."));
        System.out.println(concat);
        int n = random.nextInt();
        System.out.println(n);

        int index = search(n, list);
        System.out.println(index);
    }
}


