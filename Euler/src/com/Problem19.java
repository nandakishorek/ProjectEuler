/**
 * 
 */
package com;

/**
 * 
 * You are given the following information, but you may prefer to do some
 * research for yourself.
 * 
 * 1 Jan 1900 was a Monday. Thirty days has September, April, June and November.
 * All the rest have thirty-one, Saving February alone, Which has twenty-eight,
 * rain or shine. And on leap years, twenty-nine. 
 * A leap year occurs on any year
 * evenly divisible by 4, but not on a century unless it is divisible by 400.
 * 
 * How many Sundays fell on the first of the month during the twentieth century
 * (1 Jan 1901 to 31 Dec 2000)?
 * 
 * @author nandakri
 *
 */
public class Problem19 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        
        int[] oddDays = {3, 0, 3, 2, 3, 2 , 3, 3, 2, 3, 2, 3}; // for every month
        
        int sunCount = 0; // total number of sundays which fell on the first of a month
        
        int oddDayCount = 0;
        for (int y = 1901; y < 2001; ++y) {
            
            // calculate the number of odd days for feb in year 'y'
            if (y % 400 == 0 || (y % 4 == 0 && y % 100 != 0)) {
                oddDays[1] = 1; // leap year
            } else {
                oddDays[1] = 0; // leap year
            }
            
            for (int m = 0; m < oddDays.length; ++m) {
                oddDayCount += oddDays[m];
                if (oddDayCount % 7 == 5) {
                    // since 1900 was not a leap year, number of days in 1901 = 365, number of odd days = 365 % 7 = 1
                    // So 1st Jan 1901 was a Tuesday
                    // So every 5th odd day will be a Sunday
                    ++sunCount;
                }
            }
        }
        
        System.out.println(sunCount);
    }

}
