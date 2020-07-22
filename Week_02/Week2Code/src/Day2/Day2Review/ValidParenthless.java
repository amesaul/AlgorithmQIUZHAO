package Day2.Day2Review;

import java.util.Stack;

public class ValidParenthless {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
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
    }
}
