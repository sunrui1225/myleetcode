package cn.rainshell.myleetcode.constructBinaryTreeFromPreorderAndInorderTraversal;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 * 思路：从前序遍历的第一个元素确定根节点，用这个根节点在中序遍历中找到对应的下标
 * 1）用这个下标在中序遍历中确定左子树的长度
 * 2）用这个左子树的长度找出对应在 中序遍历 和 前序遍历的 左子树和右子树的起始和终止下标
 *
 *         // 中序遍历的左子树：inOrderLeft   到   inOrderRootIndex - 1
 *         // 中序遍历的右子树：inOrderRootIndex + 1  到    inOrderRight
 *         // 前序遍历的左子树：preOrderLeft + 1  到  （preOrderLeft + 1 + sizeLeftSubtree -1）
 *         // 前序遍历的右子树：（preOrderLeft + 1 + sizeLeftSubtree -1） + 1 到 preOrderRight
 *
 *
 *         时间复杂度：O（n），n为树节点的数目
 *         空间复杂度：O（n），一个是存储哈希表，一个递归栈空间
 *
 *
 * @author jason
 * @date 2020/8/21
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {

        for (int i=0; i<inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }

        return myBuildTree(preorder, inorder, 0, preorder.length -1, 0, inorder.length - 1);

    }

    /**
     * 记录中序遍历中，数值的下标，以分开左右子树
     */
    private  static Map<Integer, Integer> indexMap = new HashMap<>();

    private static TreeNode myBuildTree(int[] preorder, int[] inorder, int preOrderLeft, int preOrderRight
            , int inOrderLeft, int inOrderRight) {

        if(preOrderLeft > preOrderRight) {
            return null;
        }

        // 根节点
        int rootIndex = preOrderLeft;

        // 中序遍历序列中跟节点的下标
        int inOrderRootIndex = indexMap.get(preorder[rootIndex]);

        TreeNode root = new TreeNode(preorder[rootIndex]);

        // 知道了根节点在中序遍历的下标后，在中序遍历中确定左子树的长度
        int sizeLeftSubtree = inOrderRootIndex - inOrderLeft;
        // 中序遍历的左子树：inOrderLeft   到   inOrderRootIndex - 1
        // 中序遍历的右子树：inOrderRootIndex + 1  到    inOrderRight
        // 前序遍历的左子树：preOrderLeft + 1  到  （preOrderLeft + 1 + sizeLeftSubtree -1）
        // 前序遍历的右子树：（preOrderLeft + 1 + sizeLeftSubtree -1） + 1 到 preOrderRight

        root.left =  myBuildTree(preorder, inorder, preOrderLeft + 1,  preOrderLeft + sizeLeftSubtree
        , inOrderLeft, inOrderRootIndex - 1);
        root.right = myBuildTree(preorder, inorder, preOrderLeft + sizeLeftSubtree +1, preOrderRight
        , inOrderRootIndex + 1, inOrderRight);

        return root;
    }

    public static void main(String[] args) {

        int[] preorder = new int[]{3,9,20,15,7};
        int[] inorder  = new int[]{9,3,15,20,7};


        System.out.println(new Gson().toJson(buildTree(preorder, inorder)));
    }
}
