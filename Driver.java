package com.company.Proj311_2;
import java.text.DecimalFormat;
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

        int[] coins = {3, 5, 7, 19};
        int targetSum = 33;
        long tDynProg, tBruteForce = 0;
        String s = "";
        String s2 = "";
        int j;
        DecimalFormat ft = new DecimalFormat("####,###");


        DPTable table = new DPTable();
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

            for (int i = 4; i < 1600000; i+=31) {

                tDynProg = table.makeTable(coins, i);
                table.findSequence();
                tBruteForce = bruteForce.bfCombos(coins, i);
                s = "\t" + ft.format(i) + ":" + "\t";
                s2 = "\t\t" + table.vString();
                System.out.print(s + tDynProg + ", " + tBruteForce + s2 + "\n");
            }
        }
    }

} // end class
