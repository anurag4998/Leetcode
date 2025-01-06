class Solution {
    public List<List<Integer>> combine(int n, int k) {
        /*
         * FOOD FOR THOUGHT!!!!
         *  
         * I have taken a slightly different approach here instead of removing
         * and adding elements from the same list, I duplicate the existing list
         * and modify the elements into it.
         *
         * This helps in the space complexity considerably as compared to the
         * previous approach. It was pretty insightful trying to figure this.
         *
         * Give it a thought ;) 
         *
         */

        List<List<Integer>> combinations = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            recursion(i + 1, n, k, List.of(i), combinations);
        }
        return combinations;
    }

    private void recursion(int index, int n, int k, List<Integer> combinationSoFar, List<List<Integer>> combinations) {
        if (combinationSoFar.size() == k) {
            combinations.add(combinationSoFar);
            return;
        }
        for (int i = index; i <= n; i++) {
            List<Integer> duplicatedList = combinationSoFar.stream().collect(Collectors.toList());
            duplicatedList.add(i);
            recursion(i + 1, n, k, duplicatedList, combinations);
        }
    }

}