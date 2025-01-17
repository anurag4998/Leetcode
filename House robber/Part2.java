/*
CACHING THE RECURSION STATES

On the right is the recursion tree for the example, the numbers in the circle represent the indices. The recursion tree shows the possible states we can end up throughout our recursion, based on different selections at each index.
On the right subtree from the root, we can see there are certain indices we end up coming back to, which
were already previously calculated( for ex 2 and 3). These are also colored for reference.

Instead of calculating the result of our recursive equation for these indices again, we can just store the result in an array of indices whenever we complete our recursion.
The next time we end up in a similar case, we can just reuse the result and return avoiding a need to recurse.
The impact might not be evident for a small case, but in huge structures we avoid significant calculations.

In our recursive equation there is only one variable which changes, i.e index.
Math.max( (nums[index] + recursion(index + 2, nums)), recursion(index + 1, nums)). Nums is a constant.
Since there is only one state which modifies, we can use a 1-D array to cache/ memoize our results.

Refer to video for diagram :- 
*/
class Solution {
    public int rob(int[] nums) {
        int[] cache = new int[nums.length];
        Arrays.fill(cache, -1);
        return recursion(0, nums, cache);
    }

    private int recursion(int index, int[] nums, int[] cache) {
        if(index >= nums.length) {
            return 0;
        }

        if(cache[index] != -1) {
            return cache[index];
        }

        int take = nums[index] + recursion(index + 2, nums, cache);
        int noTake = recursion(index + 1, nums, cache);

        return cache[index] = Math.max(take, noTake);
    }
}