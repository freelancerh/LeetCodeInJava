package range_80_100;

/**
 * 动态规划
 */
public class No97_InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s1.length() == 0){
            if (s2 == null || s2.length() == 0){
                return s3 == null || s3.length() == 0;
            } else {
                return s2.equals(s3);
            }
        }

        if (s2 == null || s2.length() == 0){
            return s1.equals(s3);
        }

        if (s1.length() + s2.length() != s3.length()){
            return false;
        }

        boolean s1Equal = s3.charAt(0) == s1.charAt(0);
        boolean s2Equal = s3.charAt(0) == s2.charAt(0);
        if (s1Equal && s2Equal) {
            return isInterleave(s1.substring(1), s2, s3.substring(1)) ||
                    isInterleave(s1, s2.substring(1), s3.substring(1));
        }

        if (s1Equal) {
            return isInterleave(s1.substring(1), s2, s3.substring(1));
        }

        if (s2Equal) {
            return isInterleave(s1, s2.substring(1), s3.substring(1));
        }

        return false;
    }

    public boolean isInterleave2(String s1, String s2, String s3) {
        if (s1 == null || s1.length() == 0){
            if (s2 == null || s2.length() == 0){
                return s3 == null || s3.length() == 0;
            } else {
                return s2.equals(s3);
            }
        }

        if (s2 == null || s2.length() == 0){
            return s1.equals(s3);
        }

        if (s1.length() + s2.length() != s3.length()){
            return false;
        }

        boolean[][] result = new boolean[s1.length() + 1][s2.length() + 1];
        result[0][0] = true;
        for (int i = 1; i < s1.length() + 1; i++) {
            result[i][0] = result[i-1][0] && s1.charAt(i-1) == s3.charAt(i-1);
        }


        for (int i = 1; i < s2.length() + 1; i++) {
            result[0][i] = result[0][i-1] && s2.charAt(i-1) == s3.charAt(i-1);
        }

        for (int i = 1; i < s1.length() + 1; i++){
            for (int j = 1; j < s2.length() + 1; j++){
                result[i][j] = result[i-1][j] && s1.charAt(i-1) == s3.charAt(i + j - 1) ||
                               result[i][j-1] && s2.charAt(j-1) == s3.charAt(i + j - 1);
            }
        }

        return result[s1.length()][s2.length()];
    }


    public static void main(String[] args) {
        boolean result = new No97_InterleavingString().isInterleave2("aabcc", "dbbca", "aadbbcbcac");
        System.out.printf(result ? "true" :  "false");
    }
}
