package Day4;

import java.util.*;

public class TopKFrequenceElement {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int[] result = new int[k];
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],(map.getOrDefault(nums[i],0)+1));
        }
        Queue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<Map.Entry<Integer,Integer>>((x1, x2)->(x2.getValue()-x1.getValue()));
        for (Map.Entry<Integer,Integer> entry : map.entrySet()){
            pq.offer(entry);
        }
        for (int i = 0; i < k; i++) {
            result[i] = pq.poll().getKey();
        }
        return result;
    }
}
