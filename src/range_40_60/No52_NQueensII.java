package range_40_60;

import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

/**
 * 递归，数学,找规律
 */
public class No52_NQueensII {
	 public int solveNQueens(int n) {
		  if(n<1){
			  return 0;
		  }
		  
	      List<String> list = new ArrayList<String>();
	      List<List<String>> all = new ArrayList<List<String>>();
	      for(int i=0; i<n; i++){
	    	  char[] str = new char[n];
	    	  for(int j=0; j<n; j++){
	    		  str[j] = '.';
	    	  }
	    	  list.add(new String(str));
	      }
	      findQueens(all, list, 0, n);
	      return all.size();
	 }
	 
	 public void findQueens(List<List<String>> all, List<String> list, int level, int n){
		 if(level == n){
			 all.add(new ArrayList<String>(list));
			 return;
		 }
		 String str = list.get(level);
		 for(int i=0; i<n; i++){
			 if(str.charAt(i)=='.' && judgeQueen(list, level, i, n)){
				char[] ch = str.toCharArray();
				ch[i] = 'Q';
				list.set(level, new String(ch));
				findQueens(all, list, level+1, n);
				list.set(level, str);
			 }
		 }
	 }
	 
	 public boolean judgeQueen(List<String> list, int level, int col, int n){
		 for(int i=0; i<level; i++){
			 if(list.get(i).charAt(col) == 'Q'){
				 return false;
			 }
		 }
		 
		 for(int i=level-1, j=col-1; i>-1&&j>-1; i--,j--){
			 if(list.get(i).charAt(j) == 'Q')
				 return false;
		 }
		 
		 for(int i=level-1, j=col+1; i>-1&&j<n; i--,j++){
			 if(list.get(i).charAt(j) == 'Q')
				 return false;
		 }
		 return true;
	 }

	private final Set<Integer> occupiedCols = new HashSet<Integer>();
	private final Set<Integer> occupiedDiag1s = new HashSet<Integer>();
	private final Set<Integer> occupiedDiag2s = new HashSet<Integer>();
	public int totalNQueens(int n) {
		return totalNQueensHelper(0, 0, n);
	}

	private int totalNQueensHelper(int row, int count, int n) {
		for (int col = 0; col < n; col++) {
			if (occupiedCols.contains(col))
				continue;
			int diag1 = row - col;
			if (occupiedDiag1s.contains(diag1))
				continue;
			int diag2 = row + col;
			if (occupiedDiag2s.contains(diag2))
				continue;
			// we can now place a queen here
			if (row == n-1)
				count++;
			else {
				occupiedCols.add(col);
				occupiedDiag1s.add(diag1);
				occupiedDiag2s.add(diag2);
				count = totalNQueensHelper(row+1, count, n);
				// recover
				occupiedCols.remove(col);
				occupiedDiag1s.remove(diag1);
				occupiedDiag2s.remove(diag2);
			}
		}

		return count;
	}
	 public static void main(String[] args){
		 new No51_NQueens().solveNQueens(1);
	 }
}
