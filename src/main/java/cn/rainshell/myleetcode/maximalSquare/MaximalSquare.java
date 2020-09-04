package cn.rainshell.myleetcode.maximalSquare;

import com.google.gson.Gson;

/**
 * 221. 最大正方形
 * 思路：动态规划
 * dp[i][j]：以这个点为右下角最大正方形的变长是多少
 * 方程：当当前格子数为1时候，dp[i][j] = min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + 1
 * @author jason
 * @date 2020/9/4
 */
public class MaximalSquare {

    public static int maximalSquare(char[][] matrix) {

        if(matrix == null || matrix.length == 0) {
            return 0;
        }
        // 状态
        int[][] dp = new int[matrix.length][matrix[0].length];
        int maxSide = 0;
        for(int i=0;i<matrix.length;i++) {
            for(int j=0;j<matrix[0].length;j++) {
                if(matrix[i][j]=='1') {
                    if(i==0 || j==0) {
                        dp[i][j]=1;
                    } else {
                        int temp = Math.min(dp[i-1][j], dp[i][j-1]);
                        dp[i][j] = Math.min(temp, dp[i-1][j-1]) + 1;
                    }
                    maxSide = Math.max(dp[i][j], maxSide);
                }
            }
        }
        return maxSide*maxSide;
    }

    public static void main(String[] args) {
//        char[][] a = new char[][]
//                {{'1' ,'0' ,'1' ,'0' ,'0'}
//                ,{'1' ,'0' ,'1' ,'1' ,'1'}
//                ,{'1' ,'1' ,'1' ,'1' ,'1'}
//                ,{'1' ,'0' ,'0' ,'1' ,'0'}};

        char[][] a = new char[][]{{'1','0'}};

        System.out.println(new Gson().toJson(maximalSquare(a)));
    }
}
