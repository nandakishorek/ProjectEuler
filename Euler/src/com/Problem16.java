/**
 * 
 */
package com;

/**
 * 
 * 2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
 * 
 * What is the sum of the digits of the number 21000?
 * 
 * @author nandakri
 *
 */
public class Problem16 {

    static final int DELIMITER = -1;
    static final int BASE = 2;
    static final int EXPONENT = 1000;

    /**
     * 
     * Number of digits in a number = floor(1 + EXPONENT * log10 BASE).
     * according to this rule, number of digits in 2^1000 = 302
     * 
     * @param args
     */
    public static void main(String[] args) {

        int numDigits = (int) (1 + Math.floor(1 + EXPONENT * Math.log10(BASE)));
        
        int[] result = new int[numDigits];
        result[0] = 1; // start the multiplication with 1
        
        for (int i = 1; i < result.length; ++i) {
            result[i] = DELIMITER; // delimiter for the multiplication to end
        }

        for (int i = 0; i < EXPONENT; ++i) {
            int carry = 0;
            for (int j = 0; j < result.length; ++j) {
                // multiply each digit by BASE and find the product
                int product = 0;
                if (result[j] != DELIMITER) {
                    product = result[j] * BASE;
                }
                product += carry;
                result[j] = product % 10;
                carry = product / 10;
                if( result[j]==DELIMITER && carry==0) {
                    break;
                }
            }
        }

        int sum = 0;
        for (int i : result) {
            // find the sum of the all the digits in the product
            if (i == DELIMITER) {
                break;
            }
            sum += i;
        }

        System.out.println("Sum of all the digits in " + BASE + "^" + EXPONENT + " = " + sum);
    }

}
