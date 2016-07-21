package SixtyToEighty;

import java.util.Arrays;
/*
 * 这道题同样可以采用递归和动态规划的算法来解决，这里用的是递归的方法*/
public class SixtyFour_MinimumPathSum {
    public int minPathSum(int[][] grid) {
        if(grid == null)
        	return -1;
        int m = grid.length;
        int n = grid[0].length;
        int[][] date = new int[m+1][n+1];
        for(int[] row : date){
            Arrays.fill(row, -1);
        }
       
        date[1][1] = grid[m-1][n-1];
        return minPathAssist(m, n, grid, date);
    }
    
    public int minPathAssist(int m, int n, int[][] grid, int[][] date){
    	if(m<1 || n<1)
    		return -1;
    	if(date[m][n] != -1)
    		return date[m][n];	
    	int total = grid[grid.length-m][grid[0].length-n];
    	int right = 1000000;
    	int left = 1000000;
    	if(n-1 > 0){
    		right = minPathAssist(m, n-1, grid, date);
    	}
    	if(m-1 > 0){
    		left = minPathAssist(m-1, n, grid, date);
    	}
    	total += right>left? left:right;
    	date[m][n] = total;
    	return date[m][n];
    }
}
