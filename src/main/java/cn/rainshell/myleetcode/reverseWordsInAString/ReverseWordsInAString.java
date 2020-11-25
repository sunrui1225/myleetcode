package cn.rainshell.myleetcode.reverseWordsInAString;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 151. 翻转字符串里的单词
 * 思路：利用双端队列（栈）的特性
 * @author jason
 * @date 2020/11/25
 */
public class ReverseWordsInAString {

    public String reverseWords(String s) {

        if(s == null || s.equals("")) {
            return null;
        }
        Deque<String> deque = new ArrayDeque<>();
        String[] a = s.split(" ");
        for (String c : a) {
            if(c != null && !c.equals("") && !c.equals(" ")) {
                deque.add(c);
                deque.add(" ");
            }
        }
        deque.pollLast();
        StringBuilder b = new StringBuilder();
        while(deque.size()>0) {
            b.append(deque.pollLast());
        }
        return b.toString();
    }

    public static void main(String[] args) {
        String a = "the sky is blue";
        ReverseWordsInAString r = new ReverseWordsInAString();
        System.out.println(r.reverseWords(a));
    }
}
