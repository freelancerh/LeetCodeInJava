package range_60_80;
/**
 * 递归，动态规划
 * 两种方法，一种递归，一种动态规划。注意递归的时候需要有个记录表，避免重复的递归，否则会出现Time Limit Exceeded
 * */
public class No62_UniquePaths {
    public int uniquePaths(int m, int n) {
    	if(m<1 || n<1)
    		return 0;
    	if(m==1 && n==1)
    		return 1;
    	int total = 0;
    	if(m-1 > 0)
    		total += uniquePaths(m-1, n);
    	if(n-1 > 0)
    		total += uniquePaths(m, n-1);
    	return total;
    }
    
    public int uniquePaths1(int m, int n) {
    	int[][] date = new int[m+1][n+1];
    	return uniquePathsAssist(m, n, date);
    }
    
    public int uniquePathsAssist(int m, int n, int[][] date){
    	if(m<1 || n<1)
    		return 0;
    	if(date[m][n] != 0)
    		return date[m][n];
    	if(m==1 || n==1){
    		date[m][n] = 1;
    		return date[m][n];
    	}
    	if(m-1 > 0)
    		date[m][n] += uniquePathsAssist(m-1, n, date);
    	if(n-1 > 0)
    		date[m][n] += uniquePathsAssist(m, n-1, date);
    	//date[n][m] = date[m][n];
    	return date[m][n];
    }
    
    public int uniquePathsDP(int m, int n) {
    	int[][] date = new int[m+1][n+1];
    	for(int i=1; i<m+1; i++){
    		date[i][1] = 1;
    	}
    	for(int i=1; i<n+1; i++){
    		date[1][i] = 1;
    	}
    	int i=2;
    	int j=2;
    	while(j<n+1){
    		for(int k=j; k<m+1; k++){
    			date[k][i] = date[k-1][i] + date[k][i-1];
    		}
    		j++;
    	}
    	return date[m][n];
    }
}
