class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        // curNotBuy -> It represents we are currently selling the share
        // curBuy -> It represents we are currently buying the share
        // aheadNotBuy -> It represents ahead selled share
        // aheadbuy -> It represents ahead buyed share

        int curNotBuy, curBuy, aheadBuy, aheadNotBuy;

        aheadNotBuy = aheadBuy = 0;

        for(int ind=n-1;ind>=0;ind--){
            //sell
            curNotBuy = Math.max(prices[ind] + aheadBuy, 0 + aheadNotBuy);

            //buy
            curBuy = Math.max(-prices[ind] + aheadNotBuy, 0 + aheadBuy);

            aheadNotBuy = curNotBuy;
            aheadBuy = curBuy;
        }
        return aheadBuy;
    }
}