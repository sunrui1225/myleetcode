package cn.rainshell.myleetcode.validSudoku;

/**
 * 36. 有效的数独
 * 思路：在遍历过程中，利用哈希表存储数字在该行，列，3*3box出现过。
 * @author jason
 * @date 2020/9/10
 */
public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {

        // 哈希表某一点的所在的行是否出现过，9代表9行，第二维的维数10是为了让下标有9，和数独中的数字9对应。
        // 如果row[0][2]=1表示：数字2在第0行出现过
        int[][] row = new int[9][10];
        int[][] col = new int[9][10];
        // 某一点所在的第几个3*3box
        int[][] box = new int[9][10];

        for(int i=0;i<9;i++) {
            for(int j=0;j<9;j++) {
                if(board[i][j]=='.') {
                    continue;
                }
                int curNum = board[i][j]-'0';
                if(row[i][curNum]>0) return false;
                if(col[j][curNum]>0) return false;
                int boxNum = (i/3)*3 + j/3;
                if(box[boxNum][curNum]>0) return false;

                row[i][curNum] = 1;
                col[j][curNum] = 1;
                box[boxNum][curNum] = 1;
            }
        }
        return true;
    }
}
