package DailyWorking.BinarySearch.DFSandBFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeRowLargestWithBFS {
	public List<Integer> largestValues(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int maxInteger = Integer.MIN_VALUE;
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				maxInteger = Math.max(maxInteger,node.val);
				if (node.left!=null) {
					queue.offer(node.left);
				};
				if (node.right!=null) {
					queue.offer(node.right);
				};
			}
			list.add(maxInteger);
		}
		return list;
	}
}
