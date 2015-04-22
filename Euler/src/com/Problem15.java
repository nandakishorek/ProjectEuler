/**
 * 
 */
package com;

/**
 * 
 * Starting in the top left corner of a 2×2 grid, and only being able to move to
 * the right and down, there are exactly 6 routes to the bottom right corner.
 * How many such routes are there through a 20×20 grid?
 * 
 * @author nandakri
 *
 */
public class Problem15 {

    static final int GRID_SIZE = 20;

    /**
     * Number of steps required to move from top-left to bottom-right =
     * GRID_SIZE * 2 = n
     * 
     * Number of routes = n C GRID_SIZE
     * 
     * @param args
     */
    public static void main(String[] args) {
        int n = GRID_SIZE * 2;
        
        double product = 1.0;
        for (int i = 0; i < GRID_SIZE; ++i) {
            product *= n;
            --n;
        }
        
        double fact = 1.0;
        int i = GRID_SIZE;
        while (i > 1) {
            fact *= i;
            --i;
        }
        
        System.out.printf("%.0f",(product/fact));
    }

}
