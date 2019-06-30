package range_40_60;

public class No55_JumpGame {
    public boolean canJump(int[] nums) {
    	if(nums==null || nums.length<1)
    		return false;
        return jump(0,nums);
    }
    
    public boolean jump(int place, int[] nums){
    	for(int i=nums[place]; i>0; i--){
    		int newPlace = i+place;
    		if(newPlace > nums.length)
    			continue;
    		else if(newPlace < nums.length){
    			return jump(newPlace, nums);
    		}
    		else{
    			return true;
    		}
    	}
    	return false;
    }
    
    public boolean canJump1(int[] nums){
    	int max = 0;
    	for(int i=0; i<nums.length; i++){
    		if(i>max)
    			return false;
    		max = Math.max(nums[i]+i, max);
    	}
    	return true;
    }
    
    public static void main(String[] args){
    	new No55_JumpGame().canJump(new int[]{2,3,1,1,4});
    }
}
