/**
 * 
 */
package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * Using names.txt (right click and 'Save Link/Target As...'), a 46K text file
 * containing over five-thousand first names, begin by sorting it into
 * alphabetical order. Then working out the alphabetical value for each name,
 * multiply this value by its alphabetical position in the list to obtain a name
 * score.
 * 
 * For example, when the list is sorted into alphabetical order, COLIN, which is
 * worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. So, COLIN
 * would obtain a score of 938 × 53 = 49714.
 * 
 * What is the total of all the name scores in the file?
 * 
 * @author nandakri
 *
 */
public class Problem22 {

    /**
     * @param args
     */
    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                Problem11.class.getClassLoader().getResourceAsStream(
                        "problem22_data.txt")))) {

            // read the names
            String[] names = br.readLine().split(",");

            // sort the names
            mergeSort(names, 0, names.length - 1);

            // calculate the sum of scores of all the names
            long sumOfScores = 0L;
            for (int i = 0; i < names.length; ++i) {
                int value = 0;
                for (int j = 1; j < names[i].length() - 1; ++j) {
                    value += (names[i].charAt(j) - 'A') + 1; // input has all
                                                             // upper-case chars
                                                             // and the string
                                                             // is within
                                                             // quotes, so skip
                                                             // first and last
                                                             // char
                }
                sumOfScores += value * (i + 1);
            }

            System.out.println("Sum of all scores = " + sumOfScores);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }

    public static void mergeSort(String[] data, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(data, low, mid);
            mergeSort(data, mid + 1, high);
            merge(data, low, mid, mid + 1, high);
        }
    }

    public static void merge(String[] data, int low1, int high1, int low2,
            int high2) {

        String[] temp = new String[high2 - low1 + 1];
        int k = 0;
        int p = low1;
        int q = low2;
        while (p <= high1 && q <= high2) {
            if (data[p].compareTo(data[q]) <= 0) {
                temp[k++] = data[p++];
            } else {
                temp[k++] = data[q++];
            }
        }

        while (p <= high1) {
            temp[k++] = data[p++];
        }
        while (q <= high2) {
            temp[k++] = data[q++];
        }

        // copy temp to input
        int i = low1;
        for (int j = 0; j < temp.length; ++j) {
            data[i++] = temp[j];
        }
    }
}
