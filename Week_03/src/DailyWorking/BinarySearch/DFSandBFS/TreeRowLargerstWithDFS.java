package DailyWorking.BinarySearch.DFSandBFS;

import java.util.ArrayList;
import java.util.List;

public class TreeRowLargerstWithDFS {
	public List<Integer> largestValues(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root == null) return result ;
		dfs(0,root,result);
		return result;
	}

	private void dfs(int level, TreeNode root, List<Integer> result) {
		if (level==result.size()){
			result.add(root.val);
		}
		result.set(level,Math.max(root.val,result.get(level)));
		if (root.left!=null) {
			dfs(level+1,root.left,result);
		}
		if (root.right!=null) {
			dfs(level+1,root.right,result);
		}
	}
}
