package cn.rainshell.myleetcode.removeDuplicates;

import com.google.gson.Gson;

/**
 * 26. 删除排序数组中的重复项
 * @author jason
 * @date 2020/7/29
 */
public class RemoveDuplicates {

    public static int removeDuplicates(int[] nums) {


        // j慢指针
        int j=0;
        // i快指针
        for (int i=1;i<nums.length;i++) {
            if(nums[i]!=nums[j]) {
                j++;
                nums[j]=nums[i];
            }
        }
        return j+1;
    }

    public static void main(String[] args) {

        // 给定 nums = [0,0,1,1,1,2,2,3,3,4],
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};

        removeDuplicates(nums);

        System.out.println(new Gson().toJson(nums));
    }
}
