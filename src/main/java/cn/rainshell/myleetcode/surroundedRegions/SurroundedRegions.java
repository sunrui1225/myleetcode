package cn.rainshell.myleetcode.surroundedRegions;

import com.google.gson.Gson;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 130. 被围绕的区域
 * 1，dfs递归，利用系统栈
 * 2，dfs非递归，利用stack
 * 3，bfs非递归，利用queue
 * 4，并查集
 * @author jason
 * @date 2020/9/9
 */
public class SurroundedRegions {

    public void solve(char[][] board) {

        if(board == null || board.length == 0) {
            return;
        }
        int rows = board.length;
        int cols = board[0].length;

        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                if( (i==0 || j==0 || i==rows-1 || j== cols-1) && board[i][j] == 'O' ) {
                    bfsQueue(board, i, j);
                }
            }
        }

        for (int i=0;i<rows;i++) {
            for (int j=0;j<cols;j++) {
                if(board[i][j]=='O') {
                    board[i][j]='X';
                } else if(board[i][j]=='#') {
                    board[i][j]='O';
                }
            }
        }
    }

    /**
     * 1，dfs递归
     * @param board
     * @param i
     * @param j
     */
    private void dfsRecursion(char[][] board, int i, int j) {
        int rows = board.length;
        int cols = board[0].length;
        // terminator
        if(i<0 || j<0 || i>rows-1 || j>cols-1 || board[i][j]=='X' || board[i][j]=='#') {
            return;
        }

        if(board[i][j] == 'O') {
            board[i][j]='#';
            dfsRecursion(board, i-1,j);
            dfsRecursion(board, i,j-1);
            dfsRecursion(board, i+1,j);
            dfsRecursion(board, i,j+1);
        }
    }

    /**
     * 2，dfs非递归
     * @param board
     * @param i
     * @param j
     */
    public void dfsStack(char[][] board, int i, int j) {

        int rows = board.length;
        int cols = board[0].length;

        Deque<Integer> stack = new ArrayDeque<>();
        stack.add(i*cols + j);
        board[i][j]='#';

        while (!stack.isEmpty()) {
            int n = stack.peekLast();
            int x = n/cols;
            int y = n%cols;

            if(x-1>=0 && board[x-1][y]=='O') {
                stack.add((x-1)*cols+y);
                board[x-1][y]='#';
                continue;
            }
            if(y-1>=0 && board[x][y-1]=='O') {
                stack.add(x*cols+y-1);
                board[x][y-1]='#';
                continue;
            }
            if(x+1<rows && board[x+1][y]=='O') {
                stack.add((x+1)*cols+y);
                board[x+1][y]='#';
                continue;
            }
            if(y+1<cols && board[x][y+1]=='O') {
                stack.add(x*cols+y+1);
                board[x][y+1]='#';
                continue;
            }
            stack.removeLast();
        }
    }

    /**
     * 3，bfs非递归
     * @param board
     * @param i
     * @param j
     */
    public void bfsQueue(char[][] board, int i, int j) {

        int rows = board.length;
        int cols = board[0].length;
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(i*cols + j);
        board[i][j]='#';

        while (!queue.isEmpty()) {

            int n = queue.removeFirst();
            int x = n/cols;
            int y = n%cols;

            if(x-1>=0 && board[x-1][y]=='O') {
                queue.add((x-1)*cols+y);
                board[x-1][y]='#';
            }
            if(y-1>=0 && board[x][y-1]=='O') {
                queue.add(x*cols+y-1);
                board[x][y-1]='#';
            }
            if(x+1<rows && board[x+1][y]=='O') {
                queue.add((x+1)*cols+y);
                board[x+1][y]='#';
            }
            if(y+1<cols && board[x][y+1]=='O') {
                queue.add(x*cols+y+1);
                board[x][y+1]='#';
            }
        }
    }

    public void solveByUF(char[][] board) {

        if(board == null || board.length == 0) {
            return;
        }
        int rows = board.length;
        int cols = board[0].length;

        // 用一个虚拟节点, 边界上的O 的父节点都是这个虚拟节点
        UnionFind uf = new UnionFind(rows * cols +1);
        int dummyNode = rows * cols;

        for (int i=0;i<rows;i++) {
            for (int j=0;j<cols;j++) {
                // 遇到O进行并查集操作合并
                if(board[i][j]=='O') {
                    // 边界上的O,把它和dummyNode 合并成一个连通区域.
                    if(i==0 || j==0 || i==rows-1 || j==cols-1 ) {
                        uf.union(i*cols+j, dummyNode);
                    } else {
                        // 不是边界上O，和上下左右合并成一个连通区域.
                        if(i>0 && board[i-1][j]=='O') {
                            uf.union((i-1)*cols+j,i*cols+j);
                        }
                        if(i<rows-1 && board[i+1][j]=='O') {
                            uf.union((i+1)*cols+j,i*cols+j);
                        }
                        if(j>0 && board[i][j-1]=='O') {
                            uf.union(i*cols+j-1, i*cols+j);
                        }
                        if(j<cols-1 && board[i][j+1]=='O') {
                            uf.union(i*cols+j+1, i*cols+j);
                        }
                    }
                }
            }
        }

        for (int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++) {
                if(!uf.isConnected(i*cols+j, dummyNode) && board[i][j]=='O') {
                    board[i][j]='X';
                }
            }
        }
    }

    /**
     * 4，并查集
     */
    class UnionFind {
        private int[] parents;

        public UnionFind(int n) {
            parents = new int[n];
            for(int i=0;i<n;i++) {
                parents[i]=i;
            }
        }

        public void union(int node1, int node2) {
            int root1 = find(node1);
            int root2 = find(node2);
            if(root1 != root2) {
                parents[root1] = root2;
            }
        }
        private int find(int node) {
            while (parents[node] != node) {
                parents[node] = parents[parents[node]];
                node = parents[node];
            }
            return node;
        }
        public boolean isConnected(int node1, int node2) {
            return find(node1) == find(node2);
        }

    }

    public static void main(String[] args) {

        char[][] chars =  new char[][] {
                 {'X','O','X','O','X','O'}
                ,{'O','X','O','X','O','X'}
                ,{'X','O','X','O','X','O'}
                ,{'O','X','O','X','O','X'}
        };

        SurroundedRegions sr = new SurroundedRegions();
//        sr.solve(chars);

        sr.solveByUF(chars);
        System.out.println(new Gson().toJson(chars));

    }
}
