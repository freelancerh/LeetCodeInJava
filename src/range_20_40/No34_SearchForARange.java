package range_20_40;

public class No34_SearchForARange {
	public int[] searchRange(int[] nums, int target) {
        int low = 0; 
        int high = nums.length - 1;
        while(low <= high){
        	int mid = low + (high-low)>>1;
        	if(nums[mid] == target){
        		int i = mid;
        		int j = mid;
        		while(i>=low&&nums[i]==target || j<=high&&nums[j]==target){
        			if(i>=low&&nums[i]==target)
        				i--;
        			if(j<=high&&nums[j]==target){
        				j++;
        			}
        		}
        		return new int[]{i+1, j-1};
        	}
        	if(nums[mid] > target){
        		high = mid-1;
        	}
        	else{
        		low = mid+1;
        	}
        }
        
        return new int[]{-1, -1};
    }
	
	public static void main(String[] args){
		new No34_SearchForARange().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
	}
	
}
