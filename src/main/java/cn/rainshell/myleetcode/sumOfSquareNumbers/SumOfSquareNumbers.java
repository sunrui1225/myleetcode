package cn.rainshell.myleetcode.sumOfSquareNumbers;

/**
 * @author jason
 * @date 2020/7/14
 */
public class SumOfSquareNumbers {

    public static boolean judgeSquareSum(int n) {

        int i=0;
        int j=n-1;
        while (i<j) {
            int sum = (i+1)*(i+1) + (j+1)*(j+1);
            if (sum==n) {
                return true;
            } else if(sum<n) {
                i++;
            } else {
                j--;
            }
        }
        Math.sqrt(7);
        return false;

        // 时间复杂度：O(n)
        // 空间复杂度：O（1）

    }

    public static void main(String[] args) {

        System.out.println(judgeSquareSum(9));
    }
}
