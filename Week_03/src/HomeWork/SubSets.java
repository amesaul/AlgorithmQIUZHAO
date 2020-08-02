package HomeWork;

import java.util.ArrayList;
import java.util.List;

public class SubSets {
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		subsetsRecur(0,nums,new ArrayList<Integer>(),result);
		return result;
	}

	private void subsetsRecur(int i, int[] nums, ArrayList<Integer> subset, List<List<Integer>> result) {
		if (i==nums.length){
			result.add(subset);
			return;
		}
		subsetsRecur(i+1,nums,new ArrayList<>(subset),result);
		subset.add(nums[i]);
		subsetsRecur(i+1,nums,subset,result);
	}
}
