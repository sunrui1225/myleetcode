package cn.rainshell.myleetcode.binaryTreeInorderTraversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 思路：利用栈，两层循环，内层循环查看节点是否有做孩子一直遍历，外层循环控制栈弹出和转向右子树。
 * 时间复杂度O（N）
 * 空间复杂度O（N）
 * @author jason
 * @date 2020/8/7
 */
public class BinaryTreeInorderTraversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> out = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque();
        if(root == null) {
            return new ArrayList<>();
        }

        TreeNode curr = root;
        while (curr != null || !deque.isEmpty()) {
            while (curr != null) {
                deque.push(curr);
                curr = curr.left;
            }
            TreeNode node = deque.pollFirst();
            out.add(node.val);
            curr = node.right;
        }

        return out;
    }
}
