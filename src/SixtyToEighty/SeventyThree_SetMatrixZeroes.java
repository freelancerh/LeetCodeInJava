package SixtyToEighty;

public class SeventyThree_SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
    	if(matrix == null)
    		return ;
    	int rowLen = matrix.length;
    	int colLen = matrix[0].length;
    	boolean flag = false;
        for(int i=0; i<rowLen; i++){
        	if(matrix[i][0] == 0)
        		flag = true;
        	for(int j=1; j<colLen; j++){
        		if(matrix[i][j] == 0){
        			matrix[i][0] = 0;
        			matrix[0][j] = 0;
        		}
        	}
        }
        for(int i=rowLen-1; i>-1; i--){
        	for(int j=colLen-1; j>0; j--){
        		if(matrix[i][0]==0 || matrix[0][j]==0){
        			matrix[i][j] = 0;
        		}
        	}
        	if(flag)
        		matrix[i][0] = 0;
        }
        
        
    }
}
