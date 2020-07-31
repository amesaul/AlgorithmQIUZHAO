package DFSandBFS;

import java.util.*;

public class LevelOrderWithBFS {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if (root==null) return result;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()){
			int	size = queue.size();
			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				list.add(node.val);
				if (node.left!=null)
					queue.offer(node.left);
				if (node.right!=null)
					queue.offer(node.right);
			}
			result.add(list);
		}
		return result;
	}
}
