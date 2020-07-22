package Day3.Review;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k==1) return nums;
        Deque<Integer> deque = new LinkedList<>();
        int[] result =new int[nums.length-k+1];

        for (int i = 0 ; i < nums.length ; ++i) {
            while (!deque.isEmpty()&&nums[deque.peekFirst()]< nums[i] ) {
                deque.pollFirst();
            }
            deque.addFirst(i);
            if (i>=k-1) {
                if (deque.peekLast()>i-k+1) result[i-k+1] = nums[deque.peekLast()];
                else result[i-k+1] = nums[deque.pollLast()];
            }
        }
        return result;
    }
}

