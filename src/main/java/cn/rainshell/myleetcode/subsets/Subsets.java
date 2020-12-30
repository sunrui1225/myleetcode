package cn.rainshell.myleetcode.subsets;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. 子集
 * 思路：回溯(DFS),注意参数的传递
 * 监考文章：https://leetcode-cn.com/problems/subsets/solution/c-zong-jie-liao-hui-su-wen-ti-lei-xing-dai-ni-gao-/
 */
public class Subsets {

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0, new ArrayList<>());
        return res;
    }

    /**
     *
     * @param nums
     * @param start 当前层次已经在nums中遍历的数的下标
     * @param path 递归数已经遍历到的路径
     */
    private void backtrack(int[] nums, int start, List<Integer> path) {

        // terminator，此题不需要终止条件，因为选择列表可以通过设置start，把剪枝的部分去掉

        // 把当前路径，即一种子集结果加入结果集
        res.add(new ArrayList<>(path));

        // 用一个for循环给出选择列表,
        for(int i = start; i <nums.length; i++) {
            //添加路径
            path.add(nums[i]);
            // 进入下一层次
            backtrack(nums, i+1, path);
            //撤销再进入另一个分支的下一层
            path.remove(path.size()-1);
        }
    }

    public static void main(String[] args) {
        Subsets s = new Subsets();
        int[] nums = new int[]{1,2,3};
        System.out.println(new Gson().toJson(s.subsets(nums)));
    }
}
