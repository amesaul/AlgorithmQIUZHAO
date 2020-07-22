package Day2.Day2Review;

import java.util.Stack;

public class LargestRectangleArea {
    public static void main(String[] args) {
        int[] input = {1,1};
        LargestRectangleArea l = new LargestRectangleArea();
        System.out.println(l.largestRectangleArea(input));
    }
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
}
