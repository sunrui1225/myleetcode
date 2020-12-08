package cn.rainshell.myleetcode.isomorphicStrings;

/**
 * 205. 同构字符串
 * 思路：用两个map，下标是 字母char对应数值，值是字符数组的下标+1，
 *      循环便利两个字符串数组，
 *          1）当在两个map中的值不一样，说明其中一个字母在它之前的出现过，例如 aba 和 tde  mapS[charsS[2]] = 1, mapT[charsT[2]] = 0
 *          2) 当一样
 *                （1）如果等于0，则记录在map中的下标加1，实际上就是，如 abc 和 tdf 是 123 和 123
 *                （2）如果不相等，说名是 之前都出现过的字母，如 aba 和 tdt
 * @author jason
 * @date 2020/12/8
 */
public class IsomorphicStrings {

    public boolean isIsomorphic(String s, String t) {

        if(s.length() != t.length() ) {
            return false;
        }

        int[] mapS = new int[128];
        int[] mapT = new int[128];

        char[] charsS = s.toCharArray();
        char[] charsT = t.toCharArray();

        int len = s.length();

        for(int i =0;i<len;i++) {
            if(mapS[charsS[i]] != mapT[charsT[i]]) {
                return false;
            } else {
                if(mapS[charsS[i]] == 0) {
                    mapS[charsS[i]] = i + 1;
                    mapT[charsT[i]] = i + 1;
                }
            }
        }
        return true;
    }
}
