package range_80_100;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 递归，二叉树
 */
public class No87_ScrambleString {
    public boolean isScramble2(String s1, String s2) {
        if (s1 == null || s2 == null){
            if (s1 ==null && s2 == null){
                return true;
            }

            return false;
        }

        Set<String> scrambleSet = getAllScrambleString(s1, new HashMap<>());
        return scrambleSet.contains(s2);
    }

    public Set<String> getAllScrambleString(String str, HashMap<String, Set<String>> temp){
        if (str == null || str.length() == 0){
            return new HashSet<>();
        }

        if (temp.containsKey(str)){
            return temp.get(str);
        }

        Set<String> result = new HashSet<>();
        if (str.length() == 1){
            result.add(str);
            return result;
        }

        for (int i = 1; i < str.length(); i++){
            Set<String> preSet = getAllScrambleString(str.substring(0, i), temp);
            Set<String> nestSet = getAllScrambleString(str.substring(i), temp);

            for (String pre : preSet){
                for (String next : nestSet){
                    result.add(pre.concat(next));
                    result.add(next.concat(pre));
                }
            }
        }

        temp.put(str, result);
        return result;
    }



    public boolean isScramble(String s1, String s2){
        return isScramble(s1, s2, new HashSet<>());
    }

    public boolean isScramble(String s1, String s2, Set<String> result) {
        if (s1 == null || s2 == null){
            if (s1 == null && s2 == null){
                return true;
            }

            return false;
        }

        String str = s1.concat(s2);
        if (result.contains(str)){
            return true;
        }

        if (s1.equals(s2)){
            result.add(str);
            return true;
        }

        Map<Character, Integer> letterMap = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            int s1Value = letterMap.computeIfAbsent(s1.charAt(i), k -> 0);
            letterMap.put(s1.charAt(i), s1Value + 1);

            int s2Value = letterMap.computeIfAbsent(s2.charAt(i), k -> 0);
            letterMap.put(s2.charAt(i), s2Value - 1);
        }

        for (int value : letterMap.values()){
            if (value != 0){
                return false;
            }
        }

        for (int i = 1; i < s1.length(); i++){
            if (isScramble(s1.substring(0, i), s2.substring(0, i), result) && isScramble(s1.substring(i), s2.substring(i), result) ||
            isScramble(s1.substring(0,i), s2.substring(s2.length() - i), result) && isScramble(s1.substring(i), s2.substring(0, s2.length() - i), result)){
                result.add(str);
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        boolean result = new No87_ScrambleString().isScramble("great", "tgrea");
        System.out.printf(result ? "true" : "false");
    }

}
