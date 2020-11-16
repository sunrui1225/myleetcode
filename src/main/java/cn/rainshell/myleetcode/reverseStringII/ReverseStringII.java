package cn.rainshell.myleetcode.reverseStringII;

/**
 * 541. 反转字符串 II
 * 思路：关键是确定反转的起点start=0，每次加2k，然后确定反转的end，需要比较Math.min(start + k -1, s.length() -1);
 * @author jason
 * @date 2020/11/16
 */
public class ReverseStringII {

    public String reverseStr(String s, int k) {

        char[] a = s.toCharArray();
        for(int start=0; start < s.length(); start += 2 * k) {
            int i = start;
            int j = Math.min(start + k -1, s.length() -1);
            while (i < j) {
                char temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++;
                j--;
            }
        }
        return String.valueOf(a);
    }
}
