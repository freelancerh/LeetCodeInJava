package OneToTwenty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sixteen_threeSumClosest {
	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int min = 10000;
		int realNum = 0;
		for(int i=0; i<nums.length-2; i++){
			if(i==0 || nums[i-1]!=nums[i])
			for(int j=i+1; j<nums.length-1; j++){
				if(j==i+1 || nums[j]!=nums[j-1])
				for(int k=j+1; k<nums.length; k++){
					if(Math.abs(nums[i]+nums[j]+nums[k] - target) < min){
						min = Math.abs(nums[i]+nums[j]+nums[k] - target);
						realNum = nums[i]+nums[j]+nums[k] - target;
					}
				}
			}
		}
		return realNum+target;
    }
}
