package DynamicPrograming;

import java.util.ArrayList;
import java.util.List;

public class uniquePathesWithRecursion {
	public int uniquePaths(int m, int n) {
		int[][] memo = new int[m+1][n+1];
		return dp(m,n,memo);
	}

	private int dp(int i, int j, int[][] memo) {
		if (i==1||j==1) return 1;
		if (memo[i][j]!=0) return memo[i][j];
		memo[i][j] = dp(i-1,j,memo)+dp(i,j-1,memo);
		return memo[i][j];
	}
}
