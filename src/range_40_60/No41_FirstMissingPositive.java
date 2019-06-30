package range_40_60;

public class No41_FirstMissingPositive {
	public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        for(int i=0; i<len; i++){
        	while(nums[i]>0 && nums[i] !=i+1 && nums[i]<len && nums[nums[i]-1] != nums[i]){
        		int temp = nums[i];
        		nums[i] = nums[temp-1];
        		nums[temp-1] = temp;
        	}
        }
        for(int i=0; i<len; i++){
        	if(nums[i] != i+1){
        		return i;
        	}
        }
        return -1;
    }
}
