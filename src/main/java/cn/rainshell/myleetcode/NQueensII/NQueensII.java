package cn.rainshell.myleetcode.NQueensII;

/**
 * 52. N皇后 II：位运算
 * 思路：深度优先遍历+ 利用位运算进行剪枝
 * 列，撇，捺 二进制表示，主要用于标记某一行，捺，撇是否已经放置了皇后（1：已经放置）
 *
 * 对于第row行来说
 *      列的编号：从0 到 n-1 共n个
 *      pie的编号：从row 到 row + n -1 共n个
 *      na的编号：从n-1-row 到 2n-2-row 共n个
 *
 *      对于第row行，把pie向右边移动row位，可得到这一第row的最右边n位中，某一列所在的pie已经放置了皇后
 *                  把na向右边移动n - 1 - row位，可得到这一第row的最右边n位中，某一列所在的na已经放置le皇后
 *      最后或在一起再取反，得到可放置皇后的位置，如：((1 << n) -1) & ~(col | pie >> row | na >> (n - 1 - row));
 *
 *      @see <a herf="https://zhuanlan.zhihu.com/p/22846106">参考</a>
 *
 * @author jason
 * @date 2020/9/29
 */
public class NQueensII {
    int count = 0;

    public int totalNQueens(int n) {

        // 遍历行
        int row;
        // 列，撇，捺 二进制表示，主要用于标记某一行，捺，撇是否已经放置了皇后（1：已经放置）
        int col, pie, na;

        dfs(0, n, 0, 0, 0);
        return count;
    }

    private void dfs(int row, int n, int col, int pie, int na) {

        // 计算 第 row 行(当前行) 可放置皇后的列
        int available =  ((1 << n) -1) & ~(col | pie >> row | na >> (n - 1 - row));

        System.out.println("进入到 row:"+row+"，available:"+intToBinary(available)+"，已经放置的列col："+intToBinary(col));
        while(available>0) {
            // terminator
            if(row == n -1) {
                System.out.println("放置了一个皇后，返回，row:"+row+"，已经放置的列col:"+intToBinary(col));
                count++;
                return;
            } else {
                // drill down
                int p = available & -available;
                // 放置了一个皇后
                available ^= p;
                col ^= p; pie ^= p << row; na ^= p << (n -1 - row);
                System.out.println("放置了一个皇后，row:"+row+"，已经放置的列col:"+intToBinary(col));
                dfs(row +1, n, col, pie, na);

                // reverse
                col ^= p; pie ^= p << row; na ^= p << (n -1 - row);
                System.out.println("返回上一层，到下一列，row："+row+"，available:"+intToBinary(available)+"，col："+intToBinary(col));
            }
        }
    }

    public static void main(String[] args) {
        NQueensII q = new NQueensII();
        System.out.println("totalNQueens:"+q.totalNQueens(4));
    }

    /**整数转二进制,前面补零*/
    public static String intToBinary(int num){
        //1.补零
        String binaryStr = Integer.toBinaryString(num);
        int bitNum = 4;
        if(bitNum<binaryStr.length()) {
            bitNum += bitNum;//不断翻倍8 16 32 64...
        }
        while(binaryStr.length() < bitNum){
            binaryStr = "0"+binaryStr;
        }
        //2.格式化
        String str = "";
        for (int i = 0; i < binaryStr.length();) {
            str += binaryStr.substring(i, i=i+4)+",";
        }
        return str.substring(0, str.length()-1);
    }
}
