package range_40_60;

import java.util.HashSet;
import java.util.Set;

public class No44_WildcardMatching {

    public boolean isMatch(String s, String p){
        if (s == null || p == null){
            return s == null && p == null;

        }

        if (s.length() == 0 || p.length() == 0){
            if (s.length() == 0 && p.length() == 0){
                return true;
            }

            if (s.length() == 0){
                return isNull(p);

            }

            return false;
        }

        boolean[][] result = new boolean[s.length()][p.length()];
        result[0][0] = isEqual(s.charAt(0), p.charAt(0)) || p.charAt(0) == '*';
        if (p.charAt(0) == '*'){
            for (int i = 1; i < s.length(); i++){
                result[i][0] = true;
            }
        }

        for (int i = 1; i < p.length(); i++){
            if (p.charAt(i) == '*'){
                result[0][i] = result[0][i-1];
            }

            if (isEqual(s.charAt(0), p.charAt(i))){
                result[0][i] = isNull(p.substring(0, i));
            }
        }

        for (int i = 1; i < s.length(); i++){
            for (int j = 1; j < p.length(); j++){
                if (p.charAt(j) == '*'){
                    for (int k = i; k >= 0; k--){
                        if (result[k][j-1]){
                            result[i][j] = result[k][j-1];
                            break;
                        }
                    }
                } else {
                    result[i][j] = result[i-1][j-1] && isEqual(s.charAt(i), p.charAt(j));
                }
            }
        }

/*        for (int i = 0; i < s.length(); i++){
            for (int j = 0; j < p.length(); j++){
                System.out.print(result[i][j] + " ");
            }

            System.out.println();
        }*/

        return result[s.length()-1][p.length()-1];
    }

    private boolean isEqual(char ch, char patternCh){
        return ch == patternCh || patternCh == '?';
    }

    private boolean isNull(String pattern){
        for (char ch : pattern.toCharArray()){
            if (ch != '*'){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.printf(new No44_WildcardMatching().isMatch("babbbaabbaaaaabbababaaaabbbbbbbbbbabbaaaabbababbabaa", "**a****a**b***ab***a*bab") ? "true" : "false");
    }
}
