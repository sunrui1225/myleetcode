package cn.rainshell.myleetcode.reverseVowelsOfAString;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author jason
 * @date 2020/7/15
 */
public class ReverseVowels2 {

    private static Set<Character> vowelSet = new HashSet<>(
            Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

    private static String reverseVowels2(String s) {

        if(s==null) {
            return  null;
        }

        int i=0;
        int j=s.length()-1;
        char[] result = new char[s.length()];
        while (i<j) {
            if(!vowelSet.contains(s.charAt(i))) {
                result[i]=s.charAt(i);
                i++;
            } else if(!vowelSet.contains(s.charAt(j))) {
                result[j]=s.charAt(j);
                j--;
            } else {
                result[i]=s.charAt(j);
                result[j]=s.charAt(i);
                i++;
                j--;
            }
        }
        return new String(result);

        // 时间复杂度：O（n）
        // 空间复杂度：O（1）
    }

    public static void main(String[] args) {

        System.out.println(reverseVowels2("leetcode"));
        System.out.println(reverseVowels2("lEEtcOde"));
    }
}
