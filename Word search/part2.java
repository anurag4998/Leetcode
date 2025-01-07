class Solution {

    /*
        OPTIMIZING THE RUNTIME -> 

        To find out if the word exists in the grid, we have to start exploring our options from each cell, from each cell we can travel in 4 directions, i.e UP, RIGHT, BOTTOM, LEFT.

        The first approach although intiuitive and easy to understand is full of redundancies. 
        For example -> 
        1) Everytime we concatenate strings i.e formedWord + ch -> this leads to creation of a new string in java everytime, which is costly.
        2) We exit recursion late even though the word is probably already wrong.
        3) At every recursion we also call equals, this string comparison also becomes unnecessary when the word is wrong.

        To overcome this we can make use of index of the string and base our validations on that.
        We can verify simply if word.charAt(index) == board[i][j] if this is true only then we should proceed with the recursion otherwise we can just return false.
        This allows us to save on those unnecessary string validations, redundant recursice calls and also avoids creation of new Strings in memory since we modify our logic to work on 
        indices rather than a String.
    */
    
    public boolean exist(char[][] board, String word) {

       for(int i = 0 ; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
               
                boolean result = recursion(i, j, 0 , word, board); //pass the index at which we are going to verify
                if(result == true) {
                    return true;
                }
               
                
            }
        }
        return false;
    }

    private boolean recursion(int  i, int j, int index , String word, char[][] board) {
        
        // if(formedWord.equals(word)) {
        //     return true;
        // }
        if(index == word.length()) {
            return true;
        }
        // int size = formedWord.length();
        // if( size > 0 &&  word.charAt(size - 1) != formedWord.charAt(size - 1)) {
        //     return false;
        // }
        if(i >= board.length|| j >= board[0].length || i < 0 || j < 0 || board[i][j] != word.charAt(index)) { //since we stop recursion as soon as the charachter does not match, we also avoid need to compare strings.
            return false;
        }

        final char ch = board[i][j];
        board[i][j] = '/';
        boolean right = recursion(i + 1, j, index + 1, word, board);
        boolean bottom = recursion(i, j + 1, index + 1, word, board);
        boolean left = recursion(i - 1, j, index + 1, word, board );
        boolean top = recursion(i, j-1, index + 1, word, board );

        board[i][j] = ch;
        return right || bottom || left || top;

    }
   

    
}