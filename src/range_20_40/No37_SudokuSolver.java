package range_20_40;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class No37_SudokuSolver {
    public void solveSudoku(char[][] board) {
        doSolveSudoku(board, 0, 0);
    }

    public boolean doSolveSudoku(char[][] board, int startRow, int startCol){
        for (int i = startRow; i < board.length; i++, startCol = 0){
            for (int j = startCol; j < board.length; j++){
                if (board[i][j] == '.'){
                    for (char num = '1'; num <= '9'; num++) {
                        if (isValid(i, j, board, num)){
                            board[i][j] = num;
                            if (doSolveSudoku(board, startRow, startCol)){
                                return true;
                            } else {
                                board[i][j] = '.';
                            }
                        }
                    }

                    return false;
                }
            }
        }

        return true;
    }

    public boolean isValid(int row, int col, char[][] board, char num){
        for (int i = 0; i < board.length; i++){
            if (num == board[i][col] || num == board[row][i]){
                return false;
            }
        }

        int cellRowStart = row / 3 * 3;
        int cellColStart = col / 3 * 3;

        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                if (board[cellRowStart + i][cellColStart + j] == num){
                    return false;
                }
            }
        }

        return true;
    }

    public List<Character> pickExclusiveNumList(int row, int col, char[][] board){
        Set<Character> inclusiveNumSet = new HashSet<>();
        for (int i = 0; i < board.length; i++){
            if (board[i][col] != '.'){
                inclusiveNumSet.add(board[i][col]);
            }

            if (board[row][i] != '.'){
                inclusiveNumSet.add(board[row][i]);
            }
        }

        int cellRowStart = row / 3 * 3;
        int cellColStart = col / 3 * 3;

        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                if (board[cellRowStart + i][cellColStart + j] != '.'){
                    inclusiveNumSet.add(board[cellRowStart + i][cellColStart + j] );
                }
            }
        }

        List<Character> exclusiveNumList = new ArrayList<>();
        for (char i = '1'; i <= '9'; i++){
            if (!inclusiveNumSet.contains(i)){
                exclusiveNumList.add(i);
            }
        }

        return exclusiveNumList;
    }

    public static void main(String[] args) {
        char[][] borad = new char[][]{
                {'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}
        };

        new No37_SudokuSolver().solveSudoku(borad);
    }
}
