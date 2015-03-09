/**
 * 
 */
package com;

/**
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
 * a2 + b2 = c2
 * For example, 32 + 42 = 9 + 16 = 25 = 52.
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc.
 * 
 * @author nandakri
 *
 */
public class Problem9 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// a simple brute force solution
		for(int i=998;i>2;--i){
			for(int j=i-1;j>0;--j){
				for(int k=j-1;k>0;--k){
					if((i + j + k ) == 1000){
						if( i*i == j*j + k*k){
							System.out.println("i: " +i + " j: " +j + " k: " + k);
							System.out.println("i*j*k " + (i*j*k));
						}
					}
				}
			}
		}
	}
}