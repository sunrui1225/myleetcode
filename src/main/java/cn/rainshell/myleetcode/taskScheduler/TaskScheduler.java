package cn.rainshell.myleetcode.taskScheduler;

import com.google.gson.Gson;

import java.util.Arrays;

/**
 * 621. 任务调度器
 * 思路：贪心算法，n为冷却时间，那么就取n+1个字母为一轮来编排，因为n+1可以保证其中相同的字母可以保证n个冷却时间
 *        每一轮之后再倒叙排列再取值
 */
public class TaskScheduler {

    public static int leastInterval(char[] tasks, int n) {

        // 标下对应26个字母，值代表出现的次数
        int[] map = new int[26];
        for(char task : tasks) {
            map[task-'A']++;
        }

        // 降序排列，不用考虑字母是什么
        Arrays.sort(map);
        // 时间用数
        int time=0;
        while(map[25]>0) {
            // i是小于n的迭代
            int i=0;
            while(i<=n) {
                if(map[25]==0) {
                    break;
                }
                map[25-i]--;
                time++;
                i++;
            }
            Arrays.sort(map);
        }
        return time;
    }

    public static void main(String[] args) {
        char[] a = new char[]{'A','A','A','B', 'B','B'};
        int n = 2;

        System.out.print(new Gson().toJson(leastInterval(a, n)));
    }
}
