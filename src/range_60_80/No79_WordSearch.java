package range_60_80;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class No79_WordSearch {
    static class Point{
        public int x;
        public int y;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        public Set<Integer> visitedPoint = new HashSet<>();
    }

    private int getHashCode(Object... objects){
        return Arrays.hashCode(objects);
    }

    public boolean exist(char[][] board, String word) {
        if (board == null || word == null || word.length() == 0){
            return false;
        }

        Stack<Point> stack = new Stack<>();
        Set<Integer> historyPointSet = new HashSet<>();
        for (int i= 0; i < board.length; i++){
            for (int j = 0; j < board[i].length; j++){
                if (board[i][j] == word.charAt(0)){
                    Point firstPoint = new Point(i, j);
                    stack.push(firstPoint);
                    historyPointSet.add(getHashCode(i, j));

                    int wordIndex = 1;
                    while (!stack.isEmpty()){
                        if (wordIndex == word.length()){
                            return true;
                        }

                        Point currentPoint = stack.peek();
                        if (currentPoint.x - 1 > -1 &&
                                !historyPointSet.contains(getHashCode(currentPoint.x - 1, currentPoint.y)) &&
                                !currentPoint.visitedPoint.contains(getHashCode(currentPoint.x - 1, currentPoint.y)) &&
                                board[currentPoint.x - 1][currentPoint.y] == word.charAt(wordIndex)) {
                            stack.push(new Point(currentPoint.x - 1, currentPoint.y));
                            int hashCode = getHashCode(currentPoint.x - 1, currentPoint.y);
                            historyPointSet.add(hashCode);
                            currentPoint.visitedPoint.add(hashCode);

                            wordIndex++;
                        } else if (currentPoint.x + 1 < board.length &&
                                !historyPointSet.contains(getHashCode(currentPoint.x + 1, currentPoint.y)) &&
                                !currentPoint.visitedPoint.contains(getHashCode(currentPoint.x + 1, currentPoint.y)) &&
                                board[currentPoint.x + 1][currentPoint.y] == word.charAt(wordIndex)) {
                            stack.push(new Point(currentPoint.x + 1, currentPoint.y));
                            int hashCode = getHashCode(currentPoint.x + 1, currentPoint.y);
                            historyPointSet.add(hashCode);
                            currentPoint.visitedPoint.add(hashCode);

                            wordIndex++;
                        } else if (currentPoint.y - 1 > -1 &&
                                !historyPointSet.contains(getHashCode(currentPoint.x, currentPoint.y-1)) &&
                                !currentPoint.visitedPoint.contains(getHashCode(currentPoint.x, currentPoint.y-1)) &&
                                board[currentPoint.x][currentPoint.y - 1] == word.charAt(wordIndex)) {
                            stack.push(new Point(currentPoint.x, currentPoint.y - 1));
                            int hashCode = getHashCode(currentPoint.x, currentPoint.y - 1);
                            historyPointSet.add(hashCode);
                            currentPoint.visitedPoint.add(hashCode);

                            wordIndex++;
                        } else if (currentPoint.y + 1 < board[i].length &&
                                !historyPointSet.contains(getHashCode(currentPoint.x, currentPoint.y+1)) &&
                                !currentPoint.visitedPoint.contains(getHashCode(currentPoint.x, currentPoint.y+1)) &&
                                board[currentPoint.x][currentPoint.y + 1] == word.charAt(wordIndex)) {
                            stack.push(new Point(currentPoint.x, currentPoint.y + 1));
                            int hashCode = getHashCode(currentPoint.x, currentPoint.y + 1);
                            historyPointSet.add(getHashCode(currentPoint.x, currentPoint.y + 1));
                            currentPoint.visitedPoint.add(hashCode);

                            wordIndex++;
                        } else {
                            historyPointSet.remove(getHashCode(stack.peek().x, stack.peek().y));
                            stack.pop();
                            wordIndex--;
                        }

                    }
                }
            }
        }

        return false;
    }
}
