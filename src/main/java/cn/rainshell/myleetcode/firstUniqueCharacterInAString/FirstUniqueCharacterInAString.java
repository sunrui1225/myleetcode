package cn.rainshell.myleetcode.firstUniqueCharacterInAString;

import java.util.HashMap;
import java.util.Map;

/**
 * 387. 字符串中的第一个唯一字符
 * 思路：利用map，两次循环字符串数组
 * @author jason
 * @date 2020/11/10
 */
public class FirstUniqueCharacterInAString {

    public int firstUniqChar(String s) {
        if(s == null) {
            return 0;
        }
        Map map = new HashMap<Character, Integer>(26);

        for(char c : s.toCharArray()) {

            if(map.get(c)==null) {
                map.put(c, 1);
            } else {
                map.computeIfPresent(c, (key, value) -> (Integer)value + 1);
            }
        }

        for (int i=0; i<s.length(); i++) {
           if(map.get(s.charAt(i)).equals(1)) {
               return i;
           }
        }
        return -1;
    }
}
