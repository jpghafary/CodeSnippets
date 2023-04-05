package com.novencia.bnp;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Temp {
	
	private static int sumJ8(int n) {
		IntStream intStream = IntStream.range(1, n);
		
		List<Integer> temp = intStream.boxed().filter(num -> num%3 == 0 || num%5 == 0).collect(Collectors.toList());
		
		return temp.stream().collect(Collectors.summingInt(Integer::intValue));
	}
	
	private static long arithmeticProgression(int number, int firstTerm) {
		number --;
		long divider = number / firstTerm;
		
		return firstTerm * divider * (divider + 1);
	}
	
	public static void main(String args[]) {
		sortHashMapByValue();

//	    int nr = 100;
//
//	    long sum1 = arithmeticProgression(nr, 3);
//	    long sum2 = arithmeticProgression(nr, 5);
//	    long sum3 = arithmeticProgression(nr, 15);
//
//	    long sum = (sum1+sum2-sum3)/2;
//	    System.out.println(sum);

		
	}

	private static int calculate(int iterationNumber){
		int position = 0;
		int step1 = 1;
		int step2 = -2;

		position += step1;
		iterationNumber --;
		position = position + step2;

		iterationNumber -= 1;
		while( iterationNumber > 0 )
		{
			position = position + ( step2 - step1 );
			int buffer = step1;
			step1 = step2;
			step2 = step2 - buffer;
			iterationNumber -= 1;
		}
		return position;
	}

	private static void sortHashMapByValue(){
		HashMap<String, Integer> hm
				= new HashMap<String, Integer>();

		// enter data into hashmap
		hm.put("Math", 98);
		hm.put("Data Structure", 85);
		hm.put("Database", 91);
		hm.put("Java", 95);
		hm.put("Operating System", 79);
		hm.put("Networking", 80);

		HashMap<String, Integer> newMap = hm.entrySet().stream()
				.sorted( (e1, e2) -> e1.getValue().compareTo(e2.getValue()) )
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

		System.out.println(newMap);

		Temp temp = new Temp();
		int hash = temp.hashCode();
		System.out.println(hash);
	}
}
