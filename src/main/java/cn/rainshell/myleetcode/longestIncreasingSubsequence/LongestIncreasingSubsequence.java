package cn.rainshell.myleetcode.longestIncreasingSubsequence;

/**
 * 300. 最长递增子序列
 * 思路：只求最大长度，没有求具体解，一般用动态规划
 *      如果按照题目所求的问题设置状态方程dp[]，则状态转移方程不好写出（因为要找出dp[0]到dp[i-1]中最大的长度值加1）
 *      故，设置辅助状态tail[i]为长度为i+1，所有上升子序列的结尾的最小值。
 *              如果nums[i]都大于tail的末尾的那个值，则说明长度加1，tail右移一位，把nums[i]赋值。
 *              否则，在tail[0]到tail[end]用二分查找，找到第一个大于nums[i]的值，替换掉(意义：以更小的值作为结尾，往后遍历会更有可能遇到更大的值延长长度)
 * 题解见https://leetcode-cn.com/problems/longest-increasing-subsequence/solution/dong-tai-gui-hua-er-fen-cha-zhao-tan-xin-suan-fa-p/
 * @author Jason
 */
public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {

        int len = nums.length;
        if(len < 2) {
            return len;
        }

        // 所有最大长度的索引
        int end = 0;
        // tail[i]长度为i+1的所有上升子序列的结尾的最小值，tail的长度既是题目所求
        int[] tail = new int[len];
        // 考虑初始化
        tail[0] = nums[0];
        // 状态转移方程：tail[i]，遍历数组nums[i]，让tail数组第一个严格大于nums[i]的数变成nums[i]
        for(int i=1; i < len;i++) {
            if (nums[i] > tail[end]) {
                tail[++end]=nums[i];
            } else {
                int left = 0;
                int right = end;
                while(left < right) {
                    int mid = left + ((right - left)>>>1);
                    if(tail[mid] < nums[i]) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                tail[left] = nums[i];
            }
        }
        end++;
        return end;
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence l = new LongestIncreasingSubsequence();
        int[] nums = new int[]{10,9,2,5,3,7,101,18,4,8,6,12};
        System.out.println("length:"+l.lengthOfLIS(nums));
    }
}
