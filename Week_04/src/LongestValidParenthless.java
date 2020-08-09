import java.util.Stack;

public class LongestValidParenthless {
	public int longestValidParentheses(String s) {
		if (s==null||s.length()<2) return 0;
		int result = 0;
		int[] dp = new int[s.length()];
		Stack<Integer> stack = new Stack<>();
		if (s.charAt(0)=='(') stack.push(1);
		for (int i = 1; i <s.length();++i){
			if (s.charAt(i)=='(') {
				dp[i] = dp[i - 1];
				stack.push(1);
			}
			else if (s.charAt(i)==')'&&stack.isEmpty()) {
				dp[i] = 0;
				stack.clear();
			}else {
				dp[i] = dp[i - 1] + 2;
				stack.pop();
			}
		}
		int up = s.length()-1;
		int down = s.length()-1;
		while (!stack.isEmpty()){
			down = stack.pop();
			result = Math.max(result,up-down-1);
			up=down;
		}
		for (int i = 0;i<=down;++i){
			result = Math.max(result,dp[i]);
		}
		return result;
	}
}
