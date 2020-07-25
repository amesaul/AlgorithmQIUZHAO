package Day4;

import java.util.PriorityQueue;
import java.util.Queue;

public class SlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Queue<Integer> heap = new PriorityQueue<>((x,y) ->(y-x));
        int[] result = new int[nums.length-k+1];
        for (int i = 0; i < nums.length; i++) {
            if (i>=k){
                 heap.remove(nums[i-k]);
            }
             heap.offer(nums[i]);
            if (heap.size()==k) {
                result[i-k+1]  = heap.peek();
            }
        }
        return result;
    }
}
