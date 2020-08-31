package cn.rainshell.myleetcode.permutationsII;

import com.google.gson.Gson;

import java.util.*;

/**
 * 47. 全排列 II
 * 思路：和46题相同，但是考虑的剪枝情况
 *      剪枝关键：1，如果之前的一个数和当前相等，但是刚刚从栈中取消的，则要剪枝。2，如果是正在使用中的，则要继续，不要剪，可以参考leecode上的一个图。
 *      即条件  i>0 && nums[i]==nums[i-1] && !used[i-1]   则  continue
 * @author jason
 * @date 2020/8/31
 */
public class PermutationsII {

    public static List<List<Integer>> permuteUnique(int[] nums) {

        // 结果
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            return null;
        }
        // 临时存储数
        Deque<Integer> deque = new ArrayDeque<>();
        // 是否已经用过
        boolean[] used = new boolean[nums.length];

        // 排序是剪枝的前提！
        Arrays.sort(nums);

        dfs(nums, deque, used, res);
        return res;
    }

    /**
     * 深度优先遍历，把遍历的数放到结果list中res
     * @param nums 遍历数组
     * @param used 是否用过
     * @param deque 临时存储结果栈
     * @param res 遍历结果
     */
    private static void dfs(int[] nums, Deque<Integer> deque, boolean[] used, List<List<Integer>> res) {

        // 终止条件
        if(nums.length == deque.size()) {
            res.add(new ArrayList<>(deque));
            return;
        }

        for (int i=0;i<nums.length;i++) {
            if (used[i]) {
                continue;
            }
            // 剪枝关键：1，如果之前的一个数和当前相等，但是刚刚从栈中取消的，则要剪枝。2，如果是正在使用中的，则要继续，不要剪，可以参考leecode上的一个图。
            if(i>0 && nums[i]==nums[i-1] && !used[i-1]) {
                continue;
            }
            deque.add(nums[i]);
            used[i]=true;
            dfs(nums, deque, used, res);
            used[i]=false;
            deque.removeLast();
        }
    }

    public static void main(String[] args) {

//        [2,2,1,1]
//        输出：
//[[2,2,1,1],[2,1,2,1],[2,1,1,2],[1,2,2,1],[2,1,1,2],[1,1,2,2]]
//        预期结果：
//[[1,1,2,2],[1,2,1,2],[1,2,2,1],[2,1,1,2],[2,1,2,1],[2,2,1,1]]

        int[] a = new int[]{2,2,1,1};
        System.out.println(new Gson().toJson(permuteUnique(a)));

    }
}
