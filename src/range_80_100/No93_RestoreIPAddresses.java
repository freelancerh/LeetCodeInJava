package range_80_100;

import java.util.ArrayList;
import java.util.List;

/**
 * 递归
 */
public class No93_RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        restoreIpAddresses(result, "", s, 1);
        return result;
    }

    public void restoreIpAddresses(List<String> result, String ip, String str, int order){
        if (order == 5){
            result.add(ip);
            return;
        }

        int nextMaxLength = (4 - order) * 3;
        int nextMinLength = 4 - order;
        for (int i = 1; i < 4; i++){
            if (str.length() - i < nextMinLength || str.length() - i > nextMaxLength){
                continue;
            }

            if (i > 1 && str.charAt(0) == '0'){
                continue;
            }

            int value = Integer.valueOf(str.substring(0, i));
            if (value > 255){
                continue;
            }

            if (order == 4){
                restoreIpAddresses(result, ip.concat(str.substring(0, i)), str.substring(i), order + 1);
            } else {
                restoreIpAddresses(result, ip.concat(str.substring(0, i)).concat("."), str.substring(i), order + 1);
            }
        }
    }
}
