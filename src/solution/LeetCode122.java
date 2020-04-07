package solution;

public class LeetCode122 {
    public int maxProfit(int[] prices) {
        int profit = 0;
        boolean bought = false;

        int length = prices.length - 1;
        int date=0;
        int buyPrice = 0;
        while(date < length) {

            if (bought) {
                while ((prices[date] <= prices[++date]) && (date < length)) {
                }

                if(date >= length && prices[date-1] <= prices[date]){
                    bought = false;
                    profit += prices[length] - buyPrice;
                }else{
                    bought = false;
                    profit += prices[date -1] - buyPrice;
                }
            } else {
                while ((prices[date] >= prices[++date]) && (date < length)) {
                }

                if(date >= length && prices[date-1] >= prices[date]){
                    break;
                }else{
                    bought = true;
                    buyPrice = prices[date - 1];
                }
            }
        }

        if(bought){
            profit += prices[length] - buyPrice;
        }

        return profit;
    }
}
