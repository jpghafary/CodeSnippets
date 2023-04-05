package com.educative;


import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Given an array of integers and a value, 
 * determine if there are any two integers in the array whose sum is equal to the given value. 
 * Return true if the sum exists and return false if it does not.
 * 
 * If input = [5, 7, 1, 2, 8, 4, 3]
 * 
 * sum = 10
 * returns true
 * 
 * sum = 19
 * returns false
 * 
 */
public class SunTwoIntegers {

	private static boolean findSumOfTwo(List<Integer> input, int sum) {
		HashSet<Integer> set = new HashSet<Integer>();
		
		for(int i : input) {
			if(set.contains(sum - i))
				return true;
			set.add(i);
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		List<Integer> input = Arrays.asList(5, 7, 1, 2, 8, 4, 3);
		
		System.out.println(findSumOfTwo(input, 10));
		System.out.println(findSumOfTwo(input, 19));
	}
}
