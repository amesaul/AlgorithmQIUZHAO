public class DecodeWays {
		public int numDecodings(String s) {
	//		Analyze dp[i]的状态分析：
	//		如果 dp[i]>6&&dp[i-1]>2 此时证明没有可用的其余编码方式 dp[i]=dp[i-1];
	//		else dp[i] = dp[i-1]+dp[i-2];
			if(s.length()==0||s==null||s.equals("0")) return 0;
			int[] dp = new int[s.length()+1];
			dp[0] = 1;
			dp[1] = 1;
			for (int i = 2;i <=s.length();++i) {
				if (s.charAt(i-1)=='0') {
					if (s.charAt(i-2)<='2'&&s.charAt(i-2)!='0')
					dp[i] = dp[i - 2];
					else return 0;
				}
				else if (s.charAt(i-2)=='0'||10*(s.charAt(i-2)-'0')+(s.charAt(i-1)-'0')>26)
					dp[i]=dp[i-1];
				else dp[i] = dp[i-1]+dp[i-2];
			}
			return dp[s.length()];
		}
}
