package cn.rainshell.myleetcode.minimumPathSum;

import com.google.gson.Gson;

/**
 * 64. 最小路径和
 * 思路：动态规划，从0，0开始推算到i，j，递推方程：Math.min(grid[i-1][j],grid[i][j-1])+grid[i][j]
 * @author jason
 * @date 2020/9/3
 */
public class MinimumPathSum {

    public static int minPathSum(int[][] grid) {



        for (int j=1;j<grid[0].length;j++) {
            grid[0][j]=grid[0][j]+grid[0][j-1];
        }
        for(int i=1;i<grid.length;i++) {
            grid[i][0]=grid[i][0]+grid[i-1][0];
        }

        for(int i = 1;i<grid.length;i++) {
            for(int j=1;j<grid[i].length;j++) {
                grid[i][j] = Math.min(grid[i-1][j],grid[i][j-1])+grid[i][j];
            }
        }
        return grid[grid.length-1][grid[0].length-1];
    }

    public static void main(String[] args) {

//        int[][] a = new int[][]{{1,3,1},{1,5,1},{4,2,1}};

//        int[][] a = new int[][]{{1,2,5},{3,2,1}};

        int[][] a = new int[][]{{1,2},{5,6},{1,1}};

        System.out.println(new Gson().toJson(minPathSum(a)));
    }
}
