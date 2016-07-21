package FourtyToSixty;

import java.util.List;
import java.util.ArrayList;

public class FiftyTwo_NQueensII {
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
	 
	 public static void main(String[] args){
		 new FiftyOne_NQueens().solveNQueens(1);
	 }
}
