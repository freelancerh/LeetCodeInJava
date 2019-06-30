package range_60_80;

public class No74_SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null)
        	return false;
        int low = 0;
        int high = matrix.length-1;
        while(low < high){
        	int middle = low + (high-low)/2;
        	if(matrix[middle][0] == target)
        		return true;
        	else if(matrix[middle][0] < target){
        		if(matrix[middle+1][0] <= target)
        			low = middle+1;
        		else
        			low = high = middle;
        	}
        	else
        		high = middle-1;
        }
        int row = low;
        low = 0;
        high = matrix[row].length-1;
        while(low <= high){
        	int middle = low + (high-low)/2;
        	if(matrix[row][middle] == target)
        		return true;
        	else if(matrix[row][middle] < target)
        		low = middle + 1;
        	else
        		high = middle - 1;
        }
        
        return false;
    }
    
    public static void main(String[] args){
    	new No74_SearchA2DMatrix().searchMatrix(new int[][]{{1},{3},{5}}, 4);
    }
}
