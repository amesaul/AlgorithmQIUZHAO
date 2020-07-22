package Day2.Day2Review;


import java.util.ArrayList;
import java.util.List;

class MinStack {

    /**
     * initialize your data structure here.
     */
    List<Integer> MajorStack;
    List<Integer> MinStack;

    public MinStack() {
        MajorStack = new ArrayList<>();
        MinStack = new ArrayList<>();
    }

    public void push(int x) {
        MajorStack.add(x);
        if (MinStack.isEmpty()) MinStack.add(x);
        else MinStack.add(Math.min(MinStack.get(MinStack.size() - 1), x));
    }

    public void pop() {
        MinStack.remove(MinStack.size() - 1);
        MajorStack.remove(MajorStack.size() - 1);
    }

    public int top() {
        return MajorStack.get(MajorStack.size() - 1);
    }

    public int getMin() {

        return MinStack.get(MinStack.size() - 1);
    }

}

