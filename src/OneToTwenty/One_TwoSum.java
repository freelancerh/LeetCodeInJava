package OneToTwenty;

import java.util.HashMap;

public class One_TwoSum {
	
	public static int[] twoSum(int[] nums, int target) {
		int[] index = new int[2];
		for(int i=0; i<nums.length; i++){
			for(int j=i+1; j<nums.length; j++){
				if(nums[i]+nums[j] == target){
					index[0] = i+1;
					index[1] = j+1;
				}
			}
		}
        return index;
    }
	
	public static int[] twoSum2(int[] nums, int target){
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i=0; i<nums.length; i++){
			if(map.get(target - nums[i]) != null){
				int []index = {map.get(target-nums[i])+1, i+1};
				return index;
			}
			map.put(nums[i], i);
		}
		int[] defaultResult = {0, 0};
		return defaultResult;
	}
	
	public static void main(String[] args){
		int[] nums = {2, 7, 11, 15};
		int[] index = twoSum2(nums, 9);
		for(int i=0; i<index.length; i++){
			System.out.println(index[i]);
		}
	}
}
