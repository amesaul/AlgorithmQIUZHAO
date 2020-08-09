package DynamicPrograming;

public class EditDistance {
	public int minDistance(String word1, String word2) {
//		定义dp[i][j] 表示 i个字符的word1与j个字符word2最少需要几次变换：
//		dp[0][j] = j;
//		dp[i][0] = i;
//		dp[i][j] = dp[i-1][j-1] if word1[i]==word[j];
//		else dp[i][j] = 1 + (dp[i-1][j-1],dp[i][j-1],dp[i-1][j])
		if (word1==null) return word2.length();
		if (word2==null) return word1.length();
 		int[][] dp = new int[word1.length() + 1][word2.length() + 1];
		for (int i = 0; i <= word1.length(); ++i) {
			for (int j = 0; j <= word2.length(); ++j) {
				if (i == 0)
					dp[0][j] = j;
				else if (j == 0)
					dp[i][0] = i;
				else if (word1.charAt(i-1)==word2.charAt(j-1))
					dp[i][j] = dp[i-1][j-1];
				else dp[i][j] = 1 + Math.min(Math.min(dp[i-1][j-1],dp[i][j-1]),dp[i-1][j]);
			}
		}
		return dp[word1.length()][word2.length()];
	}
}
