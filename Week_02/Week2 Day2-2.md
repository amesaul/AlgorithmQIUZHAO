# 1.栈，队列，双端队列，优先队列
## 基础知识
### 1. 栈和队列的基本实现与特性
- 栈(stack)：一种先进先出的数据类型 FILO。
- 队列(queue) 一种先进后出的数据结构 FIFO。
- 其添加和删除的时间复杂度都为O(1).
- 双端队列(deque);
- stack的主要方法：
		
		/**
		* push()方法：向栈中放入一个元素。
		* pop()方法：将栈顶元素弹出栈，并返回最外元素的值。
		* peek()方法：获取栈顶元素的值而不对栈中元素进行操作。
		*/
		Stack<Integer> stack = new Stack<>();
		stack.push();
		stack.pop();
		stack.peek();
		
- queue的主要方法
		
		/**
		* offer()方法：向队列中加入元素。
		* poll()方法：队尾的元素弹出队列。
		* peek()方法：看一下队尾的元素
		*/
		Queue<String> queue = new LinkedList<String>();
		queue.offer();
		queue.poll();
		queue.peek();
		
		

- Deque的主要方法
		```
		Deque<String> deque = new LinkedList<String>();
		deque.push();
		deque.peek();
		deque.pop();
		```

| Operation | Queue | Deque |
| :-----: | :-----: | :-----: |  
| 添加元素到队尾 | add(E e)/ offer(E e) | addLast(E e) / offerLast(E e) |
| 取队首元素并删除 | E remove() / E poll() | E removeFirst() / E pollFirst() |
| 取队首元素但不删除 | E element() / E peek() | E getFirst() / E peekFirst() |
| 添加元素到队首|无|addFirst(E e) / offerFirst(E e) |
| 取队尾元素并删除|无|E removeLast() / E pollLast()|
| 取队尾元素但不删除|无|	E getLast() / E peekLast()|

- Tips 
1. deque用作queue时一般不用使用offer,poll,peek方法，使用offerLast,pollfirst,peekFirst方法。
2. deque用作stack时一般使用addFirst,removefirst,getfirst方法。

---
## 习题

- Valid Parentheses https://leetcode.com/problems/valid-parentheses/


        Stack<Character> stack = new Stack<Character>();
        for (Character c : s.toCharArray()) {
            if (c=='{')
                stack.push('}');
            else if (c=='[')
                stack.push(']');
            else if (c=='(')
                stack.push(')');
            else if (stack.isEmpty()||stack.pop()!=c)
                return false;
        }
        return stack.isEmpty();

- Min Stack https://leetcode.com/problems/min-stack/
	`
	    List<Integer> MajorStack;
	    List<Integer> MinStack;
	    
	    public MinStack() {
	        MajorStack = new ArrayList<>();
	        MinStack = new ArrayList<>();
	    }
	
	    public void push(int x) {
	        MajorStack.add(x);
	        if (MinStack.isEmpty()) MinStack.add(x);
	        else MinStack.add(Math.min(MinStack.get(MinStack.size()-1),x));
	    }
	
	    public void pop() {
	        MinStack.remove(MinStack.size()-1);
	        MajorStack.remove(MajorStack.size()-1);
	    }
	
	    public int top() {
	        return MajorStack.get(MajorStack.size()-1);
	    }
	
	    public int getMin() {
	
	        return  MinStack.get(MinStack.size()-1);
	    }
	 
 - 柱状图中的最大矩形 https://leetcode.com/problems/largest-rectangle-in-histogram/
 
	
	    public int largestRectangleArea(int[] heights) {
	        int maxArea = 0;
	        Stack<stackNode> stack = new Stack<>();
	        stack.push(new stackNode(-1, -1));
	        if(heights.length == 1 ) return heights[0]; 
	        for (int i = 0; i < heights.length; ++i) {
	            if (stack.peek().value == heights[i]){
	                stack.pop();
	                stack.push(new stackNode(heights[i],i));
	                continue;
	            }
	            if (stack.peek().value > heights[i]) {
	                do {
	                    stackNode temp = stack.pop();
	                    maxArea = Math.max(maxArea, temp.value * (i - 1 - stack.peek().index));
	                } while (stack.peek().value > heights[i]);
	            }
	            stack.push(new stackNode(heights[i], i));
	        }
	        while (stack.peek().value!=-1) {
	            stackNode temp = stack.pop();
	            maxArea = Math.max(maxArea, temp.value * (heights.length - 1 - stack.peek().index));
	        }
	        return maxArea;
	    }
	
	    private class stackNode {
	        int value;
	        int index;
	
	        public stackNode(int value, int index) {
	            this.value = value;
	            this.index = index;
	        }
	    }
	
- [ ]  明天试着用MostVotes方法解决。
