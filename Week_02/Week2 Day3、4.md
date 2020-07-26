# Week2 Day3
## 1.习题复习
1. Valid Parentheses https://leetcode.com/problems/valid-parentheses/
2. Min Stack https://leetcode.com/problems/min-stack/
3. 柱状图中的最大矩形 https://leetcode.com/problems/largest-rectangle-in-histogram/
4. 滑动窗口最大值 https://leetcode-cn.com/problems/sliding-window-maximum/submissions/
5. 设计循环双端队列 https://leetcode-cn.com/problems/design-circular-deque/
6. 接雨水 https://leetcode.com/problems/trapping-rain-water/

#Week2 Day4
## 1.堆相应习题的联系

- 最小的K个数 https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/

	    public int[] getLeastNumbers(int[] arr, int k) {
	        Queue<Integer> queue = new PriorityQueue<>();
	        int[] result = new int[k];
	        for (int i = 0; i < arr.length; i++) {
	            queue.offer(arr[i]);
	        }
	        for (int i = 0; i < k; i++) {
	            result[i] = queue.poll();
	        }
	        return result;
	    }

- 滑动窗口最大值 https://leetcode-cn.com/problems/sliding-window-maximum/

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

测试了一下，超出时间限制。

- 前K个高频元素 https://leetcode-cn.com/problems/top-k-frequent-elements/

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

