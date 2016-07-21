package FourtyToSixty;

import java.util.ArrayList;
import java.util.List;

public class FourtySix_Permutations {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		List<Integer> tempList = new ArrayList<Integer>();
		List<Integer> numsList = new ArrayList<Integer>();
		for(int i=0; i<nums.length; i++){
			numsList.add(nums[i]);
		}
		findPermutations(list, tempList, numsList);
		return list;
    }
	
	public void findPermutations(List<List<Integer>> list, List<Integer> tempList, List<Integer> nums){
		if(nums.size() < 1){
			list.add(new ArrayList(tempList));
		}
		else{
			for(int i=0; i<nums.size(); i++){
				int temp = nums.remove(0);
				tempList.add(temp);
				findPermutations(list ,tempList, nums);
				tempList.remove((Object)temp);
				nums.add(temp);
			}
		}
	}
	
}
