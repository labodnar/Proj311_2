package com.company.Proj311_2;
 /*
COSC 311, FALL 2021
DYNAMIC PROGRAMMING

Given coin denominations, find the shortest sequence of coins that add to a given target sum.
This is the (slow) Brute Force solution the DP results will be compared to

 *** Requires four coin values for this analysis.
*/

import java.util.Vector;

public class BruteForce {
    Vector<Integer> v = new Vector<>();

    public long bfCombos(int[] coins, int targetSum) {
        long runTime = System.currentTimeMillis();
        int[] max_index_arr = new int[coins.length]; // holds the max index of each coin in coin_arr (this is known)

        for (int i = 0; i < max_index_arr.length; i++) { // Initialize limits
            max_index_arr[i] = targetSum / coins[i];
        }

        int min_num_coins = 999999;
        int[] solution_numbers = new int[4];
        for (int i = 0; i <= max_index_arr[0]; i++) {
            for (int j = 0; j <= max_index_arr[1]; j++) {
                for (int k = 0; k <= max_index_arr[2]; k++) {
                    for (int l = 0; l <= max_index_arr[3]; l++) {
                        int sum = i * coins[0] + j * coins[1] + k * coins[2] + l * coins[3];
                        if (sum == targetSum) {
                            int num_coins = i + j + k + l;
                            if (num_coins < min_num_coins) {
                                min_num_coins = num_coins;
                                solution_numbers[0] = i;
                                solution_numbers[1] = j;
                                solution_numbers[2] = k;
                                solution_numbers[3] = l;
                            }
                        }
                    }
                }
            }
        }

        runTime = System.currentTimeMillis() - runTime;
//        System.out.println("BF time: " + runTime);

        return runTime;
    } // end num_combos2


} // end class

