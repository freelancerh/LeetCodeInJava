package range_40_60;

/**
 * 找规律，矩阵，数学
 */
public class No48_RotateImage {
	public void rotate(int[][] matrix) {
		if(matrix == null || matrix.length != matrix[0].length){
			return ;
		}
		int n = matrix.length;
        int[][] result = new int[n][n];
        for(int i=0; i<n; i++){
        	for(int j=0; j<n; j++){
        		result[j][n-1-i] = matrix[i][j];
        	}
        }
        for(int i=0; i<n; i++){
        	for(int j=0; j<n; j++){
        		matrix[i][j] = result[i][j];
        	}
        }
    }
	public void rotate2(int[][] matrix){
		if(matrix == null || matrix.length != matrix[0].length){
			return ;
		}
		int n=matrix.length;
		for(int i=0; i<n; i++){
			for(int j=i+1; j<n; j++){
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
		for(int i=0; i<n/2; i++){
			for(int j=0; j<n; j++){
				int temp = matrix[j][i];
				matrix[j][i] = matrix[j][n-i-1];
				matrix[j][n-i-1] = temp;
			}
		}
	}
}
