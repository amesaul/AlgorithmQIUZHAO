package Day1;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inOrderiter(root,result);
        return result;
    }

    private void inOrderiter(TreeNode root, List<Integer> result) {
        if (root!=null){
            inOrderiter(root.left,result);
            result.add(root.val);
            inOrderiter(root.right,result);
        }
    }
}
