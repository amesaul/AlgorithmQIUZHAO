package Day3.Review;

import java.util.Stack;

public class LargestRectangle {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxValue = 0 ;
        for (int i = 0 ; i < heights.length ; ++i) {
            while (heights[stack.peek()]>heights[i]){
                int widthIndex = stack.pop();
                maxValue = Math.max(maxValue,heights[widthIndex]*(i-widthIndex));
            }
            stack.push(i);
        }
        while (stack.peek() != -1) {
            maxValue = Math.max(maxValue, heights[stack.pop()] * (heights.length - 1 - stack.peek()));
        }
        return maxValue;
    }
}
