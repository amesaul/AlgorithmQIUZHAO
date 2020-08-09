package DynamicPrograming;

public class ClimbingStairs {
	public int climbStairs(int n) {
		int[] memo = new int[n+1];
		memo[1] = 1;
		for (int i = 1; i < n+1; i++) {
			memo[i]=memo[i-1]+memo[i-2];
		}
		return memo[n];
	}
}
