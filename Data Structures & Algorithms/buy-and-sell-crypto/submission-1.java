// key idea: we iterate over the array, keeping track of minPrice and maxProfit.
// we make sure minPrice is the smallest value in our array, so that when we calculate maxProfit,
// we subtract our current value by minPrice (small) to get the largest profits

// for example [5, 20, 1, 6]
// i = 0 -> minPrice = 5, maxProfit = 0.
// i = 1 -> minPrice = 5, maxProfit = 15.
// i = 2 -> minPrice = 1, maxProfit = 15 
// i = 3 -> minPrice = 1, maxProfit = 15 (6 - 1 = 5 is not greater than 15)
// finally, we return maxProfit = 15, which is correct.

// time complexity: O(n)
// space complexity: O(1);



class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 0; i < prices.length;  i++) {
            int profit = prices[i] - minPrice;
            
            if (profit > maxProfit) {
                maxProfit = profit;
            }

            if (minPrice > prices[i]) {
                minPrice = prices[i];
            }

        }
        
        return maxProfit;
    }
}
