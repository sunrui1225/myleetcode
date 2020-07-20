package cn.rainshell.myleetcode.findLongestWord;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jason
 * @date 2020/7/20
 */
public class FindLongestWord {

    public static String findLongestWord(String s, List<String> d) {

        String maxStr = "";
        if(d==null || d.size()==0) {
            return maxStr;
        }

        for (String str : d) {
            if(isSubSequence(str, s)) {
                if(maxStr.length() < str.length()
                || maxStr.length() == str.length() && str.compareTo(maxStr)<0) {
                    maxStr = str;
                }
            }
        }
        return maxStr;
    }

        private static boolean isSubSequence(String target, String baseStr) {

        // at result, i is the number of matching str of baseStr
        // j is the index of target, to compare because matched, j will be the end;
        int j=0;
        for (int i=0;i<baseStr.length() && j<target.length();i++) {
            if(target.charAt(j)==baseStr.charAt(i)) {
                j++;
            }
        }
        return j==target.length();
    }

    public static void main(String[] args) {


        String s = "abpcplea";
        List<String> d = Arrays.asList("ale","apple","monkey","plea");

        System.out.println(findLongestWord(s, d));
    }


}
