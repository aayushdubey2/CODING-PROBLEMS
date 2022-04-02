package com.problems.solutions.array;

import java.util.ArrayList;

//Time: O(N)
//Space: O(1)

public class StockBuyOrSell {
    public static int maximumProfit(ArrayList<Integer> prices){
        int minimal = prices.get(0);
        int profit =0;
        for(int i =1;i<prices.size();i++){
            // find min value till now
            // is current value - min value the max profit?
            minimal = Math.min(minimal,prices.get(i));
            profit = Math.max(profit, prices.get(i)-minimal);
        }
        return profit;
    }
}
