package cn.rainshell.myleetcode.powxN;

/**
 * 50. Pow(x, n)
 * 思路：利用递归
 * 时间复杂度：O(logN)
 *
 */
public class PowxN {

    public double myPow(double x, int n) {
        long N = n;
        return N >= 0? calcValue(x, N) : 1 / calcValue(x, -N);
    }

    private double calcValue(double x, long n) {

        // terminator
        if(n == 0) {
            return 1;
        }
        //
        double y = calcValue(x, n/2);

        return n % 2 == 0 ? y * y : y * y * x;
    }

    public static void main(String[] args) {
//        输入：
//        2.00000
//                -2
//        输出：
//        2.00000
//        预期结果：
//        0.25

//        输入：
//        0.44528
//        0
//        输出：
//        0.44528
//        预期结果：
//        1.0
        PowxN p = new PowxN();
        System.out.println(p.myPow(0.44528, 0));
    }
}
