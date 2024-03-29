package com.educative;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * You are given an array of positive numbers from 1 to n, such that all numbers from 1 to n are present except one number x. 
 * You have to find x. 
 * The input array is not sorted.
 * 
 * @author JGhafary
 */
public class MissingNumber {
	
	private static int findMissingNumber(List<Integer> input) {
		int existingTotal = input.stream().mapToInt(Integer::intValue).sum();
		
		int min = input.stream().mapToInt(Integer::intValue).min().getAsInt();
		int max = input.stream().mapToInt(Integer::intValue).max().getAsInt();
		
		IntStream stream = IntStream.rangeClosed(min, max);
		int expectedTotal = stream.boxed().mapToInt(Integer::intValue).sum();
		
		return expectedTotal - existingTotal;
	}

	public static void main(String[] args) {
		List<Integer> input = Arrays.asList(3, 7, 1, 2, 8, 4 , 5);
			
		int missingNumber = findMissingNumber(input);
		System.out.println(missingNumber);
	}
}
