public class MaxSumLowerThanK {
	public int maxSumSubmatrix(int[][] matrix, int k) {
	int rows =matrix.length;
	int cols = matrix[0].length;
	int max = Integer.MIN_VALUE;
	for (int l = 0; l<cols;l++) {
		int[] dp = new int[rows];
		for (int r=l;r<cols;r++){
			for (int i = 0;i<rows;++i){
				dp[i] +=matrix[i][r];
			}
			max=Math.max(max,dprow(dp,k));
		}
	}
	return max;
	}

	private int dprow(int[] arr, int k) {
		int rollSum = arr[0], rollMax = rollSum;
		// O(rows)
		for (int i = 1; i < arr.length; i++) {
			if (rollSum > 0) rollSum += arr[i];
			else rollSum = arr[i];
			if (rollSum > rollMax) rollMax = rollSum;
		}
		if (rollMax <= k) return rollMax;
		// O(rows ^ 2)
		int max = Integer.MIN_VALUE;
		for (int l = 0; l < arr.length; l++) {
			int sum = 0;
			for (int r = l; r < arr.length; r++) {
				sum += arr[r];
				if (sum > max && sum <= k) max = sum;
				if (max == k) return k; // 尽量提前
			}
		}
		return max;
	}
}






//		int result = Integer.MIN_VALUE;
//		int m = matrix.length;
//		int n = matrix[0].length;
//		int[][] dp = new int[m + 1][n + 1];
//		for (int i = 1; i <= m; ++i) {
//			for (int j = 1; j <= n; j++) {
//				dp[i][j]= matrix[i-1][j-1]+dp[i-1][j]+dp[i][j-1]-dp[i-1][j-1];
//				if (dp[i][j]<k)
//					result = Math.max(result,dp[i][j]);
//			}
//		}
//		return result;