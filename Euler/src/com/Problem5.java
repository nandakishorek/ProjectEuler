/**
 * 
 */
package com;

/**
 * 
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 * 
 * @author nandakri
 *
 */
public class Problem5 {

	static int MAX = 20;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int[] primes = sieve(MAX);
		int[] maxPowers = new int[primes.length];
		for(int i=1;i<=MAX; ++i){
			int temp = i;
			for(int j=0;j<primes.length;++j){
				if(primes[j]==0){
					//the array is delimited by zero
					break;
				}
				int count = 0;
				if(temp%primes[j]==0){
					do{
						temp /= primes[j];
						++count;
					}while(temp%primes[j]==0);
					
					
					if(count>maxPowers[j]){
						maxPowers[j] = count;
					}
				}
			}
		}
		int lcm = 1;
		for(int i=0;i<primes.length;++i){
			if(primes[i]==0){
				//the array is delimited by zero
				break;
			}
			lcm *= Math.pow(primes[i], maxPowers[i]);
		}
		System.out.println(lcm);
	}
	
	/**
	 * 
	 * @param n natural number
	 * @return array of primes less than 'n', using sieve of Eratosthenes algorithm
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
