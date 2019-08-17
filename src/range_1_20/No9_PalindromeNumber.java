package range_1_20;

/**
 * 数学，找规律
 */
public class No9_PalindromeNumber {
    public boolean isPalindrome(int x) {
        int tmp = x;
        int y = 0;
        while(x > 0){
            y = y*10 + x%10;
            x = x / 10;
        }
        if(tmp == y)
            return true;
        return false;
    }
}
