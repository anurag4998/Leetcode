/*
We are given a chessboard and we have to place queens in such a way that no two queens attack each other, in the end
we have to return all the distinct solutions.
Since we have to find out all the possible options, recursion looks like the way to go.

Although the previous approach works it involves a lot of extra computation because of the way the logic was structured.
Instead of marking all the squares which are attacked by the queen and returning a new board matrix everytime we place
a queen, we can instead validate if a queen can be placed on a particular square. If yes then we can carry on with our recursion
or else we can just stop there.
The previous approach (although not very ideal) did not have this we were carrying on until the end and then validating the 
state of the board.
To check if we can place queen or a square or not, we can just verify if there is any queen in the same column and if we have
any queens on either of the diagonals.
There is no point in validating in the left and right since we place only one queen in a row always.
Also there is no point validating if a queen exists below the current row since we are going top to down and have not placed
any queens there.
*/

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        initalizeBoard(board);
        recursion(board, 0, n, result);
        return result;
    }
    private void initalizeBoard(char[][] board) {
        for(int i = 0 ; i < board.length; i++) {
            Arrays.fill(board[i], '.');
        }
    }

    boolean canQueenBePlaced(char[][] board, int row, int col) {

        for(int i = 0; i < row; i++) {
            if(board[i][col] == 'Q') {
                return false;
            }
        }

        for(int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    private List<String> generateBoard(char[][] board) {
        List<String> finalBoard = new ArrayList<>();
        for(int i = 0 ; i < board.length; i++) {
            String str = new String(board[i]);
            finalBoard.add(str);
        }
        return finalBoard;
    }

    private void recursion(char[][] board, int row, int n, List<List<String>> result) {

        if(row == n) {
            result.add(generateBoard(board));
            return;
        }

        for(int col = 0; col < n; col++) {
            if(canQueenBePlaced(board, row, col)) {
                board[row][col] = 'Q';
                recursion(board, row + 1, n, result);
                board[row][col] = '.';
            }
        }

    }
}