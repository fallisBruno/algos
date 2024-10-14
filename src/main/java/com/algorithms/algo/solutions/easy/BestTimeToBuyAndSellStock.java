package com.algorithms.algo.solutions.easy;

public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        System.out.println(getProfit(new int[]{2,1,2,1,0,1,2}));
    }

    public static int getProfit(int[] prices){
        if(prices.length <= 1) return 0;
        int minIndex = 0;
        int maxIndex = 1;
        int index = 0;
        int profit = 0;
        while(index < prices.length){
            if(prices[index + 1] > prices[maxIndex])
                maxIndex = index + 1;
            if(prices[index] < prices[minIndex])
                minIndex = index;
            index++;
            if(maxIndex > minIndex && prices[maxIndex] - prices[minIndex] > profit)
                profit = prices[maxIndex] - prices[minIndex];
        }
        return profit;
    }

}
