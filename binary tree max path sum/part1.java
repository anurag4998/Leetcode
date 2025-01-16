/**
For each of these nodes we can imagine a path which consists of the root and it's children. Even for a leaf node although the left and right remains null, we can still imagine a path sum which will consist just of the root value. For each node the path sum will be root.val + root.left.val + root.right.val.

From every node we have to return a value which will either be the root.val + root.left.val or root.val + root.right.val, whichever is greater. Since this will help in calculating the maximum path sum for all the subsequent parent nodes.

We can keep a variable which would hold the maximum value and then just return this value after recursion is completed.

One thing to note is if any of the children either the left or right return a negative value, we should not add it to the sum since negative values will only reduce the maximum possible sum achieved at that node.

 */
class Solution {
    private int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        recursion(root);
        return maxSum;
    }

    private int recursion(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int left = recursion(root.left);
        int right = recursion(root.right);

        if(left < 0) {
            left = 0;
        }

        if(right < 0) {
            right = 0;
        }

        int currSum = root.val + left + right;
        if(maxSum < currSum) {
            maxSum = currSum;
        }

        return root.val + Math.max(left, right);
    }
}