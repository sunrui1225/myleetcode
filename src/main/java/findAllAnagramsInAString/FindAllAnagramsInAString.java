package findAllAnagramsInAString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 438. 找到字符串中所有字母异位词
 * 思路：滑动窗口，注意模版的4个地方
 * @author jason
 * @date 2020/10/20
 */
public class FindAllAnagramsInAString {

    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> res = new ArrayList<>();
        int left = 0, right = 0;
        Map<Character, Integer> need = new HashMap<>(p.length());
        Map<Character, Integer> window = new HashMap<>(p.length());
        int valid = 0;

        for(char c : p.toCharArray()) {
            need.put(c, need.getOrDefault(c,0)+1);
        }

        while(right < s.length()) {
            char c = s.charAt(right);
            right++;

            if(need.containsKey(c)) {
                window.put(c, window.getOrDefault(c,0)+1);
                if(window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }
            while(right - left >= p.length()) {
                if(valid==need.size()) {
                    res.add(left);
                }
                char d = s.charAt(left);
                left++;

                if(need.containsKey(d)) {
                    if(window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d)-1);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        String s = "cbaebabacd";
//        String p = "abc";


        String s = "baa";
        String p = "aa";
//[0, 6]
        FindAllAnagramsInAString f = new FindAllAnagramsInAString();
        System.out.println(f.findAnagrams(s,p));
    }
}
