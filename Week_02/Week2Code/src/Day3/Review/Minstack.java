package Day3.Review;

import java.util.ArrayList;
import java.util.List;

class MinStack {

    /**
     * initialize your data structure here.
     */
    List<Integer> MajorValue;
    List<Integer> MinValue;

    public MinStack() {
        MajorValue = new ArrayList<>();
        MinValue = new ArrayList<>();
    }

    public void push(int x) {
        MajorValue.add(x);
        if (MinValue.isEmpty())
            MinValue.add(x);
        else MinValue.add(Math.min(x, MinValue.get(MinValue.size() - 1)));
    }

    public void pop() {
        MajorValue.remove(MajorValue.size() - 1);
        MinValue.remove(MinValue.size() - 1);
    }

    public int top() {
        return MajorValue.get(MajorValue.size() - 1);
    }

    public int getMin() {
        return MinValue.get(MinValue.size() - 1);
    }
}