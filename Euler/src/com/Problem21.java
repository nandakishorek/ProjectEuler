/**
 * 
 */
package com;

/**
 * 
 * Let d(n) be defined as the sum of proper divisors of n (numbers less than n
 * which divide evenly into n). If d(a) = b and d(b) = a, where a ≠ b, then a
 * and b are an amicable pair and each of a and b are called amicable numbers.
 * 
 * For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44,
 * 55 and 110; therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4,
 * 71 and 142; so d(284) = 220.
 * 
 * Evaluate the sum of all the amicable numbers under 10000.
 * 
 * 
 * @author nandakri
 *
 */
public class Problem21 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        
        int[] sumOfDivisors = new int[10000];
        
        for (int i = 1; i < 10000; ++i) {
            int sqrt = (int) Math.sqrt(i);
            int sum = 1; // 1 is a divisor for all numbers
            for (int div = 2; div <= sqrt; ++div) {
                if (i % div == 0) {
                    sum += (i / div) + div; // add both divisor and quotient
                }
            }
            sumOfDivisors[i] = sum; 
        }
        
        int amicableNumSum = 0;
        for (int i = 1; i < 10000; ++i) {
            // amicable number check
            if (sumOfDivisors[i] < 10000
                    && sumOfDivisors[sumOfDivisors[i]] == i
                    && i != sumOfDivisors[i]) {
                amicableNumSum += i + sumOfDivisors[i];
                sumOfDivisors[sumOfDivisors[i]] = 0; // poison reverse, so that double counting is avoided
            }
        }
        
        System.out.println("sum of all the amicable numbers under 10000 " + amicableNumSum);
    }

}
