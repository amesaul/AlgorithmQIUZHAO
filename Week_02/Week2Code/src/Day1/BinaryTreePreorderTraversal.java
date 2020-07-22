package Day1;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preOrderiter(root,result);
        return result;
    }

    private void preOrderiter(TreeNode root, List<Integer> result) {
        if (root!=null){
            result.add(root.val);
            preOrderiter(root.left,result);
            preOrderiter(root.right,result);
        }
    }
}
