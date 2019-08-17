package range_40_60;

/**
 * 贪心，数组
 */
public class No45_JumpGameII {
	public int jump(int[] nums) {
		if(nums==null || nums.length < 2){
			return 0;
		}
        int start = 0;
        int end = nums.length-1;
        int count = 1;
        while(start < end){
        	if(nums[start]+start >=end)
        		break;
        	int maxLength = nums[start+1]+1;
        	int max = start+1;
        	for(int i=2; i<nums[start]+1 && start+i<end+1; i++){
        		int temp = nums[start+i]+i;
        		if(temp > maxLength){
        			max = start+i;
        			maxLength = temp;
        		}
        	}
        	start = max;
        	count++;
        }
        return count;
    }
	
	public static void main(String[] args){
		new No45_JumpGameII().jump(new int[]{4,1,1,3,1,1,1});
	}
}
