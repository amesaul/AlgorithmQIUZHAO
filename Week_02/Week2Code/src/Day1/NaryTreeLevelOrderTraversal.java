package Day1;

import java.util.ArrayList;
import java.util.List;

public class NaryTreeLevelOrderTraversal {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> levelOrder(Node root) {
        if (root!=null) recursionNode(root,0);
        return result;
    }
    private void recursionNode(Node root, int level){
        if (result.size()-1<level){
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);
        for (Node node : root.children){
            recursionNode(node,level+1);
        }
    }
}
