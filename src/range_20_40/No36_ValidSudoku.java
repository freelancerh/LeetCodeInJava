package range_20_40;

import java.util.HashSet;
import java.util.Set;

/**
 * 数学，找规律，空间换时间
 */
public class No36_ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> set1 = new HashSet();
        Set<Character> set2 = new HashSet();
        Set<Character> set3 = new HashSet();
        Set<Character> set4 = new HashSet();
        Set<Character> set5 = new HashSet();
        for(int i=0; i<9; i++){
            if(i%3 == 0){
                set3.clear();
                set4.clear();
                set5.clear();
            }
            for(int j=0; j<9; j++){
                if(board[i][j] != '.'){
                    if(set1.contains(board[i][j]))
                        return false;
                    else{
                        set1.add(board[i][j]);
                    }
                }
                if(board[j][i] != '.'){
                    if(set2.contains(board[j][i]))
                        return false;
                    else{
                        set2.add(board[j][i]);
                    }
                }

                if(j/3==0 && board[i][j]!='.'){
                    if(set3.contains(board[i][j]))
                        return false;
                    else
                        set3.add(board[i][j]);
                }

                else if(j/3==1 && board[i][j]!='.'){
                    if(set4.contains(board[i][j]))
                        return false;
                    else
                        set4.add(board[i][j]);
                }

                else if(j/3==2 && board[i][j]!='.'){
                    if(set5.contains(board[i][j]))
                        return false;
                    else
                        set5.add(board[i][j]);
                }
            }
            set1.clear();
            set2.clear();
        }
        return true;
    }
}
