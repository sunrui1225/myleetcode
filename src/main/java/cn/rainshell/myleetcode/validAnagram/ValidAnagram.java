package cn.rainshell.myleetcode.validAnagram;

/**
 * 解题思路：
 *      1，计数器表，利用哈希表。
 *      2，首先需要考虑如果长度不同，肯定不是。
 *      3，把计数剪值，如果哪一位小于0了，直接返回false
 * @author jason
 * @date 2020/8/6
 */
public class ValidAnagram {

    public static boolean isAnagram(String s, String t) {

        // 如果长度不同返回false
        if(s.length() != t.length()) {
            return false;
        }
        // 计算器赋值，哈希表
        int[] counter = new int[26];
        for (int i=0; i<s.length(); i++) {
            counter[s.charAt(i)-'a']++;
        }
        for(int j=0; j<t.length(); j++) {
            int a = --counter[t.charAt(j)- 'a'];
            if(a<0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        输入: s = "anagram", t = "nagaram"
//        输出: true

        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram(s, t));

         s = "rat";
         t = "car";
        System.out.println(isAnagram(s, t));

        s = "a";
        t = "b";
        System.out.println(isAnagram(s, t));
    }
}
