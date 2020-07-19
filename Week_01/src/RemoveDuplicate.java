public class RemoveDuplicate {

    public int removeDuplicates(int[] nums) {

        if (nums.length < 1) return 0;
        int newLength = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != nums[newLength]) {
                newLength++;
                nums[newLength] = nums[i];
            }
        }
        return newLength + 1;
    }
}
