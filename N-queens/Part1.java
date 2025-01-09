/*
We are given a chessboard and we have to place queens in such a way that no two queens attack each other, in the end
we have to return all the distinct solutions.
Since we have to find out all the possible options, recursion looks like the way to go.

Imagining this problem we can think of a very basic solution and try to build it from there :- 

-> Since we know queens cannot attack each other, there can definitely not be two queens in the same row.
-> Once I keep a queen on a square, I can mark all the squares where queens can not be kept and then proceed further 
     to keep queen on the next available square in the second row. 
-> So everytime we keep a queen we should mark the squares which are not available and then continue jumping to the 
    next row.
-> Once I reach the last row, I can do a quick check if the number of queens kept on the board is same as N, if yes we have 
    succesfully arrived at a solution, if not then this configuration does not work.
-> Once we realize the configuration does not work the queen should be kept at a different square and we repeat the steps
    again.

Point to Note: Since this algorithm marks all the squares attacked by the queen, when we shift the queen to a different 
position, it becomes essential to unmark all the squares which the queen attacked, this can be a bit tedious, to get around this
pass we can return a new reference of the board everytime we call the method to mark the squares.

*/
class Solution {
    /*
     * Fill up the charachter matrix with '.'.
     */
    private void initalizeBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            Arrays.fill(board[i], '.');
        }
    }

    /*
     * Mark all the squares which are attacked by the queen, to identify such
     * squares, I am replacing * '.' by an 'A'. Also we have to make sure 
     * we do not overwrite squares which have a queen on it.
     */

    private char[][] markAttackedSquares(int queenOnRow, int queenOnColumn, char[][] board) {
        char[][] newBoard = new char[board.length][board.length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                newBoard[i][j] = board[i][j];
            }
        }
        for (int row = 0; row < board.length; row++) {
            if (newBoard[row][queenOnColumn] != 'Q')
                newBoard[row][queenOnColumn] = 'A';
        }
        for (int col = 0; col < board[0].length; col++) {
            if (newBoard[queenOnRow][col] != 'Q')
                newBoard[queenOnRow][col] = 'A';
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (Math.abs(i - queenOnRow) == Math.abs(j - queenOnColumn)) {
                    if (newBoard[i][j] != 'Q')
                        newBoard[i][j] = 'A';
                }
            }
        }

        return newBoard;
    }

    /*
     * Count the number of queens present on the board. return true if 
     *  it is same as n
    */
    private boolean validateBoard(char[][] board, int n) {
        int numOfQueens = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'Q') {
                    numOfQueens += 1;
                }
            }
        }
        return numOfQueens == n;
    }

    /*
     * Generate the final configuaration of the board. According to the
     * output format expected.
     */
    private List<String> generateBoard(char[][] board) {
        List<String> finalBoard = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            String str = "";
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'A') {
                    str += ".";
                } else {
                    str += "Q";
                }
            }
            finalBoard.add(str);
        }
        return finalBoard;
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        initalizeBoard(board);
        recursion(board, 0, n, result);
        return result;
    }
    /*
     Iterate over the columns and start placing queens
     Once queen is placed, mark all the squares on which queen 
     cannot be placed.
     Post recursion move the queen to a new square.
    */
    private void recursion(char[][] board, int row, int n, List<List<String>> result) {

        if (row == n) {
            if (validateBoard(board, n)) {
                result.add(generateBoard(board));
            }
            return;
        }
        for (int col = 0; col < n; col++) {
            if (board[row][col] != 'A') {
                board[row][col] = 'Q';
                // passing a new reference everytime to the recursion
                char[][] newBoard = markAttackedSquares(row, col, board);
                recursion(newBoard, row + 1, n, result);
                board[row][col] = '.';
            }
        }
    }
}