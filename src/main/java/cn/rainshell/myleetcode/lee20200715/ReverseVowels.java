package cn.rainshell.myleetcode.lee20200715;

import com.google.gson.Gson;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jason
 * @date 2020/7/15
 */
public class ReverseVowels {

    static  Set vowelSet = new HashSet<String>();
    {
        vowelSet.add("a");
        vowelSet.add("e");
        vowelSet.add("i");
        vowelSet.add("o");
        vowelSet.add("u");
        vowelSet.add("A");
        vowelSet.add("E");
        vowelSet.add("I");
        vowelSet.add("O");
        vowelSet.add("U");
    }

    public static String reverseVowels(String s) {

        if(s==null||s.length()==0) {
            return null;
        }

        char[] n = s.toCharArray();
        int i=0;
        int j=s.length()-1;
        while (i<j) {
            if(!vowelSet.contains(String.valueOf(n[i]))) {
                i++;
            }
            if(!vowelSet.contains(String.valueOf(n[j]))) {
                j--;
            }
            if(vowelSet.contains(s.charAt(i)) && vowelSet.contains(s.charAt(j))) {
                char temp = n[i];
                n[i] = n[j];
                n[j] = temp;
                i++;
                j--;
            }
        }
        return n.toString();
    }

    public static void main(String[] args) {


        System.out.println(reverseVowels("leetcode"));
        System.out.println(reverseVowels("lEEtcOde"));
    }
}
