class Solution {
    public int sumNumbers(TreeNode root) {

        return recursion(root, root.val);

    }

    private int recursion(TreeNode root, int value) {
        if(root.left == null && root.right == null) {
            return value;
        }
        int left = 0;
        int right = 0;
        if(root.left != null) {
            left = recursion(root.left, value * 10 + root.left.val);
        }

        if(root.right != null) {
            right = recursion(root.right, value * 10 + root.right.val);
        }

        return left + right;
    }


}