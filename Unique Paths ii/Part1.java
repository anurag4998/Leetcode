/*
We are supposed to return the number of possible paths we can take. At each cell, we have two choices either take a right, or go down.
If we hit an obstacle we can stop going forward and just return, if not we can continue taking a right or left until we reach the bottom right corner. This can be again achieved using recursion since we have no choice but to evaluate all possible combinations.

*/

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        return recursion(0 , 0, obstacleGrid);
    }

    private int recursion(int i, int j, int[][] grid) {

        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 1) {
            return 0;
        }

        if(i == grid.length - 1 && j == grid[0].length - 1) {
            return 1;
        }
       
        int bottom = recursion(i + 1, j , grid);

        return right + bottom;


    }
}