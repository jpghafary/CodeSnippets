package com.company;

import java.util.Arrays;

public class Temperature {

    public static void main(String args[]){
        int[] temps = new int[]{
//                42, 5, 12, 21, -5, 24
//            -5, -4, -2, 12, -40, 4, 2, 18, 11, 5
                -10, -10
        };

        int[] distance = new int[temps.length];
        for(int i=0 ; i<temps.length ; i++){
            distance[i] = Math.abs(temps[i]);
        }

        Arrays.sort(distance);
        distance = Arrays.stream(distance).distinct().toArray();

        boolean hasSameDistance = false;
        if(distance.length != temps.length)
            hasSameDistance = true;

        if(hasSameDistance)
            System.out.println(distance[0]);
        else{
            int absResult = Math.abs(temps[0]);
            int result = temps[0];

            for(int i=0 ; i<temps.length ; i++){
                System.out.println("result == "+ result);
                System.out.println("absResult == "+ absResult);
                if(Math.abs(temps[i]) <= absResult){
                    absResult = Math.abs(temps[i]);
                    result = temps[i];
                }
            }
            System.out.println(result);
        }
    }
}

/**
 * Scanner in = new Scanner(System.in);
 * int n = in.nextInt(); // the number of temperatures to analyse
 *
 * if(n == 0){
 * 	System.out.println("0");
 * 	return;
 * }
 *
 * int[] temps = new int[n];
 * for (int i = 0; i < n; i++) {
 * 	int temperature = in.nextInt(); // a temperature expressed as an integer ranging from -273 to 5526
 * 	temps[i] = temperature;
 * }
 *
 * for(int i=0 ; i<temps.length ; i++)
 * 	System.err.println(temps[i]);
 * System.err.println("-------------done");
 *
 * int result = Math.abs(temps[0]);
 * for(int i=0 ; i<temps.length ; i++){
 * 	if(Math.abs(temps[i]) < result)
 * 		result = temps[i];
 * }
 *
 * System.out.println(result);
 */
