package com;
/**
 * 
 */

/**
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
 * Find the sum of all the multiples of 3 or 5 below 1000.
 * 
 * @author nandakri
 *
 */
public class Problem1 {
	
	public static void main(String[] args){
		int sum = 0;
		int i;
		
		for(i=3;i<1000;i+=3){
			sum += i;
		}
		
		for(i=5;i<1000;i+=5){
			sum += i;
		}
		
		for(i=15;i<1000;i+=15){
			sum -= i;
		}
		System.out.println(sum);
	}

}
