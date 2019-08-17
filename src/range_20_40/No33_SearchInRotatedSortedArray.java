package range_20_40;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

/**
 * 数组，查找，找规律
 */
public class No33_SearchInRotatedSortedArray {
	public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        while(low <= high){
        	int mid = low + (high-low)/2;
        	if(nums[mid] == target){
        		return mid;
        	}
        	if(nums[mid] >= nums[low]){
        		if(nums[mid]>target && nums[low]<=target){
        			high = mid - 1;
        		}
        		else{
        			low = mid + 1;
        		}
        	}
        	else{
        		if(nums[mid]<target && nums[high]>=target){
        			low = mid + 1;
        		}
        		else{
        			high = mid-1;
        		}
        	}
        }
        return -1;
    }
	
	public static void main(String[] args) throws FileNotFoundException{
		BufferedReader br =  new BufferedReader(new InputStreamReader(new FileInputStream("Main.java")));
	}
	
}
