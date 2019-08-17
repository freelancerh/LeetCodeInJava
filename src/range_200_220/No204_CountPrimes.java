package range_200_220;

/**
 * 动态规划
 */
public class No204_CountPrimes {
    public int countPrimes(int n) {
        if (n == 0){
            return 0;
        }

        if (n == 1){
            return 0;
        }

        int count = 0;
        boolean[] result = new boolean[n + 1];
        int middle = n / 2;
        for (int i = 2; i <= middle; i++){
            for (int j = i; j <= middle; j++){
                if (i * j <= n){
                    if (!result[i * j]){
                        result[i * j] = true;
                        count++;
                    }

                    continue;
                }

                break;
            }

            if (i * i > n){
                break;
            }
        }

        if (result[n]){
            return n - count - 1;
        } else {
            return n - count - 2;
        }
    }

    public static void main(String[] args) {
        new No204_CountPrimes().countPrimes(100);
    }
}
