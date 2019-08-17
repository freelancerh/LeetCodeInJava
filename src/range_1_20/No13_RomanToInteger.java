package range_1_20;

import java.util.HashMap;
import java.util.Map;

/**
 * 字符串，找规律
 */
public class No13_RomanToInteger {
    public int romanToInt(String s) {
        Map<Character, Integer> change = new HashMap();
        change.put('I', 1);
        change.put('V', 5);
        change.put('X', 10);
        change.put('L', 50);
        change.put('C', 100);
        change.put('D', 500);
        change.put('M', 1000);
        int res = change.get(s.charAt(0));
        for(int i=1; i<s.length(); i++){
            int pre = change.get(s.charAt(i-1));
            int cur = change.get(s.charAt(i));
            if(pre >= cur)
                res +=cur;
            else
                res = res + cur - 2*pre;
        }
        return res;
    }
}
