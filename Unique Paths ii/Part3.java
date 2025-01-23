/*
We can also approach this problem by trying to build our solution from the bottom right corner.
If we notice carefully for the last column, from each cell we can only reach the last bottom right cell in only way which is by going down. Similarly from the last row also we can only reach the bottom right cell by only going right.
In this process if we encounter any cell which has an obstacle, we can deduce that we can not reach the last cell from any cell which is on top of this obstacle(when coming down) and also from any cell which is on the left of the obstacle(when coming right).

Post this we can just iterate over the matrix and sum up the number of ways we can reach the bottom right cell by adding the values present in right and bottom of the particular cell. If we get an obstacle, we know we can not reach the bottom right from this cell.

*/

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        int row = obstacleGrid.length - 1;
        int col = obstacleGrid[0].length - 1;
        dp[row][col] = obstacleGrid[row][col] == 1 ? 0 : 1;

        //fill the last column with 1
        for(int i = dp.length - 2; i > -1; i--) {
            if(obstacleGrid[i][col] == 1) {
                dp[i][col] = 0;
            }
            else {
                dp[i][col] = dp[i + 1][col];
            }
        }

        //fill the last row with 1
        for(int i = dp[0].length - 2; i > -1; i--) {
            if(obstacleGrid[row][i] == 1) {
                dp[row][i] = 0;
            }
            else {
                dp[row][i] = dp[row][i+1];
            }
        }

        for(int i = dp.length - 2; i > -1; i--) {
            for(int j = dp[0].length - 2; j > -1; j--) {
                if(obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                }
                else {
                    dp[i][j] = dp[i+1][j] + dp[i][j + 1];
                }
            }
        }

        return dp[0][0];


    }
}