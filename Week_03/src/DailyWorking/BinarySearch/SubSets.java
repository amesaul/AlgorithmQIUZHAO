package DailyWorking.BinarySearch;

import java.util.ArrayList;
import java.util.List;

public class SubSets {
	public  List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		recur(0, new ArrayList<Integer>(),nums,list);
		return list;
	}

	private void recur(int i, List<Integer> list, int[] nums,List<List<Integer>> result) {
		if (i==nums.length){
			System.out.println(list);
			result.add(list);
			return;
		}
		recur(i+1,new ArrayList<>(list),nums,result);
		list.add(nums[i]);
		recur(i+1,new ArrayList<>(list),nums,result);
		list.remove(list);
	}

	public static void main(String[] args) {
		int[] nums = {1,2,3};
		SubSets ss = new SubSets();
		ss.subsets(nums);
	}
}
