class Solution {
    public List<String> generateParenthesis(int n) {
        /*
         * Recursion to rescue again !!
         * While picking a bracket at each step either we can pick a
         * closed bracket or an open bracket.
         * Also a thing to note is if at any point of time the number of open brackets
         * left is more than closed this means we have messed up the combinations.
         * 
         * For Eg :-
         * If n = 3
         * We can not have combinations like
         * )()... or ()).. since the number of open bracket left is more we will never get a
         * correct answer, once we find this is the case we can just return.
         */
        List<String> resultSet = new ArrayList<>();
        recursion(n, n, "", resultSet);
        return resultSet;
    }

    private void recursion(int open, int closed, String paranthesis, List<String> resultSet) {
        if(open == 0 && closed == 0) {
            resultSet.add(paranthesis);
            return;
        }
        if(open > 0) {
            recursion(open - 1, closed, paranthesis + "(", resultSet);
        }
        if(closed > open) {
            recursion(open, closed - 1, paranthesis + ")", resultSet );
        }
    }
}