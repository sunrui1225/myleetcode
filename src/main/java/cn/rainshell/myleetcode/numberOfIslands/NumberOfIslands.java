package cn.rainshell.myleetcode.numberOfIslands;

import com.google.gson.Gson;

/**
 * 200. 岛屿数量
 *
 * 1, DFS
 * 2, BFS
 * 2, Union-Find
 * @author jason
 * @date 2020/9/8
 */
public class NumberOfIslands {

    public int numIslands(char[][] grid) {

        if(grid == null || grid.length==0) {
            return 0;
        }

        int row = grid.length;
        int col = grid[0].length;
        int numIsLands=0;
        for (int i=0;i<row;i++) {
            for (int j=0;j<col;j++) {
                if(grid[i][j]=='1') {
                    dfs(grid, i, j);
                    numIsLands++;
                }
            }
        }
        return numIsLands;
    }

    private void dfs(char[][] grid , int row, int col) {

        // terminator
        if(row<0 || col <0 || row>=grid.length || col>=grid[0].length || grid[row][col]=='0') {
            return;
        }
        // process
        grid[row][col]='0';
        // drill down
        dfs(grid, row-1, col);
        dfs(grid, row, col-1);
        dfs(grid, row+1, col);
        dfs(grid, row, col+1);
    }

    public static void main(String[] args) {

        char[][] islandsChars = new char[][]{
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };

        NumberOfIslands islands = new NumberOfIslands();
        System.out.println(new Gson().toJson(islands.numIslands(islandsChars)));


    }
}
