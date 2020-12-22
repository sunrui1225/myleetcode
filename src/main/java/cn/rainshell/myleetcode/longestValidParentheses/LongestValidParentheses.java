package cn.rainshell.myleetcode.longestValidParentheses;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 32. 最长有效括号
 * 思路： 左括号入栈，右括号判断，如果为空则入栈，如果不为空则计算长度
 *       栈里边始终放一个最后一个没有被匹配的右括号的下标，最长的长度等于遍历的当前的右括号下标与栈顶元素的下标相减，栈顶元素可能是左括号也可能是右括号
 *
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        if(s == null) {
            return 0;
        }
        int len = s.length();
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        // 栈里边始终放一个最后一个没有被匹配的右括号的下标，最长的长度等于遍历的当前的右括号下标与栈顶元素的下标相减，栈顶元素可能是左括号也可能是右括号
        int longest = 0;
        char[] chars = s.toCharArray();
        for(int i=0; i<len; i++) {
            if(chars[i] == '(') {
                stack.push(i);
            } else {
                // 弹出栈顶元素，可能是一个左括号，也可能是一个没有匹配的右括号
                stack.pop();
                if(stack.isEmpty()) {
                    stack.push(i);
                } else {
                    longest = Math.max(longest, i - stack.peek());
                }
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        LongestValidParentheses l = new LongestValidParentheses();
//        String s = ")()()(";
        String s = "()(()";
        System.out.println(l.longestValidParentheses(s));
    }
}
