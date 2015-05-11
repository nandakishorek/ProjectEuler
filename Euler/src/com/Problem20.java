/**
 * 
 */
package com;

import java.util.Arrays;

/**
 * 
 * n! means n × (n − 1) × ... × 3 × 2 × 1
 * 
 * For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800, and the sum of the
 * digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
 * 
 * Find the sum of the digits in the number 100!
 * 
 * @author nandakri
 *
 */
public class Problem20 {

    static final int DELIMITER = -1;
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        
        //find the number of digits in 100!
        double sum = 0f;
        for (int i=1; i <= 100; ++i) {
            sum += Math.log10(i);
        }
        
        int[] result = new int[(int) Math.ceil(sum)];
        Arrays.fill(result, DELIMITER);
        
        result[0] = 1; // start the multiplication with 1
        for (int i = 1; i <= 100; ++i) {
            int carry = 0;
            for (int j = 0; j < result.length; ++j) {
                int product = 0;
                if (result[j] != DELIMITER) {
                    product = result[j] * i;
                }
                product += carry;
                result[j] = product % 10;
                carry = product / 10;
                if( result[j]==DELIMITER && carry==0) {
                    break;
                }
            }
        }

        int total = 0;
        for (int i : result) {
            // find the sum of the all the digits in the product
            if (i == DELIMITER) {
                break;
            }
            total += i;
        }
        
        System.out.println("Sum of all the digits in 100! = "+ total);
    }
    
}
