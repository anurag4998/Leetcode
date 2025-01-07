class Solution {

    /*
        To find out if the word exists in the grid, we have to start exploring our options from each cell, from each cell we can travel in 4 directions, i.e UP, RIGHT, BOTTOM, LEFT.

        To start the recursion we can iterate over our given matrix and whenever the first letter of the word is same as the charachter in the board, we can start the recursion.

        As soon as we reach a particular cell, we can append the charachter to our string and then move forward recursively.

        Since it is mentioned in the question, same letter can not be reused, we need a way to distinguish the cells that have been visited and cells which have been not.

        To do this either we can maintain a separate boolean matrix of the same size, where whenever we visit a cell,we set the cell value to true, once we explore our options we set it back to false again.

        Or probably mutate/modify the board itself, whenever we visit the cell, set the value of the cell to a charachter which is not an english alphabet letter. I will be using "/".

        We exit from the recursion whenever we cross the boundaries of the matrix(of course) and we also need a way to stop unnecessary recursions, there is no point in continuing if the word which is getting
        formed deviates from the word we are searching.
        The straightforward approach that can be taken is to just verify if the last added char in our string is equal to the charachter in the word at that particular index.
    */
    
    public boolean exist(char[][] board, String word) {

       for(int i = 0; i < board.length; i++) {
            for(int j = 0 ; j < board[0].length; j++) {
                if(board[i][j] == word.charAt(0)) {
                    boolean result = recursion(i, j , "" , word, board);
                    if(result) {
                        return true;
                    }
                }
            }
       }

        return false;
    }

    private boolean recursion(int  i, int j, String formedWord, String word, char[][] board) {
        if(formedWord.equals(word)) {
            return true;
        }

        int size = formedWord.length(); 
        if( size > 0 && word.charAt(size - 1) != formedWord.charAt(size - 1)) { //verifying if last added charachter at the index is same as charachter in word at the same index
            return false;
        }

        if( i >= board.length || j >= board[0].length|| i < 0 || j < 0 || board[i][j] == '/') {
            return false;
        }

        final char ch = board[i][j];
        board[i][j] = '/';
        boolean right = recursion(i + 1, j, formedWord + ch, word, board);
        boolean bottom = recursion(i, j + 1, formedWord + ch, word, board);
        boolean left = recursion(i - 1, j, formedWord + ch, word, board);
        boolean top = recursion(i , j - 1, formedWord + ch, word, board);
        board[i][j] = ch;

        return top || right || bottom || left; //result of recursion is a logical OR of all the four results from each direction.

    }
   

    
}