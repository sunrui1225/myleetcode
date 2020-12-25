package cn.rainshell.myleetcode.climbingStairs;

/**
 * 70. 爬楼梯
 * 思路：爬到第n阶台阶等于倒数第一阶台阶n-1阶的步数和倒数第二阶台阶n-2的步数之和。
 *      注意第0阶的步数为1，第1阶的步数为1，此后为斐波那契数列。
 *      时间复杂度为On
 */
public class ClimbingStairs {

    public int climbStairs(int n) {

        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i=2;i<n+1;i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        ClimbingStairs c = new ClimbingStairs();
        System.out.println(c.climbStairs(2));
    }
}
