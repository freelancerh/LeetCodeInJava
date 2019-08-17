package range_80_100;

/**
 * 动态规划
 */
public class No91_DecodeWays {

    public int numDecodings(String s) {
        if (s == null){
            return 0;
        }

        return numDecodings(s.toCharArray(), 0, s.length());
    }

    public int numDecodings2(String s) {
        if (s == null){
            return 0;
        }

        int[] result = new int[s.length()];
        if (getNum(s.charAt(0)) == 0){
            return 0;
        }

        result[0] = 1;

        for (int i = 1; i < s.length(); i++){
            int currentNum = getNum(s.charAt(i));
            if (currentNum > 0 && currentNum < 10){
                result[i] += result[i-1];
            }

            int num = getNum(s.charAt(i-1)) * 10 + currentNum;
            if (num > 9 && num < 27){
                result[i] += i-2 > -1 ? result[i-2] : 1;
            }
        }

        return result[s.length() - 1];
    }

    public static void main(String[] args) {
        new No91_DecodeWays().numDecodings2("3510123");
    }

    public int numDecodings(char[] arr, int start, int end){
        if (start > end){
            return 0;
        }

        if (start == end ){
            return 1;
        }

        if (getNum(arr[start]) == 0){
            return 0;
        }

        if (end - start == 1){
            return 1;
        }


        int num = getNum(arr[start]) * 10 + getNum(arr[start + 1]);
        if (num > 26) {
            return numDecodings(arr, start + 1, end);
        } else {
            return numDecodings(arr, start + 1, end) + numDecodings(arr, start + 2, end);
        }
    }

    private int getNum(char ch){
        return ch - '0';
    }
}
