package range_1_20;

/**
 * 动态规划，字符串
 */
public class No5_LongestPalindrome {
	public static String longestPalindrome(String s) {
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
        int maxLen = 0;
        int start = 0;
        for(int i=0; i<s.length(); i++){
        	for(int j=0; j<s.length()-i; j++){
        		if(isPalindrome(s, j, j+i, isPalindrome)){
        			if(i > maxLen){
        				start = j;
        				maxLen = i;
        			}
        		}
        	}
        }
        return s.substring(start, start+maxLen+1);
    }
	
	public static boolean isPalindrome(String s, int i, int j, boolean[][] isPalindrome){
		if(i == j){
			isPalindrome[i][j] = true;
		}
		else if(i+1 == j){
			if(s.charAt(i) == s.charAt(j)){
				isPalindrome[i][j] = true;
			}
		}
		else{
			if(isPalindrome[i+1][j-1] && s.charAt(i)==s.charAt(j)){
				isPalindrome[i][j] = true;
			}
		}
		return isPalindrome[i][j];
	}
	
	public static void main(String[] args){
		System.out.println(longestPalindrome("abba"));
	}
}
