package cn.rainshell.myleetcode.longestPalindromicSubstring;

/**
 * 5. 最长回文子串
 * @author jason
 * @date 2020/10/28
 */
public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {

        int len = s.length();
        if(len <= 1) {
            return s;
        }

        int max = 1;
        int start = 0;

        // 定义状态 s[i..j]是否是回文串
        boolean dp[][] = new boolean[len][len];
        for(int j=1;j<len;j++) {
            for(int i=0;i<j;i++) {
                if(s.charAt(i) == s.charAt(j)) {
                    if(j-i<3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                } else {
                    dp[i][j] = false;
                }

                if(dp[i][j] && max < j - i +1) {
                    max = j - i + 1;
                    start = i;
                }
            }
        }
        return s.substring(start, start+max);
    }

    public static void main(String[] args) {
        String s = "ac";

        LongestPalindromicSubstring l = new LongestPalindromicSubstring();
        System.out.println(l.longestPalindrome(s));
    }
}
