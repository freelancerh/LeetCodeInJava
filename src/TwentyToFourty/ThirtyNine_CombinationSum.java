package TwentyToFourty;

import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class ThirtyNine_CombinationSum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> list = new ArrayList<List<Integer>>(); 
		Arrays.sort(candidates);
		ArrayList<Integer> temp = new ArrayList<Integer>();
		find(target, candidates, list, temp, 0);
		return list;
    }
	
	public void find(int target, int[] candidates, List<List<Integer>> list, ArrayList<Integer> temp, int start){
		if(target == 0){
			list.add(new ArrayList<Integer>(temp));
		}
		else{
			for(int i=start; i<candidates.length; i++){
				if(candidates[i] <= target){
					temp.add(candidates[i]);
					find(target-candidates[i], candidates, list, temp, i);
					temp.remove(temp.indexOf(candidates[i]));
				}
				else{
					break;
				}
			}
		}
	}
	
}
