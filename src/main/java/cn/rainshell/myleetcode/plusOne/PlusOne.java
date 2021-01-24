package cn.rainshell.myleetcode.plusOne;

import com.google.gson.Gson;

/**
 * @Description 66. 加一
 * 思路：1，循环遍历每一位加一后，被10整除，如果余数不为0则直接返回
 *      2，如果余数为0考虑进位，如果第一位是9，则重新new一个长度加一的数组，值肯定是1和原来数组的长度个0
 * @Author rainshell
 * @Date 2021/1/24 下午2:31
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {
        for(int i=digits.length-1; i>=0; i--) {
            digits[i]++;
            digits[i]=digits[i]%10;
            if(digits[i] != 0) return digits;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    public static void main(String[] args) {
        PlusOne plusOne = new PlusOne();
        int[] a =  new int[]{9, 9, 9};
        System.out.println(new Gson().toJson(plusOne.plusOne(a)));
    }


}
