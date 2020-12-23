package cn.rainshell.myleetcode.groupAnagrams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  49. 字母异位词分组
 *  思路：
 *  利用map<String, List<String>来判断是否是同一个异位词，key是字母加上出现个数，value是List<String>同一种异位，例如
 *         a1b1c1  ["abc","cba","cab"]
 *         d1f2     ["dff","fdf"]
 *
 *  如何确定map中key，利用hash表（26个小写字母的int数组）
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs) {

            int[] counts = new int[26];
            char[] chars = str.toCharArray();
            for(char c : chars) {
                counts[c-'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<26;i++) {
                if(counts[i]>0) {
                    sb.append(i+'a').append(counts[i]);
                }
            }
            String key = sb.toString();
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }
}
