package DailyWorking.BinarySearch.Greedy;

public class JumpGame2 {
	public int jump(int[] nums) {
		int canReach = nums.length-1;
		int count = 0;
		int index = nums.length-2;
		int minCount = index;
		while (canReach>=0){
			while (index>=0){
				if (nums[index]+index>=canReach)
				minCount = index;
				index--;
			}
			canReach=minCount;
			count++;
		}
		return count;
	}

	public static void main(String[] args) {
		int[] nums = {2,3,1,1,4};
		JumpGame2 j = new JumpGame2();
		j.jump(nums);
	}
}
