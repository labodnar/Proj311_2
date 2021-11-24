package com.company.Proj311_2;
import java.util.Vector;

/*
COSC 311, FALL 2021
DYNAMIC PROGRAMMING

Given coin denominations, find the shortest sequence of coins that add to a given target sum.
Builds the DP Table
 */


public class DPTable {
    int R; // R is length, not last index, so decrement
    int C;
    int[][] arr;
    int[] coins;
    Vector<Integer> v = new Vector<>();
    int currRow, currCol;

    public void findSequence() {
        v.clear();
        currRow = R - 1; // R is length, not last index, so decrement
        currCol = C - 1;
        if (arr[currRow][currCol] == 0) {
            System.out.println("Sequence not reachable with current coins");
            return;
        }

        while(true) {
            int c = getCoin();
            v.add(c);
            currCol = currCol - c;
            if (currCol <= 0) return;
        }
    }

    public String vString() {
        String v = this.v.toString();
        int max_len = 100;
        if (v.length()>max_len) v = v.substring(0, max_len);
        return v;
    }



    private int getCoin (){
        while (currRow > 0) {
            boolean isSame = arr[currRow][currCol] == arr[currRow-1][currCol];
            if (isSame) currRow--;
            else return coins[currRow];
        }
        return coins[0];
    }



    public long makeTable(int[] coins, int targetSum) {
        long runTime = System.currentTimeMillis();

        C = targetSum + 1;
        R = coins.length;
        arr = new int[R][C];
        int rem, n_above, n_left, n, c2;

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {

                if (r == 0) { // first row
                    rem = c % coins[r];
                    if (rem == 0) { // divides evenly
                        arr[r][c] = c / coins[r];
                    } else { //  divide UN-evenly
                        arr[r][c] = 0;
                    }
                }

                else { // main
                    n_left = 0;
                    n_above = arr[r - 1][c];
                    c2 = c - coins[r];
                    boolean in_bounds = c2 >= 0;
                    if (in_bounds) n_left = arr[r][c2];

                    if (!in_bounds) n = n_above;
                    else if (c2==0) n = 1;
                    else if (n_left == 0) n = n_above;
                    else if (n_above == 0 ) n = n_left + 1;
                    else n = Math.min(n_above, n_left + 1);

                    arr[r][c] = n;

                }

            } // end c

        } // end r
        runTime = System.currentTimeMillis()-runTime;
        this.coins = coins;
//        System.out.println("Run time: " + runTime);
        return runTime;
    }  // end method



    public void print() {
        if (C > 100) return;
        String s = "-";
        String counterStr = "";
        for (int i = 0; i < C; i++) counterStr += i + "\t";
        System.out.print("\n\nCoins" + "\t" + counterStr);
        System.out.println();
        System.out.println(s.repeat(75));

        for (int r = 0; r < R; r++) {

            System.out.print(coins[r] + "\t\t");
            for (int c = 0; c < C; c++) {
                System.out.print(arr[r][c] + "\t");
            }
            System.out.println();
        }
        System.out.println();
        findSequence();
        System.out.println("Shortest Sequence: " + v);
    }

} // end class
