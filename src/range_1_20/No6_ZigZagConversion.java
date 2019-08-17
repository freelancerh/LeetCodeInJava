package range_1_20;

/**
 * 字符串，找规律
 */
public class No6_ZigZagConversion {
    public String convert(String s, int numRows) {
        if(numRows < 2)
            return s;
        String[] res = new String[numRows];
        for(int i=0; i<numRows; i++)
            res[i] = "";
        int i=0;
        int j;
        int gap = numRows - 2;
        while(i < s.length()){
            for(j=0; j<numRows && i<s.length(); j++)
                res[j] += s.charAt(i++);
            for(j=gap; j>0 && i<s.length(); j--)
                res[j] += s.charAt(i++);
        }
        String result = "";
        for(int k=0; k<numRows; k++)
            result += res[k];
        return result;
    }
}
