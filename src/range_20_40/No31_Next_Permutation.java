package range_20_40;

public class No31_Next_Permutation {
	public void nextPermutation(int[] nums) {
		if(nums==null || nums.length < 2)
			return;
        int i=nums.length-1;
        while(nums[i] <= nums[i-1] && i>-1){
        	i--;
        }
        if(i < 0){
        	i = 0;
        	int j = nums.length;
        	while(i!=j && j+1!=i){
            	int temp = nums[i];
            	nums[i] = nums[j];
            	nums[j] = temp;
            	i++;
            	j--;
            }
        	return;
        }
        int place = i-1;
        int j = nums.length-1;
        while(i!=j || i+1!=j){
        	int temp = nums[i];
        	nums[i] = nums[j];
        	nums[j] = temp;
        	i++;
        	j--;
        }
        for(i=place+1; i<nums.length; i++){
        	if(nums[i] > nums[place]){
        		int temp = nums[i];
        		nums[i] = nums[place];
        		nums[place] = temp;
        		break;
        	}
        }
        
    }
}
