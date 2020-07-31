import java.util.HashMap;
import java.util.Map;

public class MojorityElements {
	public int majorityElement(int[] nums) {
		Map<Integer,Integer> map = new HashMap<>();
		return recur(0,nums,map);
	}

	private int recur(int index, int[] nums, Map<Integer, Integer> map) {
		if (map.get(nums[index])>nums.length/2)
			return nums[index];
//		current logic
		map.put(nums[index],map.getOrDefault(nums[index],0)+1);
		return recur(index+1,nums,map);
	}
}
