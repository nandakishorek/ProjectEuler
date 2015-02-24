/**
 * 
 */
package com;

/**
 * 
 * Each new term in the Fibonacci sequence is generated by adding the previous two terms. By starting with 1 and 2, the first 10 terms will be:
 * 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
 * By considering the terms in the Fibonacci sequence whose values do not exceed four million, find the sum of the even-valued terms.
 * 
 * @author nandakri
 *
 */
public class Problem2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int MAX = 4000000; //4 million
		int sum = 0;
		int n1 = 1;
		int n2 = 2;
		int temp;
		
		while(n2 < MAX){
			sum += n2;
			
			for(int i=0;i<3;++i){
				temp = n1 + n2;
				n1 = n2;
				n2 = temp;
			} 
		}
		
		System.out.println(sum);
	}

}