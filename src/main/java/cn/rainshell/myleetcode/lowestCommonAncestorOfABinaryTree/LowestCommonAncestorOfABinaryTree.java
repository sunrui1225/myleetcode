package cn.rainshell.myleetcode.lowestCommonAncestorOfABinaryTree;

/**
 * 二叉树寻找最近公共祖先的思路：
 * 本题有两个思路
 *  1，递归
 *      定义fx 表达式，左子树或者右子书是否包含p或者q节点，当前节点是否是p或者q节点，x为子节点
 *      深度优先便利，在便利中利用上述表达式找出答案。
 *  2，保存每个节点的父亲节点，通过map保存。从p向上跳一直到根，保存访问过的节点路径到set，然后再从q向上访问，如果有节点在set中，找到答案
 * @author jason
 * @date 2020/8/21
 */
public class LowestCommonAncestorOfABinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private TreeNode ans;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        dfs(root, p, q);
        return ans;
    }

    /**
     * 深度优先便利：判断1，左子树或者右子书是否包含p或者q节点。2，当前节点是否是p或者q节点。
     * @param root 当前节点
     * @param p p节点
     * @param q q节点
     * @return 是否包含 p，q节点
     */
    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {

        // terminate 终止条件
        if(root == null) {
            return false;
        }

        // current level logic ， drill down
        boolean lson = dfs(root.left, p, q);
        boolean rson = dfs(root.right, p, q);
        if( lson && rson || (root.val == p.val || root.val == q.val) && ( lson || rson ) ) {
            ans = root;
        }

        return lson || rson || root.val == p.val || root.val == q.val;
    }
}
