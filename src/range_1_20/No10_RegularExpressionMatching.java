package range_1_20;

/**
 * 字符串，动态规划
 */
public class No10_RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null){
            if (s == null && p != null){
                return false;
            }

            if (s != null && p == null){
                return false;
            }

            return true;
        }

        if (s.equals(p)){
            return true;
        }

        int patternChIndex = 0;
        char patternChNextCh;
        for (int strIndex = 0; strIndex < s.length(); strIndex++){
            if (patternChIndex == p.length()){
                return false;
            }

            char patternCh = p.charAt(patternChIndex);
            if (s.charAt(strIndex) == patternCh){
                patternChIndex++;
                continue;
            }

            if (patternCh == '.'){
                patternChIndex++;
                continue;
            }

            if (patternCh == '*'){
                while (p.charAt(patternChIndex) == '*'){
                    if (++patternChIndex == p.length()){
                        return true;
                    }
                }

                patternChNextCh = p.charAt(patternChIndex);
                while (s.charAt(strIndex) != patternChNextCh){
                    if (++strIndex == s.length()){
                        return false;
                    }
                }

                patternChIndex++;
            }

            return false;
        }

        return true;
    }

    public boolean isMatch2(String s, String p) {

        System.out.println("s:" + s + "; p:" + p);

        if (s == null || p == null){
            if (s == null && p != null){
                return false;
            }

            if (s != null && p == null){
                return false;
            }

            return true;
        }

        if (s.equals(p)){
            return true;
        }

        int patternChIndex = 0;
        for (int strIndex = 0; strIndex < s.length(); ){
            if (patternChIndex >= p.length()){
                return false;
            }

            char patternCh = p.charAt(patternChIndex);

            if (patternChIndex + 1 == p.length() || p.charAt(patternChIndex + 1) != '*'){
                if (s.charAt(strIndex) == patternCh || patternCh == '.') {
                    patternChIndex++;
                    strIndex++;
                    continue;
                }

                return false;
            }

            if (patternCh != '.'){
                if (s.charAt(strIndex) != patternCh){
                    patternChIndex += 2;
                    continue;
                }

                while (strIndex < s.length()){
                    if (s.charAt(strIndex) == p.charAt(patternChIndex)){
                        if(isMatch2(s.substring(strIndex), p.substring(patternChIndex+2))){
                            return true;
                        }

                        strIndex++;
                        continue;
                    }

                    break;
                }

                patternChIndex += 2;
                continue;
            }

            while (patternChIndex + 1 < p.length()){
                if (p.charAt(patternChIndex) == '.' && p.charAt(patternChIndex + 1) == '*'){
                    patternChIndex += 2;
                }

                break;
            }

            if (patternChIndex == p.length()){
                return true;
            }

            while (strIndex < s.length()){
                if (isMatch2(s.substring(strIndex), p.substring(patternChIndex))) {
                    return true;
                }

                strIndex++;
            }
        }

        while (patternChIndex < p.length()){
            if (patternChIndex + 1 == p.length() || p.charAt(patternChIndex + 1) != '*'){
                return false;
            }

            patternChIndex += 2;
        }

        return true;
    }

    public boolean isMatchDp(String s, String p) {
        if (s == null || p == null){
            if (s == null && p != null){
                return false;
            }

            if (s != null && p == null){
                return false;
            }

            return true;
        }

        if (s.length() == 0){
            if (isEmpty(p)){
                return true;
            }

            return false;
        }

        if (p.length() == 0){
            return false;
        }

        if (s.equals(p)){
            return true;
        }

        boolean result[][] = new boolean[s.length()][p.length()];
        for (int i = 0; i < s.length(); i++){
            for (int j = 0; j < p.length(); j++){
                if (i == 0 && j == 0){
                    result[i][j] = isEqual(s.charAt(i), p.charAt(j));
                    continue;
                }

                if (j == 0){
                    if (i > 0){
                        result[i][j] = false;
                        continue;
                    }
                }

                if (i == 0){
                    if (p.charAt(j) != '*'){
                        result[i][j] = isEmpty(p.substring(0, j)) && isEqual(s.charAt(i), p.charAt(j));
                        continue;
                    }

                    result[i][j] = j > 1 && result[i][j-2] || isEmpty(p.substring(0, j - 1)) && isEqual(s.charAt(i), p.charAt(j-1));
                    continue;
                }

                if (p.charAt(j) != '*'){
                    result[i][j] = result[i-1][j-1] && isEqual(s.charAt(i), p.charAt(j));
                    continue;
                }

                result[i][j] = result[i-1][j] && isEqual(s.charAt(i), p.charAt(j-1)) || j > 1 && result[i][j-2];
            }
        }

        return result[s.length()-1][p.length()-1];
    }

    public boolean isEqual(char c, char p){
        if (c == p || p == '.'){
            return true;
        }

        return false;
    }

    public boolean isEmpty(String str){
        if (str == null || str.length() == 0){
            return true;
        }

        if (str.length() % 2 == 1){
            return false;
        }

       for (int i = 0; i < str.length(); i += 2){
           if (str.charAt(i + 1) != '*'){
               return false;
           }
       }

       return true;
    }

    public static void main(String[] args) {
        System.out.println(new No10_RegularExpressionMatching().isMatch2("abbaaaabaabbcba", "a*.*ba.*c*..a*.a*.") ? "true" : "false");
        System.out.println(new No10_RegularExpressionMatching().isMatchDp("abbaaaabaabbcba", "a*.*ba.*c*..a*.a*.") ? "true" : "false");
    }
}
