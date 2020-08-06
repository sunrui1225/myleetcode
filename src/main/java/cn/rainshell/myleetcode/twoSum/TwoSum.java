package cn.rainshell.myleetcode.twoSum;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

/**
 * 思路：一遍哈希法，利用一个哈希表，保存已经遍历的数组，key为数组，value为下标。
 *         每遍历一个数值，就用target减去该数，在map中看看有没有。
 *         因为不是排好序的数组，所以无法用双指针的方法。
 * @author jason
 * @date 2020/8/6
 */
public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer other = target - nums[i];
            if(map.containsKey(other)) {
                return new int[]{map.get(other), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }

    public static void main(String[] args) {
//        给定 nums = [2, 7, 11, 15], target = 9

        int[] nums = new int[]{2, 7, 11, 15};
        System.out.println(new Gson().toJson(twoSum(nums, 13)));
    }
}
