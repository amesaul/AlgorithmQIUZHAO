package Day5;

public class ValidBST {
    public boolean isValidBST(TreeNode root) {
        return isValid(root,null,null   );
    }

    private boolean isValid(TreeNode root, Integer lowerBound, Integer upperBound) {
        if (root==null) return true;
        if (lowerBound!=null&&root.val<lowerBound)
            return false;
        if (upperBound!=null&&root.val>upperBound)
            return false;
        return isValid(root.left,lowerBound,root.val)&&
        isValid(root.right,root.val,upperBound);
    }


}
