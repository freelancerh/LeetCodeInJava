package range_80_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 动态规划，问题分解
 */
public class No85_MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }

        int maxLength = matrix.length;
        int maxWidth  = matrix[0].length;
        int maxArea = 0;
        for (int m = maxWidth; m > 0; m--){
            for (int n = maxLength; n > 0; n--){
                if (maxArea >= m * n){
                    continue;
                }

                boolean found = false;
                for (int i = 0; i <= maxLength - n; i++){
                    for (int j = 0; j <= maxWidth - m; j++){
                        if (isRectangle(i, j, n, m, matrix)){
                            int area = m * n;
                            if (area > maxArea){
                                maxArea = area;
                            }

                            found = true;
                            break;
                        }
                    }

                    if (found){
                        break;
                    }
                }
            }
        }

        return maxArea;
    }

    private boolean isRectangle(int i, int j, int m, int n, char[][] matrix){
        for (int startRow = i; startRow < i + m; startRow ++){
            for (int startCol = j; startCol < j + n; startCol ++){
                if (matrix[startRow][startCol] == '0'){
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        char[][] matrix = new char[][]{{'1','0','1','1','0','1'},{'1','1','1','1','1','1'},{'0','1','1','0','1','1'},{'1','1','1','0','1','0'},{'0','1','1','1','1','1'},{'1','1','0','1','1','1'}};
        int area = new No85_MaximalRectangle().maximalRectangle3(matrix);
        System.out.println(area);
    }

    public int maximalRectangle2(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }

        int maxLength = matrix.length;
        int maxWidth  = matrix[0].length;
        List<List<Range>> colRangeList = new ArrayList<>();
        for (int i = 0; i < maxWidth; i++){
            colRangeList.add(new ArrayList<>());
            int start = 0;
            while (start < maxLength){
                while (start < maxLength && matrix[start][i] == '0'){
                    start ++;
                }

                int end = start;
                while (end < maxLength && matrix[end][i] == '1'){
                    end ++;
                }

                if (start == end && start == maxLength){
                    break;
                }

                Range range = new Range(start, end - 1, i ,i);
                List<Range> rangeList = colRangeList.get(i);
                rangeList.add(range);
                start = end;
            }
        }

        for (int i = 0; i < maxWidth; i++){
            if (i == 0){
                continue;
            }

            List<Range> rangeList = colRangeList.get(i);
            for (Range range : rangeList){
                Range leftRange;
                int left = range.left;
                while (left > 0 && (leftRange = getRange(colRangeList.get(left - 1), range)) != null){
                    left = leftRange.left;
                }

                range.left = left;
            }
        }

        for (int i = maxWidth-1; i > -1; i--){
            if (i == maxWidth-1){
                continue;
            }

            List<Range> rangeList = colRangeList.get(i);
            for (Range range : rangeList){
                Range rightRange;
                int right = range.right;
                while (right < maxWidth - 1 && (rightRange = getRange(colRangeList.get(right + 1), range)) != null){
                    right = rightRange.right;
                }

                range.right = right;
            }
        }

        int maxArea = 0;
        for (List<Range> rangeList : colRangeList){
            for (Range range : rangeList){
                if (range.getArea() > maxArea){
                    maxArea = range.getArea();
                }
            }
        }

        return maxArea;
    }

    public Range getRange(List<Range> rangeList, Range range){
        for (Range leftRange : rangeList){
            if (leftRange.include(range)){
                return leftRange;
            }
        }

        return null;
    }



    class Range{
        public int start;
        public int end;

        public int getArea(){
            return (end - start + 1) * (right - left + 1);
        }

        public Range(int start, int end, int left, int right) {
            this.start = start;
            this.end = end;
            this.left = left;
            this.right = right;
        }

        public boolean include(Range range){
            if (range.start >= start && range.end <= end){
                return true;
            }

            return false;
        }

        public int left;
        public int right;
    }

    public int maximalRectangle3(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }

        int maxLength = matrix.length;
        int maxWidth  = matrix[0].length;
        int[][] histogram = new int[maxLength][maxWidth];
        for (int i = 0 ; i < maxLength; i ++){
            for (int j = 0; j < maxWidth; j++){
                if (i == 0){
                    histogram[i][j] = matrix[i][j] == '1' ? 1 : 0;
                } else {
                    if (matrix[i][j] == '1' ){
                        histogram[i][j] = histogram[i-1][j] + 1;
                    } else {
                        histogram[i][j] = 0;
                    }
                }
            }
        }

        int maxArea = 0;
        for (int i = 0 ; i < maxLength; i++){
            int area = largestRectangleArea(histogram[i]);
            if (area > maxArea){
                maxArea = area;
            }
        }

        return maxArea;
    }

    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }

        int[] leftNumArr = new int[heights.length];
        leftNumArr[0] = -1;
        int[] rightNumArr = new int[heights.length];
        rightNumArr[heights.length - 1] = heights.length;

        for (int i = 1; i < heights.length; i++) {
            int p = i - 1;
            while (p > -1 && heights[p] >= heights[i]) {
                p = leftNumArr[p];
            }

            leftNumArr[i] = p;
        }

        for (int i = heights.length - 2; i > -1; i--) {
            int p = i + 1;
            while (p < heights.length && heights[p] >= heights[i]) {
                p = rightNumArr[p];
            }

            rightNumArr[i] = p;
        }

        int maxarea = 0;
        for (int i = 0; i < heights.length; i++) {

            int width = rightNumArr[i] - leftNumArr[i] - 1;
            int area = width * heights[i];
            if (maxarea < area) {
                maxarea = area;
            }
        }

        return maxarea;
    }
}
