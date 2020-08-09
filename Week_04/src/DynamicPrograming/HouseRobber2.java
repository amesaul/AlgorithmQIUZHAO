package DynamicPrograming;

import java.util.Arrays;

public class HouseRobber2 {
	public int rob(int[] nums) {
		return Math.max(horseRobber(Arrays.copyOfRange(nums,0,nums.length-1)),horseRobber(Arrays.copyOfRange(nums,1,nums.length)));
	}

	private int horseRobber(int[] nums) {
		int prev = 0;
		if (nums.length==0||nums==null)
			return prev;
		int curr = nums[0];
		int next = 0;
		for (int i = 2 ; i < nums.length+1;++i){
			next = Math.max(curr,prev+nums[i-1]);
			prev = curr;
			curr = next;
		}
		return curr;
	}
}
