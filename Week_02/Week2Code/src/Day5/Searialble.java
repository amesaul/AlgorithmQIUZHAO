package Day5;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Searialble {
	private static final String spliter = ",";
	private static final String NN = "x";
	public String serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		bulidString(root,sb);
		return sb.toString();
	}

	private void bulidString(TreeNode node, StringBuilder sb) {
		if (node == null) {
			sb.append(NN).append(spliter);
		}else {
			sb.append(node.val).append(spliter);
			bulidString(node.left,sb);
			bulidString(node.right,sb);
		}
	}

	public TreeNode deserialize(String data) {
		Deque<String> nodes = new LinkedList<>();
		nodes.addAll(Arrays.asList(data.split(spliter)));
		return  buildTree(nodes);
	}

	private TreeNode buildTree(Deque<String> nodes) {
		String val = nodes.remove();
		if (val.equals(NN)) return null;
		else {
			TreeNode node = new TreeNode(Integer.valueOf(val));
			node.left = buildTree(nodes);
			node.right = buildTree(nodes);
			return node;
		}
	}
}
