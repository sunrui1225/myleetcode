package cn.rainshell.myleetcode.judgeSquareSum;

/**
 * @author jason
 * @date 2020/7/15
 */
public class JudgeSquareSum2 {

    static boolean judgeSquareSum(int n) {

        if(n<0) {
            return false;
        }

        int i=0;
        int j = (int)Math.sqrt(n);
        while (i<j) {
            int sum = i*i+j*j;
            if(sum==n) {
                return true;
            } else if(sum<n) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(judgeSquareSum(12));
        System.out.println(judgeSquareSum(13));
        System.out.println(judgeSquareSum(0));
        System.out.println(judgeSquareSum(-1));
    }
}
