package DynamicPrograming;

public class HorseRobber {
	public int rob(int[] nums) {
		int prev = 0;
		if (nums.length==0||nums==null)return prev;
		int curr = nums[0];
		int next = 0;
		for (int i = 2 ; i < nums.length+1;++i){
			next = Math.max(curr,prev+nums[i-1]);
			prev = curr;
			curr = next;
		}
		return curr;
	}

	public static void main(String[] args) {
		HorseRobber hr = new HorseRobber();
		int[] nums ={1,2,3,1};
		hr.rob(nums);
	}
}
// 定义状态f(i) 表示 1...i个房子所能打劫的最大金额
// 若 第i个房屋没有打劫 则打劫房子的最大值为：f(i-1);
// 若 第i个房屋打劫了 ，则第i-1个房屋必没有打劫 此时 即为f(i-2)+nums[i];
// 则 此时状态方程 dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);

