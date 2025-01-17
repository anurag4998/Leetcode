/*
The question basically asks us to find the maximum sum. We can generate while iterating over the array. We have a condition though, we cannot add values from two succcesive indices.

For eg: - [1,2,3,1] -> max sum that can be generated is by summing up values at index 0 and index 2.
One way is to try all possible combinations from all indices, this can be done via recursion.
At every index we can either decide to include that element for the summation or we can proceed to the next.
If we decide on including the element, we should jump to the next index which we can include in the sum which is index + 2.

So the recursive approach would essentially return Math.max( (nums[index] + recursion(index + 2, nums)), recursion(index + 1, nums)).

This approach however ends up consuming a lot of time because of a lot of repetitive calculation, so we are bound to get TLE for huge test cases.
*/

class Solution {
    public int rob(int[] nums) {
        return recursion(0 , nums);
    }

    private int recursion(int index, int[] nums) {
        if(index >= nums.length) {
            return 0;
        }

        int take = nums[index] + recursion(index + 2, nums);
        int noTake = recursion(index + 1 , nums);

        return Math.max(take, noTake);
    }
}