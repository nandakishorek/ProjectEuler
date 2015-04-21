package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Work out the first ten digits of the sum of the following one-hundred
 * 50-digit numbers.
 * 
 * @author nandakri
 *
 */
public class Problem13 {

    static final int N = 100; // 100 numbers
    static final int D = 50; // number of digits in each number

    public static void main(String[] args) {

        char[] output = new char[50]; // does not include carry

        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                Problem11.class.getClassLoader().getResourceAsStream(
                        "problem13_data.txt")))) {
            char[][] data = new char[N][D];
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                data[i++] = line.toCharArray();
            }

            int k = 0;
            int carry = 0;
            for (i = D - 1; i >= 0; --i) {
                // start from units place
                // sum up the digits of the numbers in that place
                int sum = carry;
                for (int j = 0; j < N; ++j) {
                    // convert char to int and then add
                    sum += (data[j][i] - '0');
                }
                carry = sum / 10;
                output[k++] = (char) ((sum % 10) + '0');
            }

            // output digits in the carry if any
            int carryDigits = 0;
            if (carry > 0) {
                if (carry / 10 > 0) {
                    // 2 digit carry, max = 99
                    ++carryDigits;
                    System.out.print(carry / 10);
                }
                ++carryDigits;
                System.out.print(carry % 10);
            }

            for (i = 1; i <= (10 - carryDigits); ++i) {
                // since the higher order digits are in the higher indices of the ouput array
                // start printing from the last index
                System.out.print(output[D - i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
