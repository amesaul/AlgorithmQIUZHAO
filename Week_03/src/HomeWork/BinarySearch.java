package HomeWork;

public class BinarySearch {
	public int myBinarySearch(int[] nums) {
		int begin = 0,end = nums.length-1,mid=0;
		while (begin<end) {
			mid = (begin+end)/2;
			if (nums[mid]>nums[end]) {
				begin = mid + 1;
			}else if (nums[mid]<nums[end]) {
				end = mid;
			}else break;
		}
		return nums[mid];
	}
}
