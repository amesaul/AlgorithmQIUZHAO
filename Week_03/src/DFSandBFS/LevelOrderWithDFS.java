package DFSandBFS;

import java.util.ArrayList;
import java.util.List;

public class LevelOrderWithDFS {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if (root==null) return result;
		bfs(root,0,result);
		return result;
	}

	private void bfs(TreeNode root, int level, List<List<Integer>> result) {
		if (level==result.size())
			result.add(new ArrayList<>());
		result.get(level).add(root.val);
		if (root.left!=null){
			bfs(root.left,level+1,result);
		}
		if (root.right!=null){
			bfs(root.right,level+1,result);
		}
	}
}
