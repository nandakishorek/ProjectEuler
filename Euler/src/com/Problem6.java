/**
 * 
 */
package com;

/**
 * 
 * The sum of the squares of the first ten natural numbers is,
 * 12 + 22 + ... + 102 = 385
 * The square of the sum of the first ten natural numbers is,
 * (1 + 2 + ... + 10)2 = 552 = 3025
 * Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 − 385 = 2640.
 * Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
 * 
 * @author nandakri
 *
 */
public class Problem6 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int n = 100;
		long nSquare = n * n;
		
		// sigma(n^2) - sigma(n)^2
		double diff = (nSquare + n) * (3*nSquare -n -2)/ 12.00; //have simplified the equation by hand to this.
		System.out.printf("%.0f", diff);
	}

}
