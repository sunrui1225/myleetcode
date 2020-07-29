package cn.rainshell.myleetcode.twoSumIIInputArrayIsSorted;

import com.google.gson.Gson;

/**
 * @author jason
 * @date 2020/7/14
 */
public class TwoSum2 {

    public static int[] sum(int[] n, int target) {
        if(n==null) {
            return null;
        }

        int i=0;
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
        return new int[]{i, j};
    }

    public static void main(String[] args) {

        int[] n1 = new int[]{1,2,7,10};
        System.out.println(new Gson().toJson(sum(n1, 9)));

        int[] n2 = new int[]{2,5,9,14};
        System.out.println(new Gson().toJson(sum(n2, 9)));
    }
}
