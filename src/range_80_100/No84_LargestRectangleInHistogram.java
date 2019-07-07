package range_80_100;

import java.util.Arrays;

public class No84_LargestRectangleInHistogram {
    /**
     * heights case when element can move
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0){
            return 0;
        }

        Arrays.sort(heights);
        int maxArea = 0;
        int pointer = heights.length - 1;
        while (pointer > -1){
            while (pointer - 1 >= 0 && heights[pointer-1] == heights[pointer]){
                pointer--;
            }

            int area = (heights.length - pointer) * heights[pointer];
            if (area > maxArea){
                maxArea = area;
            }

            pointer--;
        }

        return maxArea;
    }

    public int largestRectangleArea2(int[] heights) {
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
