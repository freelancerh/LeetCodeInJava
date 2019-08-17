package range_1_20;

/**
 * 字符串
 */
public class No14_LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs==null || strs.length<1)
            return "";
        int arrayLen = strs.length;
        String commonPrefix = strs[0];
        for(int i=1; i<arrayLen; i++){
            while(strs[i].indexOf(commonPrefix) != 0)
                commonPrefix = commonPrefix.substring(0, commonPrefix.length()-1);
        }

        return commonPrefix;
    }
}
