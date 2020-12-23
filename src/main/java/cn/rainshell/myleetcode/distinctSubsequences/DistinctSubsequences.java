package cn.rainshell.myleetcode.distinctSubsequences;

/**
 * 115. 不同的子序列
 * 思路：动态规划
 * @author jason
 * @date 2020/11/10
 */
public class DistinctSubsequences {

    public int numDistinct(String s, String t) {

        if(s == null || t== null) {
            return 0;
        }

        int m = s.length();
        int n = t.length();

        // 状态方程 dp[i][j] 是 s的前i个字符串 和 t的前j个字符串是否匹配
        int[][] dp = new int[m+1][n+1];
        // 边界，空串t是空串s的子序列，空串t是非空串s的子序列，非空串t不是是空串s的子序列
        dp[0][0]=1;
        for(int i=1;i<=m;i++) {
            dp[i][0]=1;
        }

        //状态转移方程
        for(int i=1;i<=m;i++) {
            for(int j=1;j<=n;j++) {
                if(s.charAt(i-1) == t.charAt(j-1)) {
                    // 举一个例子
                    //  s : a(1)a(2)a(3) ,  t : a[1]a[2] ，则 dp[i-1][j-1] 是 a(1)a(3)和a[1]a[2]匹配，a(2)a(3)和a[1]a[2]匹配
                                                           // dp[i-1][j] 是 a(1)a(2)和a[1][2]匹配.
                    // 也就是说，如果两个字符相等，s的i-1这字符选与不选的两种情况
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String s = "rabbbit";
        String t = "rabbit";
        DistinctSubsequences d = new DistinctSubsequences();
        System.out.println(d.numDistinct(s, t));
    }


}
