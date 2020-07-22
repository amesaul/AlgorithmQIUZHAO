package Day3.Review;

import java.util.Stack;

public class ValidParenthless {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (Character c : s.toCharArray()) {
            switch (c){
                case '{' : stack.push('}');
                    continue;
                case '[' : stack.push(']');
                    continue;
                case '(' : stack.push(')');
                    continue;
            }
            if (stack.isEmpty()||stack.pop()!=c)
                return false;
        }
        return stack.isEmpty();
    }
}
