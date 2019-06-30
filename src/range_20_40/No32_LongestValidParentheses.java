package range_20_40;

public class No32_LongestValidParentheses {
	public static int longestValidParentheses(String s) {
		if(s==null || s.length()<2){
			return 0;
		}
		int len = s.length();
        boolean[][] isValid = new boolean[len][len];
        int max = 0;
        for(int i=0; i<len-1; i++){
        	if(s.charAt(i)=='(' && s.charAt(i+1)==')'){
        		isValid[i][i+1] = true;
        		max = 2;
        	}
        	else{
        		isValid[i][i+1] = false;
        	}
        }
        
        for(int r=3; r<len; r+=2){
        	for(int i=0; i<len-r; i++){
        		if((isValid[i][i+r-2]&&s.charAt(i+r-1)=='('&&s.charAt(i+r)==')') || (isValid[i+1][i+r-1]&&s.charAt(i)=='('&&s.charAt(i+r)==')') || (isValid[i+2][i+r]&&s.charAt(i)=='('&&s.charAt(i+1)==')')){
        			isValid[i][i+r] = true;
        			max = r+1;
        		}
        		else{
        			isValid[i][i+r] = false;
        		}
        	}
        }
        return max;
    }
	
	public static int longestValidParentheses1(String s){
		if(s==null || s.length()<2){
			return 0;
		}
		int len = s.length();
		int[] dp = new int[len];
		int max = 0;
		for(int i=0; i<len; i++){
			dp[i] = 0;
		}
		for(int i=len-2; i>-1; i--){
			if(s.charAt(i) == '('){
				int j=i+1+dp[i+1];
				if(j < len && s.charAt(j) == ')'){
					dp[i] = dp[i+1]+2;
					if(j+1 < len)
						dp[i] += dp[j];
					if(dp[i] > max){
						max = dp[i];
					}
				}
			}
		}
		return max;
	}
	
	public static void main(String[] args){
		longestValidParentheses(")()())");
	}
	
}
