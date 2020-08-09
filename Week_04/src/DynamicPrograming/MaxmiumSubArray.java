package DynamicPrograming;

public class MaxmiumSubArray {
	public int maxSubArray(int[] nums) {
		int result = nums[0];
		int[] memo = new int[nums.length];
		for (int i = 1; i < nums.length; i++) {
			memo[i]=memo[i-1]>0?memo[i-1]+nums[i]:nums[i];
			result=Math.max(result,memo[i]);
		}
		return result;
	}
}
