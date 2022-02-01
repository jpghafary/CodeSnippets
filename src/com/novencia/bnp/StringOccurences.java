package com.novencia.bnp;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given two Strings s1, and s2. Find all the combination of s1 in s2.
 * Constraints:
 * s1 length is always 3.
 * 
 * 
 * Given S1 = HRW
 * Given S2 = HERHRWS
 * S1 appears 3 times in S2 positions: 
 * 	1- (0 2 5)
 * 	2- (0 4 5)
 * 	3- (3 4 5) 
 * 
 * @author JGhafary
 * 
 */
public class StringOccurences {
	
	private static void findCombinations(String bigString, String prefix, int requiredLength, int startIndex, List<String> possibilities){
	    if (requiredLength == 0) {
	    	possibilities.add(prefix);
	    }
	    
	    for (int i = startIndex; i < bigString.length(); i++) {
	        String newPrefix = prefix + bigString.charAt(i);
	        findCombinations(bigString, newPrefix, requiredLength - 1, i+1, possibilities);
	    }
	}
	
	private static long matchCombinations(String smallString, String bigString) {
		List<String> possibilities = new ArrayList<String>();
		findCombinations(bigString, "", smallString.length(), 0, possibilities);
		
		return possibilities.stream().filter(s -> smallString.equals(s)).collect(Collectors.counting());
	}
	
	public static void main(String args[]) {
		String smallString = "LOR";
		String bigString = "HELLOWORLDHOWAREYOU";
		long result = matchCombinations(smallString, bigString);
		System.out.println("result = "+ result);
		
		smallString = "HRW";
		bigString = "HERHRWS";
		result = matchCombinations(smallString, bigString);
		System.out.println("result = "+ result);
	}
}
