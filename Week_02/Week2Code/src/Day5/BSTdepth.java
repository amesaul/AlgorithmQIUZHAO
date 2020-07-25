package Day5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BSTdepth {
    List<Integer> result = new ArrayList<Integer>();
    public int maxDepth(TreeNode root) {

        depth(root,1);
        return Collections.max(result);
    }
    private void depth(TreeNode root,int depth) {
        if(root == null) {
            result.add(depth-1);
            return;
        }
        depth(root.left,depth+1);
        depth(root.right,depth+1);
    }
}
