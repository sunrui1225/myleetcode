package cn.rainshell.myleetcode.nAryTreeLevelOrderTraversal;

import java.util.*;
/**
 * 429. N 叉树的层序遍历
 * 思路：利用队列(这例子中用到的是链表做队列)，访问队列中的全部节点，每访问一个节点就把该节点的孩子都加到队列中，内层循环完之后，再外层循环判断队列是否是空了
 *
 */
public class NAryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(Node root) {

        List<List<Integer>> res = new ArrayList<>();

        if(root ==null) {
            return res;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {

            List<Integer> level = new ArrayList<>();
            int len = queue.size();
            for(int i=0;i<len;i++) {
                Node node = queue.remove();
                level.add(node.val);
                queue.addAll(node.children);
            }
            res.add(level);
        }
        return res;
    }
}


// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
