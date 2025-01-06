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
         */

         boolean[] canJumpToLastIndex = new boolean[nums.length];
         int lastIndex = nums.length - 1;
         canJumpToLastIndex[lastIndex] = true;

         for(int i = nums.length - 2 ; i>-1; i--) {
            int indexThatCanBeReached = i + nums[i];
            if(indexThatCanBeReached >= lastIndex) {
                canJumpToLastIndex[i] = true;
            }
            else {
                for(int j = i + 1; j <= indexThatCanBeReached; j++ ) {
                    if(canJumpToLastIndex[j] == true) {
                        canJumpToLastIndex[i] = true;
                        break;
                    }
                }
            }
         }
         return canJumpToLastIndex[0];

    }
}