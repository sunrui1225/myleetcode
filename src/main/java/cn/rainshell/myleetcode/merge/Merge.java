package cn.rainshell.myleetcode.merge;

import com.google.gson.Gson;

/**
 * @author jason
 * @date 2020/7/16
 */
public class Merge {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int index1 = m-1;
        int index2 = n-1;
        int indexMerge = m + n -1;

        while(index1 >=0 || index2 >= 0) {
            if (index1 < 0 ) {
                nums1[indexMerge--] = nums2[index2--];
            } else if(index2 < 0) {
                nums1[indexMerge--] = nums1[index1--];
            } else if(nums1[index1] < nums2[index2]) {
                nums1[indexMerge--] = nums2[index2--];
            } else {
                nums1[indexMerge--] = nums1[index1--];
            }
        }

        // 时间复杂度O（n+m）
        // 空间复杂度O（1）

        // 一下这个下法有问题的，会导致数组越界访问
        //            while(index1 >=0 || index2 >= 0) {
//                if (index1 < 0 || nums1[index1] < nums2[index2]) {
//                    nums1[indexMerge--] = nums2[index2--];
//                } else if(index2 < 0 || nums1[index1]>=nums2[index2]) {
//                    nums1[indexMerge--] = nums1[index1--];
//                }
//            }


        // 这个写法是第一次写的
//            for(int i=0;i<n;i++) {
//                for(int j=0;j<m;j++) {
//                    if(nums2[i]<nums1[j]) {
//                        int temp = nums1[j];
//                        nums1[j] = nums2[i];
//                        nums2[i] = temp;
//                    }
//                }
//            }


    }    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};
        merge(nums1, 3, nums2, 3);
        System.out.println(new Gson().toJson(nums1));
//        Output: [1,2,2,3,5,6]
    }
}
