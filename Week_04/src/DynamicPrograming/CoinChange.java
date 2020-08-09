package DynamicPrograming;

import java.util.Arrays;
import java.util.IllegalFormatCodePointException;

public class CoinChange {
	public int coinChange(int[] coins, int amount) {
		int[] memo = new int[amount+1];
		memo[0] = 0 ;
		Arrays.fill(memo,1,amount+1,Integer.MAX_VALUE);
		for (int coin :coins) {
			memo[coin] = 1;
		}
		for (int i = 1 ; i < amount+1;++i) {
			if (memo[i]!=Integer.MAX_VALUE) continue;
			for (int coin :coins){
				if (i-coin<0||memo[i-coin]==Integer.MAX_VALUE) continue;
				memo[i] = Math.min(memo[i-coin],memo[i]);
			}
		 	 if (memo[i]!=Integer.MAX_VALUE) memo[i]++;
		}
		return memo[amount]==Integer.MAX_VALUE?-1:memo[amount];
	}
}
