class Solution {
    public boolean canJump(int[] nums) {
        /*
         * We can verify from the last second index onwards if the lastIndex can be
         * reached from
         * this position, store this result in a boolean array.
         * 
         * There are two cases here
         * 
         * 1) if we can reach an index >= lastIndex -> in this case directly mark the
         * result as true in the array
         * 2) if we can not reach the lastIndex -> check if we can reach the lastIndex
         * from all the intermediate positions
         * that we can "jump" to
         * 
         * Optimizing the earlier solution :-
         * 
         * Note in the else case we were manually visiting each index and then
         * validating if from this particular index
         * the last index can be reached. To avoid this we can just keep track of the
         * last position from which we can
         * reach the end of the array
         * 
         * Initalize lastIndex = nums.length - 1;
         * from second last index going backwards verify if you can reach the end of the
         * array
         * If yes then update the lastIndex to that particular index;
         * for every subsequent index see if you can reach lastIndex from it.
         * 
         */

        int lastIndex = nums.length - 1;
        for(int i = nums.length - 2; i > -1; i--) {
            if(i + nums[i] >= lastIndex) {
                lastIndex = i;
            }
        }

        return lastIndex == 0;

    }
}