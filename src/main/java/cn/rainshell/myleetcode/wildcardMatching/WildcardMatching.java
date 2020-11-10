package cn.rainshell.myleetcode.wildcardMatching;

/**
 * 44. 通配符匹配
 * @author jason
 * @date 2020/11/9
 */
public class WildcardMatching {

    public boolean isMatch(String s, String p) {


        int m = s.length();
        int n = p.length();

        //dp[i][j]代表s的前i的字符和p和前j个字符是否匹配
        // 长度m+1和n+1除了包含s的m个字符和p的n个字符外，要考虑空字符和空模式的情况，用0来表示，dp[0][0]表示空字符和空模式
        boolean[][] dp = new boolean[m + 1][n + 1];

        //考虑标界
            // dp[0][0]=true; 空字符和空模式匹配
            // dp[i][0] i>0,空模式和任何的不属于空字符串都不匹配，所以利用boolean数组的默认值都为false。
            // dp[0][j] j>0,空字符分情况：1，如果p模式中没有*，则不匹配。2，p中必须是连续的*才能匹配。
        dp[0][0]=true;
        for(int j=1;j<=n;j++) {
            if(p.charAt(j-1)=='*') {
                dp[0][j]=true;
            } else {
                break;
            }
        }

        // 状态转移方程
            // 当p是*的时候，分情况：1，不用*则看dp[i][j-1]。用*则看dp[i-1][j]
        for(int i = 1;i <= m;i++) {
            for(int j = 1;j <= n;j++) {
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1)== '?') {
                    dp[i][j] = dp[i-1][j-1];
                } else if(p.charAt(j-1)== '*') {
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        WildcardMatching w =new WildcardMatching();
        String s = "adceb";
        String p = "*a*b";
        System.out.println(w.isMatch(s, p));
    }
}
