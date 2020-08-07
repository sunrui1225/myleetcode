package cn.rainshell.myleetcode.binaryTreePreorderTraversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 思路：利用栈做迭代，现在跟节点入栈，然后弹出，访问，再把右孩子，左孩子依次入栈
 * 时间复杂度：O（N）
 * 空间复杂度：O（N）
 * @author jason
 * @date 2020/8/7
 */
public class BinaryTreePreorderTraversal {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {

        if(root==null) {
            return new ArrayList<>();
        }

        List<Integer> ans = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque();
        deque.push(root);

        while (!deque.isEmpty()) {
            TreeNode node = deque.pollFirst();
            ans.add(node.val);
            if(node.right != null) {
                deque.push(node.right);
            }
            if(node.left != null) {
                deque.push(node.left);
            }
        }
        return ans;
    }
}
