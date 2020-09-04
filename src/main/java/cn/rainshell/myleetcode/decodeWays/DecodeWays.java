package cn.rainshell.myleetcode.decodeWays;

import com.google.gson.Gson;

/**
 * 91. 解码方法
 * 思路：动态规划
 * 找子问题：
 *      dp[i] 是 s[i]能够得到多少种解码数。
 *      总的思想和爬楼梯问题一样，dp[i] = dp[i-1] + dp[i-2]，但是考虑0不能单独解码，必须看前一位是否为1或者2，所以不能单独这样列
 *      分情况计算：
 *      当时s[i]是非0时候，dp[i] = dp[i-1]
 *      进而如果s[i]和s[i-1]可以合并解码（即 10<=s[i-1..i]<=26），要再加上dp[i-2]的情况。
 *
 *      时间复杂度：O（n）
 *      空间复杂度：O（n）
 * @author jason
 * @date 2020/9/3
 */
public class DecodeWays {

    public static int numDecodings(String s) {

        int[] dp = new int[s.length()];
        if(s.charAt(0) == '0') {
            return 0;
        }
        dp[0]=1;
        for(int i=1;i<s.length();i++) {
            if(s.charAt(i) != '0' ) {
                dp[i] = dp[i-1];
            }
            int num = (s.charAt(i-1) - '0') * 10 + (s.charAt(i) - '0');
            if(10 <=  num && num <= 26) {
                if(i==1) {
                    dp[i]++;
                } else {
                    dp[i] += dp[i-2];
                }

            }
        }
        return dp[s.length()-1];
    }

    public static void main(String[] args) {
//        String s = "27";
//        String s = "12";
//        String s = "110";
//        String s = "330";
        String s = "226";
        System.out.println(new Gson().toJson(numDecodings(s)));
    }
}
