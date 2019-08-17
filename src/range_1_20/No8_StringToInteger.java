package range_1_20;

import java.util.HashSet;
import java.util.Set;

/**
 * 字符串，状态机
 */
public class No8_StringToInteger {
    public int myAtoi(String str) {
        if(str==null || str.length()<1)
            return 0;
        str = str.trim();
        Set<Character> set = new HashSet();
        for(int i=0; i<10; i++){
            set.add((char)(48+i));
        }
        int len = str.length();
        boolean negative = false;
        boolean start = false;
        int index = 0;
        long res = 0;
        if(str.charAt(0) == '-'){
            negative = true;
            index = 1;
        }
        else if(str.charAt(0) == '+'){
            index = 1;
        }
        for(int i=index; i<len; i++){
            char ch = str.charAt(i);
            if(!set.contains(ch)){
                if(!start)
                    return 0;
                if(start)
                    break;
            }
            else{
                start = true;
                if(negative){
                    res = res*10 - ch + 48;
                }
                else{
                    res = res*10 + ch - 48;
                }
                if(res > 2147483647)
                    return 2147483647;
                else if(res < -2147483648)
                    return -2147483648;
            }
        }

        return (int)res;
    }
}
