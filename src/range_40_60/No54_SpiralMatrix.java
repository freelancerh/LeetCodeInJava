package range_40_60;
import java.util.*;

/**
 * 找规律，矩阵
 */
public class No54_SpiralMatrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
    	if(matrix==null || matrix.length<1){
    		return null;
    	}
        List<Integer> list = new ArrayList<Integer>();
        int level = 0;
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        if(rowLen==1 || colLen==1){
        	for(int i=0; i<rowLen; i++){
        		for(int j=0; j<colLen; j++){
        			list.add(matrix[i][j]);
        		}
        	}
        	return list;
        }
        int len = Math.min(rowLen, colLen);
        while(level < len-1){
        	for(int i=level; i<colLen-level; i++){
        		list.add(matrix[level][i]);
        	}
        	for(int i=level+1; i<rowLen-level; i++){
        		list.add(matrix[i][colLen-level-1]);
        	}
        	//防止重复计算rowLen-level-1由下方matrix[rowLen-level-1][i]得出
        	if(level != rowLen-level-1)
        	for(int i=colLen-level-2; i>level-1; i--){
        		list.add(matrix[rowLen-level-1][i]);
        	}
        	if(colLen-level-1 != level)
        	for(int i=rowLen-level-2; i>level; i--){
        		list.add(matrix[i][level]);
        	}
        	level++;
        }
        
        return list;
    }
    
    public static void main(String[] args){
    	spiralOrder(new int[][]{
    			{1,2,3,4},{5,6,7,8},{9,10,11,12}});
    }
}
