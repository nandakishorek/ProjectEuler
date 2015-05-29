/**
 * 
 */
package com;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 
 * A perfect number is a number for which the sum of its proper divisors is
 * exactly equal to the number. For example, the sum of the proper divisors of
 * 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.
 * 
 * A number n is called deficient if the sum of its proper divisors is less than
 * n and it is called abundant if this sum exceeds n.
 * 
 * As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest
 * number that can be written as the sum of two abundant numbers is 24. By
 * mathematical analysis, it can be shown that all integers greater than 28123
 * can be written as the sum of two abundant numbers. However, this upper limit
 * cannot be reduced any further by analysis even though it is known that the
 * greatest number that cannot be expressed as the sum of two abundant numbers
 * is less than this limit.
 * 
 * Find the sum of all the positive integers which cannot be written as the sum
 * of two abundant numbers.
 * 
 * @author nandakri
 *
 */
public class Problem23 {
    
    static final int MIN_ABUNDANT = 12;
    static final int LIMIT = 28124;
    static final int SIGMA_TWENTY_THREE = 276;

    /**
     * A brute force solution - 
     * 1. Calculate the abundant numbers till the limit. 
     * 2. Check each number if it can be written as a sum of any two
     *    abundant numbers in the pre-calculated set
     * 
     * @param args
     */
    public static void main(String[] args) {
                
        Set<Integer> abundantNumSet = new LinkedHashSet<Integer>(); //sorted set of abundant numbers

        // find all abundant numbers from 13 to 28123, since 12 is the smallest
        // abundant number and greatest number that cannot be expressed as the
        // sum of two abundant numbers is less than 28123
        abundantNumSet.add(MIN_ABUNDANT);
        for (int i = MIN_ABUNDANT+1; i < LIMIT; ++i) {
            if (isAbundant(i)) {
                abundantNumSet.add(i);
            }
        }

        int total = SIGMA_TWENTY_THREE; // sigma 23, since 24 = 12 * 2, minor and unnecessary optimization
        for (int i = (MIN_ABUNDANT * 2); i < LIMIT; ++i) {
            
            if (!isSumOfTwoAbundants(i, abundantNumSet)) {
                // the number cannot be represented as sum of two abundant
                // numbers
                total += i;
            }
        }
        
        System.out.println(total);
    }
    
    public static boolean isSumOfTwoAbundants(int num, Set<Integer> abundantNumSet) {
        for (Integer i : abundantNumSet) {
            if (abundantNumSet.contains(num - i)) {
                // the number can be represented as a sum of two
                return true;
            }
            if (i > num) {
                // the abundant number should less than a given number to
                // be part of the numbers forming the sum
                break;
            }
        }
        return false;
    }

    public static boolean isAbundant(int n) {
        int sum = 1;
        int end = (int) Math.sqrt(n);

        for (int i = 2; i <= end; ++i) {
            if (n % i == 0) {
                int quotient = n / i;

                if (quotient != i) {
                    sum += i + quotient; // add the factors
                } else {
                    // avoid adding twice - factor in case of perfect squares
                    sum += quotient;
                }
            }
        }

        return (sum > n);
    }
}
