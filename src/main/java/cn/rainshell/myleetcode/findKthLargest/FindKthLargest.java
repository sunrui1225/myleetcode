package cn.rainshell.myleetcode.findKthLargest;

/**
 * @author jason
 * @date 2020/7/22
 */
public class FindKthLargest {

    public  static int findKthLargest(int[] nums, int k) {

        k = nums.length - k;
        int i = 0;
        int j = nums.length-1;
        while(i<j) {
            int x = partition(nums, i, j);
            if(x == k) {
                return nums[x];
            } else if(x < k) {
                i = x + 1;
            } else {
                j = x - 1;
            }
        }

        if(i == k ) {
            return nums[k];
        } else {
            return  0;
        }
    }

    /**
     * 挖坑填坑比较法
     * @param a
     * @param left
     * @param right
     * @return
     */
    public static int partition(int[] a, int left, int right) {

        int temp = a[left];
        while(left<right) {

            while(temp < a[right] && left < right) {
                right--;
            }
            // 这里的判断是看是否已经相等
            if(left < right) {
                a[left]=a[right];
                left++;
            }
            while(a[left]<=temp && left < right ) {
                left++;
            }
            if(left < right) {
                a[right]=a[left];
                right--;
            }
        }
        a[left] = temp;
        return left;
    }

    public static void main(String[] args) {


//        Input: [3,2,1,5,6,4] and k = 2
//        Output: 5

        int[] a = new int[]{3,2,1,5,6,4};
        int k = 2;
        System.out.println(findKthLargest(a, k));
    }
}
