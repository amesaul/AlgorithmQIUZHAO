package Day5;



public class ReverseBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        TreeNode process = root;
        reverse(process);
        return root ;
    }

    private void reverse(TreeNode process) {
//        terminator
        if (process==null)
            return;
//        current logic
        TreeNode temp = process.left;
        process.left = process.right;
        process.right = temp;
//        drillDown
        reverse(process.left);
        reverse(process.right);
    }
}
