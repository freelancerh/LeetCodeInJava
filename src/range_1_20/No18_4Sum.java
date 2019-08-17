package range_1_20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 指针
 */
public class No18_4Sum {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        for(int i=0; i<nums.length; i++){
        	if(i==0 || nums[i-1]!=nums[i])
        	for(int j=i+1; j<nums.length; j++){
        		if(j==i+1 ||nums[j-1]!=nums[j])
        		for(int k=j+1; k<nums.length; k++){
        			if(k==j+1 ||nums[k-1]!=nums[k])
        				for(int m=k+1; m<nums.length; m++){
        						if(nums[i]+nums[j]+nums[k]+nums[m] == target){
        							List<Integer> temp = new LinkedList<Integer>();
        							temp.add(nums[i]);
        							temp.add(nums[j]);
        							temp.add(nums[k]);
        							temp.add(nums[m]);
        							list.add(temp);
        							break;
        						}
        					}
        			}
        	}
        }
        return list;
    }
	
	public List<List<Integer>> fourSum1(int[] nums, int target) {
		Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        for(int i=0; i<nums.length; i++){
        	if(i==0 || nums[i-1]!=nums[i])
        	for(int j=i+1; j<nums.length; j++){
        		if(j==i+1 ||nums[j-1]!=nums[j]){
        			int low = j+1;
        			int high = nums.length - 1;
        			while(low < high){
        				int sum = nums[i] + nums[j] + nums[low] + nums[high];
        				if(sum == target){
        					List<Integer> temp = new LinkedList<Integer>();
							temp.add(nums[i]);
							temp.add(nums[j]);
							temp.add(nums[low]);
							temp.add(nums[high]);
							list.add(temp);
							while(low<high && nums[low]==nums[low+1])low++;
							while(low<high && nums[high]==nums[high-1])high--;
							low++;
							high--;
        				}
        				else if(sum < target){
        					low++;
        				}
        				else{
        					high--;
        				}
        			}
        		}
        	}
        }
        return list;
    }
}
