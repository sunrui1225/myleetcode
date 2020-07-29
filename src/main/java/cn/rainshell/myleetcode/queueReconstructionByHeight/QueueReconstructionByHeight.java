package cn.rainshell.myleetcode.queueReconstructionByHeight;

import com.google.gson.Gson;

import java.util.*;

/**
 * @author jason
 * @date 2020/7/24
 */
public class QueueReconstructionByHeight {

    public static int[][] reconstructQueue(int[][] people) {

        if(people == null || people.length == 0 || people[0].length==0) {
            return new int[0][0];
        }
        Arrays.sort(people, (o1, o2) -> o1[0]==o2[0]?o1[1]-o2[1]:o2[0]-o1[0]);

        List<int[]> outPut = new LinkedList<>();
        for (int[] p : people) {
            if(p[1] > outPut.size()-1) {
                outPut.add(p);
            } else {
                outPut.add(p[1], p);
            }
        }
        int n = people.length;
        return outPut.toArray(new int[n][2]);
    }

    public static void main(String[] args) {

        int [][] people = new int[][]{{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
        System.out.println(new Gson().toJson(reconstructQueue(people)));
    }
}
