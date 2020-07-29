package cn.rainshell.myleetcode.containerWithMostWater;

/**
 * @author jason
 * @date 2020/7/16
 */
public class ContainerWithMostWater {

    public static int maxArea(int[] height) {

        int result =0;
        int i=0;
        int j=height.length-1;
        while (i<j) {
            int sum = (j-i+1)* Math.min(height[i],height[j]);
            result = sum > result?sum:0;
            i++;j--;
        }
        return result;
    }

    public static void main(String[] args) {

        int[] height1 = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height1));
    }
}
