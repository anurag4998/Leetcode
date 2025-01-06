class Solution {
    public List<List<Integer>> combine(int n, int k) {

        /*
         * A classic recursion question!!
         * Since the combination [1,2] and [2,1] are considered equal, implementation
         * becomes fairly simple.
         * 
         * We can run a for loop, and into a list start adding the number from 1 onwards
         * In subsequent iterations the for loop will start from a number one greater
         * than previously added to the list. Once we return from the recursion, we should
         * remove the last added element to the list to get it ready for further iterations.

         * To have a simple exit condition for the recursion, as and when we add an
         * element to the list we can decrease the value of k, and when k == 0, we can add the
         * generated list to our final result and return.
         */

        List<List<Integer>> combinations = new ArrayList<>();
        recursion(n, k, 1, new ArrayList<Integer>(), combinations);
        return combinations;
    }

    private void recursion(int n, int k, int index,List<Integer> combinationSoFar, List<List<Integer>> combinations) {

        if(k == 0) {
            combinations.add(new ArrayList<Integer>(combinationSoFar));
            return;
        }
       
        for(int i = index; i <= n; i++) {
            combinationSoFar.add(i);
            recursion(n, k - 1,i+1,combinationSoFar,combinations);
            combinationSoFar.remove(combinationSoFar.size() - 1);
        }
    }
}