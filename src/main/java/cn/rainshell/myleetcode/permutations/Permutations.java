package cn.rainshell.myleetcode.permutations;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 46. 全排列
 * 思路：深度优先遍历，利用一个used数组记录是否已经用过，利用for循环便利
 * @author jason
 * @date 2020/8/31
 */
public class Permutations {

    public static List<List<Integer>> permute(int[] nums) {
        // 结果
        List<List<Integer>> res = new ArrayList<>();
        // 是否已经用过数组
        boolean[] used = new boolean[nums.length];
        // 临时存储数
        Deque<Integer> deque = new ArrayDeque<>();
        // 遍历
        dfs(nums, used, deque, res);

        return res;
    }

    /**
     * 深度优先遍历，把遍历的数放到结果list中res
     * @param nums 遍历数组
     * @param used 是否用过
     * @param deque 临时存储结果栈
     * @param res 遍历结果
     */
    private static void dfs(int[] nums, boolean[] used, Deque<Integer> deque, List<List<Integer>> res) {

        // 遍历终止条件
        if(nums.length == deque.size()) {
            res.add(new ArrayList<>(deque));
            return;
        }

        for (int i=0;i<nums.length;i++) {
            if(used[i]) {
                continue;
            }
            deque.add(nums[i]);
            used[i]=true;
            dfs(nums, used, deque, res);
            //revers conditions
            used[i]=false;
            deque.remove(nums[i]);
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,2,3};


        System.out.println(permute(a));
    }
}
