package cn.rainshell.myleetcode.rotateArray;

import com.google.gson.Gson;

/**
 *
 * @author jason
 * @date 2020/7/29
 */
public class RotateArray {

    /**
     * 三次反转，时间复杂度：O（n），空间复杂度：O（1）没有使用空间
     * @param nums
     * @param k
     */
    public static void rotate(int[] nums, int k) {

        k %= nums.length;

        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
    }

    private static void reverse(int[] nums, int start, int end) {

        while(start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {

//        输入: [1,2,3,4,5,6,7] 和 k = 3
//        输出: [5,6,7,1,2,3,4]

        int[] nums = new int[]{1,2,3,4,5,6,7};
        rotate2(nums, 3);

        System.out.println(new Gson().toJson(nums));

    }

    /**
     * 此方法只循环了一次，时间复杂度：O（n），空间复杂度O（1）
     * @param nums
     * @param k
     */
    public static void rotate2(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }
}
