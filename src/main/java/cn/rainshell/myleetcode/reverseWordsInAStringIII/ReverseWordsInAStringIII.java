package cn.rainshell.myleetcode.reverseWordsInAStringIII;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 557. 反转字符串中的单词 III
 * 思路：利用双端队列
 *      但是利用java api 的split，而且时间上有待于优化
 * @author jason
 * @date 2020/11/26
 */
public class ReverseWordsInAStringIII {

    public String reverseWords(String s) {

        if(s == null || s.equals("")) {
            return "";
        }
        Deque deque = new ArrayDeque();
        String[] charList = s.split(" ");
        for(int i = charList.length -1; i>=0; i--) {
            if(charList[i] != null && charList[i] != "") {
                for(int j=0;j<charList[i].length();j++) {
                    deque.add(charList[i].charAt(j));
                }
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
        String s = "Let's take LeetCode contest";
        ReverseWordsInAStringIII r = new ReverseWordsInAStringIII();

        System.out.println(r.reverseWords(s));
//        输出："s'teL ekat edoCteeL tsetnoc"
    }
}
