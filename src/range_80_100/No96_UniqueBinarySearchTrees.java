package range_80_100;

/**
 * 动态规划
 */
public class No96_UniqueBinarySearchTrees {
    public int numTrees(int n) {
        int[] result = new int[n + 1];
        result[0] = 1;
        result[1] = 1;

        for (int m = 2; m < n + 1; m++){
            for (int i = 1; i <= m / 2; i++){
                result[m] += 2 * result[m-i] * result[i-1];
            }

            if (m % 2 == 1){
                result[m] += result[m/2] * result[m/2];
            }
        }

        return result[n];
    }
}
