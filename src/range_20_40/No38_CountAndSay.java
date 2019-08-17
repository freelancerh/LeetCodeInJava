package range_20_40;

/**
 * 找规律，字符串
 */
public class No38_CountAndSay {
    public String countAndSay(int n) {
        String result = "1";
        for(int i=0; i<n-1; i++){
            result = change(result);
        }
        return result;
    }
    public String change(String str){
        StringBuffer sbf = new StringBuffer("");
        int len = str.length();
        char prev = str.charAt(0);
        int count = 1;
        for(int i=1; i<len; i++){
            if(prev == str.charAt(i)){
                count++;
            }
            else{
                sbf.append(count);
                sbf.append(prev);
                count = 1;
                prev = str.charAt(i);
            }
        }
        sbf.append(count);
        sbf.append(prev);
        return sbf.toString();
    }
}
