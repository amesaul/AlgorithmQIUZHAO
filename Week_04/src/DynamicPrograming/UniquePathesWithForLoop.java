package DynamicPrograming;

import java.lang.reflect.Array;
import java.util.Arrays;

public class UniquePathesWithForLoop {
	public int uniquePaths(int m, int n) {
		int[] memo = new int[n+1];
		Arrays.fill(memo,1,n,1);
		for (int i = 1; i < m+1; i++) {
			for (int j = 1; j < n+1; j++) {
				memo[j]+=memo[j-1];
			}
		}
		return memo[n];
	}
}
