package range_40_60;
/**
 * 矩阵，找规律
 * 设置一个level来标识现在是第几轮循环，以此来构造matrix
 * */
public class No59_SpiralMatrix {
    public int[][] generateMatrix(int n) {
        if(n<1)
        	return new int[0][0];
    	int[][] matrix = new int[n][n];
    	int count = 1;
    	int level = 0;
    	while(level < (n+1)/2){
    		for(int i=level; i<n-level; i++){
    			matrix[level][i] = count++;
    		}
    		for(int i=level+1; i<n-level; i++){
    			matrix[i][n-level-1] = count++;
    		}
    		for(int i=n-level-2; i>level-1; i--){
    			matrix[n-level-1][i] = count++;
    		}
    		for(int i=n-level-2; i>level; i--){
    			matrix[i][level] = count++;
    		}
    		level++;
    	}
    	return matrix;
    }
    
    public static void main(String[] args){
    	new No59_SpiralMatrix().generateMatrix(1);
    }
}
