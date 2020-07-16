package cn.rainshell.myleetcode.lee20200715;

/**
 * @author jason
 * @date 2020/7/16
 */
public class ValidPalindrome2 {

    public static boolean validPalindrome(String s) {


        for (int i=0,j=s.length()-1;i<j;i++,j--) {

            if(s.charAt(i)!=s.charAt(j)) {
                return isPalindrome(s, i+1, j) || isPalindrome(s, i , j-1);
            }
        }
        return true;
        // 时间复杂度O（n）
        // 空间复杂度O（1）
    }

    public static boolean isPalindrome(String s, int i, int j) {

        while (i<j) {
            if(s.charAt(i++)!=s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(validPalindrome("abca"));
        System.out.println(validPalindrome("abcacbab"));
        System.out.println(validPalindrome("abcaccba"));
        System.out.println(validPalindrome("abcacddba"));
    }
}
