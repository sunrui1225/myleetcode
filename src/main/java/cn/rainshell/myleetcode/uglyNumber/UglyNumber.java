package cn.rainshell.myleetcode.uglyNumber;

/**
 * 263. 丑数
 * 思路：任何丑数都能由 2^i * 3^j * 5^k 组成，所以循环用2，3，5整除最后入股商等于1即为true，1是丑数
 *
 */
public class UglyNumber {

    public boolean isUgly(int num) {

        if(num<=0) {
            return false;
        }

        int[] factors = new int[]{2,3,5};
        for(int factor : factors) {
            while(num % factor == 0) {
                num = num / factor;
            }
        }
        return num == 1;
    }

    public static void main(String[] args) {
        UglyNumber u = new UglyNumber();
        System.out.println(u.isUgly(7));
    }
}
