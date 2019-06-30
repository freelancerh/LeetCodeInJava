package range_20_40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No40_CombinationSumII {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		List<Integer> container = new ArrayList<Integer>();
		combination(candidates, target, list, container, 0);
		return list;
    }
	
	void combination(int[] candidates, int target, List<List<Integer>> list, List<Integer> container, int start){
		if(target == 0){
			list.add(new ArrayList<Integer>(container));
		}
		else{
			for(int i=start; i<candidates.length; i++){
				if(i==start || candidates[i]!=candidates[i-1]){
					if(target-candidates[i] >= 0){
						container.add(candidates[i]);
						combination(candidates, target-candidates[i], list, container, i+1);
						container.remove(container.indexOf(candidates[i]));
					}
					else{
						break;
					}
				}
				
			}
		}
	}
}
