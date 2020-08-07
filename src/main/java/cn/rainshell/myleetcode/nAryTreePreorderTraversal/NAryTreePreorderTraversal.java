package cn.rainshell.myleetcode.nAryTreePreorderTraversal;

import java.util.*;

/**
 * 思路：前序遍历，根左右顺序，利用栈保存访问节点，弹出栈顶，输出值，然后把子节点逆序入栈，再出栈
 * @author jason
 * @date 2020/8/6
 */
public class NAryTreePreorderTraversal {

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

    public List<Integer> preorder(Node root) {

        if(root == null) {
            return new ArrayList<>();
        }
        Deque<Node> d = new ArrayDeque();
        List<Integer> out = new ArrayList<>();
        d.push(root);
        while (!d.isEmpty()) {
            Node node = d.pollFirst();
            Collections.reverse(node.children);

            out.add(node.val);

            for (Node  noV : node.children) {
                d.push(noV);
            }
        }
        return out;
    }

    public static void main(String[] args) {
//        Input: root = [1,null,3,2,4,null,5,6]
//        Output: [1,3,5,6,2,4]



    }

}
