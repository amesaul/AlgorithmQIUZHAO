package DailyWorking.BinarySearch.Greedy;

public class BestTimeStock {
	public int maxProfit(int[] prices) {
		int profit = 0;
		for (int i = 0 ; i < prices.length ; ++i) {
			if (prices[i]>prices[i-1])
				profit+=prices[i]-prices[i-1];
		}
		return profit;
	}
}
