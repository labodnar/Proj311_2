package com.company.Proj311_2;
import java.util.Arrays;
public class Driver {

/*
COSC 311, FALL 2021
DYNAMIC PROGRAMMING

Given coin denominations, find the shortest sequence of coins that add to a given target sum.
Driver Class that exercises the DP model
 */


    public static void main(String[] args) {

        boolean BATCH_RUN = true;

        int[] coins = {2, 5, 7, 9};
        int targetSum = 33;
        long tDynProg, tBruteForce;
        String s = "";
        String s2 = "";
        int j;

        BFTable table = new BFTable();
        BruteForce bruteForce = new BruteForce();

        if (!BATCH_RUN) {
            tDynProg = table.makeTable(coins, targetSum);
            table.print();
        }

        else { // BATCH PROCESSING

            System.out.println("\n\nCoins: " + Arrays.toString(coins));
            System.out.println("\tSums\tTimes\t\t" + "Shortest sequence");
            String s_dash = "-";
            System.out.println(s_dash.repeat(100));

            for (int i = 10; i < 16; i+=1) {
                tDynProg = table.makeTable(coins, i);
                table.findSequence();
                tBruteForce = bruteForce.bfCombos(coins, i);
                s = "\t" + i + ":" + "\t";
                s2 = "\t\t" + table.v;
                System.out.print(s + tDynProg + ", " + tBruteForce + s2 + "\n");
            }
        }
    }

} // end class
