package com.finco.squarehouse;
/*
Assume that there is a lake with land. Assume number 0 represents water
while positive numbers represent the land. The number represents the
height of the land - so number 2 means the land is higher than number 1.

You mission, should you accept it, is to create a *square house*
which has the largest area on that lake within the same land height.

Input : Two-dimensional array which represent the lake area.
Output: the biggest number represent the area of the house

Example1:
Input:
    0	0	3	3	0
    0	1	3	3	0
    1	3	3	3	0
    0	0	2	1	0

should have output : 4

Example2:
Input:
    0	3	3	3	0
    2	3	3	3	3
    1	3	3	3	2
    0	0	2	1	0

should have output : 9
 */
public interface Solution {

    /*  DP:
        Time complexity : O(mn)O(mn). Single pass.
        Space complexity : O(mn)O(mn). Another matrix of same size is used for dp.
     */
    public default int maximalSquare(int[][] matrix, int val) {
        int rows = matrix.length;
        int cols = rows > 0 ? matrix[0].length : 0;
        int[][] dp = new int[rows + 1][cols + 1];
        int maxSquareLength = 0;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                if (matrix[i-1][j-1] == val){
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                    maxSquareLength = Math.max(maxSquareLength, dp[i][j]);
                }
            }
        }
        return maxSquareLength * maxSquareLength;
    }
    public int  maximalSquare( int[][] matrix);
}
