package HomeWork;

public class ChanceToBuyStock {
	public int maxProfit(int[] prices) {
		int result = 0;
		for (int i = 1 ; i<prices.length; ++i) {
			if (prices[i-1]<prices[i]) {
				result+=prices[i]-prices[i-1];
			}
		}
		return result;
	}
}
