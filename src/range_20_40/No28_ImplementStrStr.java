package range_20_40;

/**
 * 指针，字符串
 */
public class No28_ImplementStrStr {
    public int strStr(String haystack, String needle) {
        int haylen = haystack.length();
        int needlelen = needle.length();
        if(needlelen < 1)
            return 0;
        for(int i=0; i<haylen-needlelen+1; i++){
            int j;
            for(j=0; j<needlelen; j++){
                if(haystack.charAt(j+i) != needle.charAt(j))
                    break;
            }
            if(j == needlelen)
                return i;
        }
        return -1;
    }
}
