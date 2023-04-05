package com.novencia.bnp;
import java.util.concurrent.TimeUnit;
import java.util.stream.LongStream;

public class IdealNumbers{

	public static void main(String[] args) {
//		long low = 200L;
//		long high = 405L;

		long low = 73L;
		long high = 707788855L;

		long before, after;

		long result = 0L;

		before = System.currentTimeMillis();
		result = getIdealNums(low, high);
		after = System.currentTimeMillis();
		System.out.printf("Results of '%s': took %d seconds Result = {%d} %n", "getIdealNums", TimeUnit.MILLISECONDS.toSeconds(after - before), result);

		before = System.currentTimeMillis();
		result = getIdealNumbers(low, high);
		after = System.currentTimeMillis();
		System.out.printf("Results of '%s': took %d seconds Result = {%d} %n", "getIdealNumbers", TimeUnit.MILLISECONDS.toSeconds(after - before), result);

		before = System.currentTimeMillis();
		result = getNums(low, high);
		after = System.currentTimeMillis();
		System.out.printf("Results of '%s': took %d seconds Result = {%d} %n", "getNums", TimeUnit.MILLISECONDS.toSeconds(after - before), result);
	}

	private static long getNums(long low, long high) {
		long answer = 0;
		
		for(long i=1 ; i<=high ; i*=3) {
			for(long j=i ; j<=high ; j*=5) {
				if(j >= low) {
					answer ++;
				}
			}
		}
		
		return answer;
	}


	public static long getIdealNums(long low, long high) {
		long total = 0;

		for(long i=low ; i<=high ; i++){
			if(isIdealNumber(i)){
				total ++;
			}
		}
		return total;
	}

	private static boolean isIdealNumber(long number){
		int iter3 = modulosDivider(number, 3);
		int iter5 = modulosDivider(number, 5);

		if(Math.pow(3, iter3) * Math.pow(5, iter5) == number)
			return true;

		return false;
	}

	private static int modulosDivider(long number, int divider){
		int iteration = 0;

		while(number % divider == 0){
			iteration ++;
			number = number / divider;
		}

		return iteration;
	}

	public static long getIdealNumbers(long low, long high) {
		LongStream stream = LongStream.rangeClosed(low, high);

		long totalCount = stream.filter(number -> {
			int itr3 = modulosDivider(number, 3);
			int itr5 = modulosDivider(number, 5);

			if(Math.pow(3, itr3) * Math.pow(5, itr5) == number)
				return true;
			return false;
		}).boxed().count();

		return totalCount;
	}

}
