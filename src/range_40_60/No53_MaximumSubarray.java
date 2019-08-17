package range_40_60;

/**
 * 数组，找规律，动态规划
 */
public class No53_MaximumSubarray {
    public int maxSubArray(int[] nums) {
    	if(nums==null || nums.length<1)
    		return 0;
        int num = -10000000;
        int b = 0;
        for(int i=0; i<nums.length; i++){
        	if(b>0){
        		b = b + nums[i];
        	}
        	else{
        		b = nums[i];
        	}
        	if(b>num){
        		num = b;
        	}
        }
        return num;
    }	
}
