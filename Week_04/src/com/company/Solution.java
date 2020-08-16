package com.company;

import java.util.*;

public class Solution {
	public int countBinarySubstrings(String s) {
//		dp[i] 表示以i为结尾，符合要求的数字个数
		if (s.length()==0) return 0;
		int n  = s.length();
		int[] dp = new int[n];
		int result = 0;
		for (int i = 1; i < n;++i) {
			if (s.charAt(i)!=s.charAt(i-1)) {
				dp[i]=1;
				result++;
			}
			else {
				if (dp[i-1]==0||i-2*dp[i-1]-1>0&&s.charAt(i)!=s.charAt(i-2*dp[i-1]-1)){
					dp[i]=dp[i-1]+1;
					result++;
				}
				else dp[i]=0;
			}
		}
		return result;
	}

}
