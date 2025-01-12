/*
We are given a binary tree and each path from root to a leaf represents a number, we have to find the sum of all such numbers and return it.

We can travel in the tree in a recursive fashion, and as soon as we reach a leaf node we should return the number formed at that point.

As we travel from root to the leaf nodes, we can pass the value of root at each point, to generate our numbers, just multiply the number with
10 and add the next root value into the number, this way we can generate the numbers on the fly.

A recursion from root to bottom would look like 4 -> 4*10 + 9 -> 49*10 + 5 -> 495, return this value once we reach the leaf node.
*/

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