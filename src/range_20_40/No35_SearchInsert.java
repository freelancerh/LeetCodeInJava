package range_20_40;

public class No35_SearchInsert {
	public int searchInsert(int[] nums, int target) {
        if(nums==null){
        	return -1;
        }
        int low = 0;
        int high = nums.length-1;
        if(nums[low] > target)
        	return 0;
        if(nums[high] < target)
        	return high;
        while(low < high){
        	int mid = low + (high-low)/2;
        	if(nums[mid] == target){
        		return mid;
        	}
        	if(nums[mid] < target){
        		low = mid+1;
        	}
        	else{
        		high = mid;
        	}
        }
        return high;
    }
	
	public static void main(String[] args){
		new No35_SearchInsert().searchInsert(new int[]{1,3,5,6}, 5);
	}
	
}
