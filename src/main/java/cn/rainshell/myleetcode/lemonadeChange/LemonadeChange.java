package cn.rainshell.myleetcode.lemonadeChange;

/**
 * 860. 柠檬水找零
 * 思路：贪心，每一步都考虑局部最优解
 * 时间复杂度：O（n），空间复杂度：O（1）
 * @author jason
 * @date 2020/8/31
 */
public class LemonadeChange {

    public boolean lemonadeChange(int[] bills) {

        int five = 0;
        int ten = 0;
        for (int bill : bills) {

            if(bill == 5) {
                five++;
            } else if(bill == 10) {
                if(five==0) {
                    return false;
                }
                five--;
                ten++;
            } else {
                if(five>0 && ten>0) {
                    five--;
                    ten++;
                } else if(five >=3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
