/**
 * 
 */
package com;

/**
 * A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
 * Find the largest palindrome made from the product of two 3-digit numbers.
 * 
 * @author nandakri
 *
 * A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
 * Find the largest palindrome made from the product of two 3-digit numbers.
 * 
 */
public class Problem4 {
	
	static int MAX_DIGITS = 6;
	
	public static void main(String[] args){
		
		int max = 0;
		for(int i=999;i>99;--i){
			for(int j=999;j>99;--j){
				int product = i * j;
				if(product < max){
					// the optimization
					break;
				}
				if(checkPalindrome(product) && product>max){
					max = product;
				}
			}
		}
		System.out.println(max);
	}
	
	public static boolean checkPalindrome(int n){
		int[] digits = new int[MAX_DIGITS];
		int temp = n;
		int i=0;
		while(temp>0){
			digits[i++] = temp % 10;
			temp = temp/10;
		}
		
		int end = MAX_DIGITS - 1;
		int start = 0;
		boolean firstDigit = false;
		while(start<end){
			if(!firstDigit && digits[end] == 0){
				//skip all the trailing zeroes
				--end;
				continue;
			}
			
			if(digits[end] > 0){
				firstDigit = true;
			}
			if(digits[start++]!=digits[end--]){
				return false;
			}
		}
		return true;
	}

}
