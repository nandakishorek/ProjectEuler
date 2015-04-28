/**
 * 
 */
package com;

/**
 * If the numbers 1 to 5 are written out in words: one, two, three, four, five,
 * then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
 * 
 * If all the numbers from 1 to 1000 (one thousand) inclusive were written out
 * in words, how many letters would be used?
 * 
 * NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and
 * forty-two) contains 23 letters and 115 (one hundred and fifteen) contains 20
 * letters. The use of "and" when writing out numbers is in compliance with
 * British usage.
 * 
 * @author nandakri
 *
 */
public class Problem17 {

    /**
     *  I could have counted the number of groups  of (1 to 9), (11-19), "and", etc.
     *  But I'm very lazy to do that :)
     *  
     * @param args
     */
    public static void main(String[] args) {

        String[] units = { "dummy", "one", "two", "three", "four", "five",
                "six", "seven", "eight", "nine", "ten", "eleven", "twelve",
                "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
                "eighteen", "nineteen" }; // primitives
        String[] tens = { "dummy", "dummy", "twenty", "thirty", "forty",
                "fifty", "sixty", "seventy", "eighty", "ninety" };

        int totalNumLetters = 0;
        for (int i = 1; i <= 1000; ++i) {
            if (i < 20) {
                totalNumLetters += units[i].length(); // 1 to 19
            } else if (i > 999) {
                totalNumLetters += 11; // length of "one thousand"
            } else {
                int unitsPlace = i % 10;
                int tensPlace = (i % 100) / 10;
                int hundredsPlace = i / 100;

                if (tensPlace > 1) {
                    // 20 and above
                    totalNumLetters += tens[tensPlace].length();
                    
                    if (unitsPlace > 0) {
                        totalNumLetters += units[unitsPlace].length();
                    }
                } else if (tensPlace == 1) {
                    // ten to nineteen, if there is an hundred's place
                    totalNumLetters += units[i % 100].length();
                } else {
                    // ten's place is zero
                    if (unitsPlace > 0) {
                        totalNumLetters += units[unitsPlace].length();
                    }
                }

                if (hundredsPlace > 0) {
                    totalNumLetters += units[hundredsPlace].length() + 7; // ex. one hundred

                    if (tensPlace > 0 || unitsPlace > 0) {
                        totalNumLetters += 3; // for "and"
                    }
                }
            }
        }

        System.out.println(totalNumLetters);
    }
}
