package range_60_80;

/**
 * 动态规划
 */
public class No70_ClimbingStairs {
    public int climbStairs(int n) {
        if(n < 3)
            return n;
        int[] climb = new int[n+1];
        climb[0] = 0;
        climb[1] = 1;
        climb[2] = 2;
        for(int i=3; i<n+1; i++){
            climb[i] = climb[i-1] + climb[i-2];
        }
        return climb[n];
    }
}
