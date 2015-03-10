package com;

/**
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 * Find the sum of all the primes below two million.
 * 
 * @author nandakri
 *
 */
public class Problem10 {

	/**
	 * Using sieve of Eratosthenes algorithm to find sum of primes till 2 million
	 * @param args
	 */
	public static void main(String[] args) {

		int n = 2000000; //primes upto 2 million
		
		int size = n / 2; //all odd numbers from 3 upto n and including 2
		int[] tempArray = new int[size];
		int i;
		int j=1;
		for(i=0;i<size;++i){
			tempArray[i] = j;
			j += 2;
		}
		tempArray[0] = 2; //append 2 at the beginning, since 2 is prime
		
		int len = (int)Math.sqrt(n);
		for(i=1;i<len;++i){
			if(tempArray[i]!=0){			
				j = i;
				while(true){
					j += tempArray[i]; //move in multiples of the number, this is fine since even multiples have already been removed
					if(j>=size){
						break;
					}
					tempArray[j] = 0;
				}
				
			}
		}
				
		long sum = 0L;
		for(i=0;i<size;++i){
			if(tempArray[i]!=0){
				sum += tempArray[i];
			}
		}
		System.out.println("sum of primes till " + n + " is " + sum);
	}
	
}
