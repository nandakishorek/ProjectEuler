/**
 * 
 */
package com;

/**
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
 * What is the 10 001st prime number?
 * 
 * @author nandakri
 *
 */
public class Problem7 {

	static int n = 10001; //10001'th prime number
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int index = n - 1; //since we are counting from 0
		
		int[] primes = sieve(200000); //primes till what number? I have just guessed it to be less than 20 times the index. 
		for(int i=0;i<primes.length;++i){
			if(i==index){
				System.out.println(primes[i]);
				break;
			}
		}

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
		for(i=0,j=0;i<size;++i){
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
