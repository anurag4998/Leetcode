/*

Since we are recursing in both the directions from each cell, we are bound to land on some cells for which we have already computed the number of paths that can be achieved. To optimize the recursion we can make use of a 2-d array. Why 2-D? because there are two states which are getting modified when we are doing our recursion. i.e the x & y coordinate of the grid.

*/

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        //adding a cache
        int[][] cache = new int[obstacleGrid.length][obstacleGrid[0].length];
        for(int[] row : cache) {
            Arrays.fill(row, -1);
        }
        return recursion(0 , 0, obstacleGrid, cache);
    }

    private int recursion(int i, int j, int[][] grid, int[][] cache) {
        if( i >= grid.length || j >= grid[0].length || grid[i][j] == 1) {
            return 0;
        }

        if(i == grid.length - 1 && j == grid[0].length - 1) {
            return 1;
        }

        if(cache[i][j] != -1) {
            return cache[i][j];
        }

        int right = recursion(i, j + 1, grid, cache);
        int bottom = recursion(i + 1, j, grid, cache);

        return cache[i][j] = right + bottom;
    }
}