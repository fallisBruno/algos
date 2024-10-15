package com.algorithms.algo.solutions.easy;

public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        System.out.println(getProfitII(new int[]{7,1,5,3,6,4}));
    }

    public static int getProfitII(int[] prices){
        if(prices.length <= 1) return 0;
        int minIndex = 0;
        int profit = 0;
        for (int index = 1; index < prices.length; index++) {
            if(prices[index - 1] < prices[minIndex])
                minIndex = index - 1;
            if(index > minIndex && prices[index] - prices[minIndex] > profit){
                profit = prices[index] - prices[minIndex];
            }
        }
        return profit;
    }

    public static int getProfit(int[] prices){
        if(prices.length <= 1) return 0;
        int minIndex = 0;
        int maxIndex = 1;
        int profit = 0;
        for (int index = 1; index < prices.length; index++) {
            if(prices[index] >= prices[maxIndex])
                maxIndex = index;
            if(prices[index - 1] <= prices[minIndex])
                minIndex = index - 1;
            if(maxIndex > minIndex && prices[maxIndex] - prices[minIndex] > profit)
                profit = prices[maxIndex] - prices[minIndex];
        }

        return profit;
    }

}
