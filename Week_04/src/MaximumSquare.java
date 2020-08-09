public class MaximumSquare {
	public int maximalSquare(char[][] matrix) {
//		定义dp[i][j] 表示以(i,j)为角的最大正方形的面积
//		if matrix==0 -> dp[i][j]=0;
//		else 根据 dp[i-1][j-1]的值决定dp[i][j]的值。
		if (matrix==null||matrix.length==0) return 0;
		int result = 0;
		int[][] dp = new int[matrix.length+1][matrix[0].length+1];
		for (int i = 1; i <=matrix[0].length;++i) {
			for (int j = 1;j<=matrix.length;++j) {
				if (matrix[i-1][j-1]=='0')
					dp[i][j]=0;
				else dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1;
				result = Math.max(result,dp[i][j]*dp[i][j]);
			}
		}
		return result;
 	}
}
