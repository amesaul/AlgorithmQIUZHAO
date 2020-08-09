package DynamicPrograming;

public class MaximumProductSubArray {
	public int maxProduct(int[] nums) {
		int[] memo = new int[nums.length];
		int result = nums[0];
		int minus = nums[0];
		memo[0]=nums[0];
		for (int i =1 ; i < nums.length;++i) {
			if (memo[i-1]<=0)
				memo[i] = nums[i];
			memo[i] = memo[i-1]*nums[i];
			if (minus == 0)
				minus = nums[i];
			minus*=nums[i];
			result = Math.max(result,minus);
			result = Math.max(result,memo[i]);
		}
		return result;
	}
}
