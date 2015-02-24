/**
 * 
 */
package com;

/**
 * 
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * What is the largest prime factor of the number 600851475143 ?
 * 
 * @author nandakri
 *
 */
public class Problem3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		long n = 9223372036854775807L;
		
		int[] primeArray = sieve((int) Math.sqrt(n));
		
		int i;
		for(i=0;i<primeArray.length;++i){
			if(n%primeArray[i] == 0){
				break;
			}
		}
		System.out.println(primeArray[i]);
	}

	/**
	 * 
	 * @param n natural number
	 * @return array of primes less than sqrt(n), using sieve of Eratosthenes algorithm
	 */
	public static int[] sieve(int n){
		int size = n / 2; //all odd numbers from 3 upto n and including 2
		int[] tempArray = new int[size];
		int i;
		int j=1;
		for(i=0;i<size;++i){
			tempArray[i] = j;
			j += 2;
		}
		tempArray[0] = 2;
		
		for(i=1;i<size;++i){
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
		
		// re-arrange the array so that a zero marks the end of the array
		int[] primeArray = new int[size];
		for(i=size-1,j=0;i>-1;--i){
			if(tempArray[i]!=0){
				primeArray[j++] = tempArray[i];
			}
		}
		if(j<size){
			primeArray[j] = 0;
		}
		return primeArray;
	}
}