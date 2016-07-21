package SixtyToEighty;

public class SixtyThree_UniquePaths {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    	if(obstacleGrid==null || obstacleGrid[0]==null)
    		return 0;
    	int m= obstacleGrid.length;
    	int n= obstacleGrid[0].length;
    	int[][] date = new int[m+1][n+1];
    	if(obstacleGrid[m-1][n-1] == 0)
    	    date[1][1] = 1;
    	else
    	    return 0;
    	return uniquePathsAssist(m, n, date, obstacleGrid);
    }
    
    public int uniquePathsAssist(int m, int n, int[][] date,  int[][] obstacleGrid){
    	if(m<1 || n<1)
    		return 0;
    	if(date[m][n] != 0)
    		return date[m][n];
    	if(m-1>0 && obstacleGrid[m-2][n-1]==0)
    		date[m][n] += uniquePathsAssist(m-1, n, date, obstacleGrid);
    	if(n-1>0 && obstacleGrid[m-1][n-2]==0)
    		date[m][n] += uniquePathsAssist(m, n-1, date, obstacleGrid);
    	//date[n][m] = date[m][n];
    	return date[m][n];
    }
}
