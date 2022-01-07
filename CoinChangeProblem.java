package com;

/**
 * Given a set of coins and amount, how many ways we can make the change of the
 * amount using the coins given. based on
 * https://www.geeksforgeeks.org/coin-change-dp-7/
 *
 * @author Ken Macharia <https://github.com/kmacharia>
 */
public class CoinChangeProblem {

    public static void main(String[] args) {
        int amount = 5;
        int coins[] = {1, 2, 3};
        System.out.println("Counting recursively = " + countRecursively(coins, coins.length, amount));        
        System.out.println("Counting using dynamic programming = " + countDynamicProgramming(coins, coins.length, amount));
    }

    static int countRecursively(int coins[], int typeOfCoins, int amount) {
        // If amount is 0, combination works and we have 1 solution  
        // (do not include any other coin coin) 
        if (amount == 0) {
            return 1;
        }

        // If amount is less than 0 then combination does not work
        if (amount < 0) {
            return 0;
        }

        // If there are no coins and amount  
        // is greater than 0, then combination would require another denomination that does not exist
        if (typeOfCoins <= 0 && amount > 0) {
            return 0;
        }

        // count is sum of solutions
        //(i) including coins[typeOfCoins-1]
        //(ii) excluding coins[typeOfCoins-1]
        return countRecursively(coins, typeOfCoins, amount - coins[typeOfCoins - 1])//give biggest denomination coin
                + countRecursively(coins, typeOfCoins - 1, amount);
    }
    
    static int countDynamicProgramming(int coins[], int typeOfCoins, int amount) {
        //subproblems wont be recomputed
        
        //table[i] stores number of solutions for value i
        int table[] = new int[amount+1];//amount+1 coz we need base case, amount = 0
        
        //1 way for amount=0, don't give change
        table[0] = 1;
        
        //pick all coins one by one and update the table[] values
        for(int i=0; i<typeOfCoins; i++){
            for(int j=coins[i]; j<=amount; j++){
                table[j] += table[j-coins[i]];
            }
        }
        return table[amount];
    }
}
