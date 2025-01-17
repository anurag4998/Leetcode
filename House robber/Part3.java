/*

Apart from the caching/memoization approach, we can also approach the solution by creating an array that holds the values of the maximum amount that can be
achieved at a particular index. We can then use this information to subsequently build an array back until the first index.

BUILDING A SOLUTION FROM THE LAST INDEX

If we try to build a solution for the array [2,7,9,3,1], we first have to initialize an array let's call it cache.

On the right is an array which will hold the max sum achieved at a particular index, If we are asked what is the max sum that can be generated, if we start at the last index it would be 1.
If we start at the second last index it would be 3 since we can not sum values at two consecutive indices.

Coming back one step, the value at 2nd index is 9, at this point there are two choices either take this value or skip the value, if we take the value the max sum which can be generated is 9+1 = 10. 
If not we will skip and go further to the next index, but since we have already calculated what is the max value that can be achieved at second last index we can just return the same. 
Now just compare the values and take the max possible sum, in our case it will be max(10,3) = 10.

Similarly going forward we should repeat this algorithm the max value which we can get at the index is Math.max((nums[i] + cache[i+2]) , nums[i+1]) (same as recursive solution).

And VOILA!! we are done cache[0] is our answer.

*/

class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        int[] cache = new int[nums.length];
        cache[nums.length - 1] = nums[nums.length - 1];
        cache[nums.length - 2] = Math.max(nums[nums.length - 1], nums[nums.length - 2]);
        for(int i = cache.length - 3; i > -1; i--) {
            cache[i] = Math.max((nums[i] + cache[i+2]), cache[i+1]);
        }
        return cache[0];


    }

    
}