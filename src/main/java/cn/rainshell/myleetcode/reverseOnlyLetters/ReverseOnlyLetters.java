package cn.rainshell.myleetcode.reverseOnlyLetters;

/**
 * 917. 仅仅反转字母
 * 思路：双指针，但是要注意移动指针的时候防止index越界
 * @author jason
 * @date 2020/11/26
 */
public class ReverseOnlyLetters {

    public String reverseOnlyLetters(String S) {

        char[] chars = S.toCharArray();
        int i = 0;
        int j = S.length()-1;
        while(i<j) {
            while(i <= S.length() - 1 && !Character.isLetter(chars[i]) ) {
                i++;
            }
            while(j >= 0 && !Character.isLetter(chars[j])) {
                j--;
            }
            if(i<j) {
                char temp = chars[i];
                chars[i] =chars[j];
                chars[j] = temp;
                i++;
                j--;
            }
        }
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
//        String S = "Test1ng-Leet=code-Q!";
//        输出："Qedo1ct-eeLg=ntse-T!"

        String S = "7_28]";
        ReverseOnlyLetters r = new ReverseOnlyLetters();
        System.out.println(r.reverseOnlyLetters(S));
    }
}
