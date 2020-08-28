package cn.rainshell.myleetcode.combinations;

import com.google.gson.Gson;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 77. 组合
 * 思路：
 *     回溯：利用栈的回溯性，在递归前后使用
 *     剪枝：从规则中得出，不需要再添加数，从而现在循环中i的最大值
 *          规律 index的最大值 + 接下来要选择的元素的个数 - 1 = n, index的最大值的意思是有效的组合，即使之后再添加新数也无解了
 *          接下来要选择的元素的个数 = k - deque.size()
 * @author jason
 * @date 2020/8/28
 */
public class Combinations {


    public static List<List<Integer>> combine(int n, int k) {

        if(n <0 || k < 0 || n < k) {
            return resultList;
        }

        // 此栈存储已经放入的组合，确定一个组合后，放入一个list中
        Deque deque = new ArrayDeque();

        findCombinations(n, k, 1, deque);

        return resultList;
    }

    private static List<List<Integer>> resultList = new ArrayList<>();

    /**
     * 递归查找组合
     * @param n 给定的数
     * @param k 组合的大小
     * @param index 在给定的数中从那一位开始
     * @param deque 组合存储
     */
    private static void findCombinations(int n, int k, int index, Deque deque) {

        // terminator，递归结束
        if(deque.size() == k) {
            resultList.add(new ArrayList<>(deque));
            return;
        }

        // 剪枝：规律 index的最大值 + 接下来要选择的元素的个数 - 1 = n, index的最大值的意思是有效的组合，即使之后再添加新数也无解了
        // 接下来要选择的元素的个数 = k - deque.size()
        for (int i = index; i<= n + 1 -k + deque.size();i++) {
            // 处理当前
            deque.add(i);
            // drill down
            findCombinations(n, k, i + 1, deque);
            deque.remove(i);
        }

    }

    public static void main(String[] args) {


        System.out.println(new Gson().toJson(combine(4, 2)));
    }

}
