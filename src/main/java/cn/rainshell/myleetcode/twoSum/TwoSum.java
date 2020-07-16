package cn.rainshell.myleetcode.twoSum;

import com.google.gson.Gson;

/**
 * TwoSortedSum
 * @author jason
 * @date 2020/7/13
 */
public class TwoSum {

    public static int[] twoSum(int[] n, int target) {
        if(n == null || n.length==0) {
            return null;
        }

        int i = 0;
        int j = n.length-1;
        while (i<j) {
            int sum = n[i]+n[j];
            if(sum==target) {
                return new int[]{i+1,j+1};
            } else if(sum<target) {
                i++;
            } else {
                j--;
            }
        }
        return new int[]{i,j};
    }

    public static void main(String[] args) {

        int[] n1 = new int[]{2,7,10,13};
        System.out.println(new Gson().toJson(twoSum(n1, 9)));

        int[] n2 = new int[]{1,2,7,10,13};
        System.out.println(new Gson().toJson(twoSum(n2, 9)));

    }
}
