/**
 * 
 */
package com;

/**
 * The following iterative sequence is defined for the set of positive integers:
 * 
 * n → n/2 (n is even) 
 * n → 3n + 1 (n is odd)
 * 
 * Using the rule above and starting with 13, we generate the following
 * sequence: 13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
 * 
 * It can be seen that this sequence (starting at 13 and finishing at 1)
 * contains 10 terms. Although it has not been proved yet (Collatz Problem), it
 * is thought that all starting numbers finish at 1.
 * 
 * Which starting number, under one million, produces the longest chain?
 * 
 * NOTE: Once the chain starts the terms are allowed to go above one million.
 * 
 * 
 * 
 * @author nandakri
 *
 */
public class Problem14 {

    static final int END = 1000000; // 1 million
    
    /**
     * @param args
     */
    public static void main(String[] args) {      
        
        long max = 0; // maximum number of terms 
        int nMax = 0; // the starting number
        
        for (int i=END-1; i>0;--i) {
            
            long termCount = 0L;
            long n = i;
            while (n > 1) {
                ++termCount;
                if (n % 2L == 0) {
                    n /= 2;
                } else {
                    n = 3L * n + 1; 
                }
            }
            if (termCount > max) {
                max = termCount + 1L;
                nMax = i;
            }
        }
        System.out.println(nMax);
    }

}
