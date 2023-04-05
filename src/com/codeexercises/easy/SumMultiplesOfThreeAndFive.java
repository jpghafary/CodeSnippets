package com.codeexercises.easy;

import java.util.stream.IntStream;

public class SumMultiplesOfThreeAndFive {

    private static Integer sum(Integer N){
        IntStream intStream = IntStream.rangeClosed(1, N);
        return intStream.filter(n -> n%3 == 0 || n%5 == 0).sum();
    }

    public static void main(String ...args){
        System.out.println(sum(Integer.MAX_VALUE));
    }
}
