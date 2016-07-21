package OneToTwenty;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Thirteen_threeSum {
	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		for(int i=0; i<nums.length; i++){
			if(i==0 || nums[i-1]!=nums[i])
			for(int j=i+1; j<nums.length; j++){
				if(j==i+1 || nums[j]!=nums[j-1])
				for(int k=j+1; k<nums.length; k++){
					if(nums[i]+nums[j]+nums[k] == 0){
						List<Integer> threeNums = new ArrayList<Integer>();
						threeNums.add(nums[i]);
						threeNums.add(nums[j]);
						threeNums.add(nums[k]);
						list.add(threeNums);
						break;
					}
				}
			}
		}
		return list;
    }
	
	public static void main(String[] args){
		
	}
	
}
