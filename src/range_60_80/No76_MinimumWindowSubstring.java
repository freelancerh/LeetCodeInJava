package range_60_80;

import java.util.HashMap;
import java.util.Map;

public class No76_MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if (s == null || t == null){
            return "";
        }

        if (s.length() == 0 || t.length() == 0){
            return "";
        }

        int start = 0;
        int end = 0;
        int counter = 0;
        int minLength = Integer.MAX_VALUE;
        int minStart = 0;
        Map<Character, Integer> map = new HashMap<>(t.length());
        for (char ch : t.toCharArray()){
            if (map.containsKey(ch)){
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }

        for (; end < s.length(); end++){
            if (map.containsKey(s.charAt(end))){
                map.put(s.charAt(end), map.get(s.charAt(end)) - 1);
                if (map.get(s.charAt(end)) >= 0){
                    counter++;
                }

                while (counter == t.length()){
                    if (end - start + 1 < minLength){
                        minStart = start;
                        minLength = end - start + 1;
                    }

                    if (map.containsKey(s.charAt(start))){
                        map.put(s.charAt(start), map.get(s.charAt(start)) + 1);
                        if (map.get(s.charAt(start)) > 0){
                            counter--;
                        }
                    }

                    start ++;
                }
            }
        }

        if (minLength == Integer.MAX_VALUE){
            return "";
        }

        return s.substring(minStart, minStart + minLength);
    }
}
