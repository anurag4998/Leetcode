class Solution {
    /*
     * When iterating over the array, at every index we have two choices, either
     * take the element at that index or move to the new index.
     * 
     * If an element is taken we should reduce the target value, eventually after
     * adding elements if the target reduces to 0, we can add this resultSet in our final set.
     * 
     * In our recursive logic once we add an element to the list, for the case where
     * we do not take the value we should remove the element which was added.
     */

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> resultSet = new ArrayList<>();
        makeCombinations(candidates.length - 1, candidates, target, new ArrayList<Integer>(), resultSet);
        return resultSet;
    }

    private void makeCombinations(int index, int[] candidates, int target, List<Integer> list, List<List<Integer>> resultSet ) {
        if(target == 0) {
            resultSet.add(new ArrayList<Integer>(list));
            return;
        }
        if(index < 0) {
            return;
        }
        if(candidates[index] <= target) {
            list.add(candidates[index]);
            makeCombinations(index, candidates, target - candidates[index], list, resultSet);
            list.remove(list.size() - 1);
        }

        makeCombinations(index - 1, candidates, target, list, resultSet);
    }




}
