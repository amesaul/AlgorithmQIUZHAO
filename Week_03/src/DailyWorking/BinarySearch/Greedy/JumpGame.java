package DailyWorking.BinarySearch.Greedy;

public class JumpGame {
	public boolean canJump(int[] nums) {
		int canReach = nums.length-1;
		for (int i = nums.length-2 ; i >=0 ; --i){
			if (nums[i]+i>=canReach)
				canReach=i;
		}
		return canReach==0?true:false;
	}
}
