package cn.rainshell.myleetcode.moveZeroes;

import com.google.gson.Gson;

/**
 * @author jason
 * @date 2020/7/31
 */
public class MoveZeroes {

    public static void moveZeroes(int[] nums) {
        int lastNonZero = -1;
        for (int cur = 0; cur <= nums.length - 1; cur++) {
            if(nums[cur] != 0) {
                lastNonZero++;
                swap(nums, lastNonZero, cur);
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
//        输入: [0,1,0,3,12]
//        输出: [1,3,12,0,0]

        int[] nums = new int[]{0,1,0,3,12};
        moveZeroes(nums);
        System.out.println(new Gson().toJson(nums));
    }
}
