package range_100_120;

/**
 * 字符串,动态规划
 */
public class No115_DistinctSubsequences {
    public int numDistinct(String s, String t) {
        if (s == null || t == null){
            return 0;
        }

        if (s.length() < t.length() || s.length() == t.length() && !s.equals(t)){
            return 0;
        }

        int[][] result = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i < s.length(); i++){
            result[i][0] = 1;
        }

        for (int i = 1; i < s.length() + 1; i++){
            for (int j = 1; j < t.length() + 1; j++){
                if (i < j){
                    continue;
                }

                if (s.charAt(i-1) == t.charAt(j-1)){
                    result[i][j] = result[i-1][j-1] + result[i-1][j];
                } else {
                    result[i][j] = result[i-1][j];
                }
            }
        }

        return result[s.length()][t.length()];
    }
}
