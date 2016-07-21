package FourtyToSixty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FourtySeven_PermutationsII {
	public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new LinkedList<List<Integer>>();
        List<Integer> tempList = new ArrayList<Integer>();
        List<Integer> numsList = new ArrayList<Integer>();
        for(int i : nums){
        	numsList.add(i);
        }
        find(list, numsList, tempList);
        return list;
    }
	public void find(List<List<Integer>> list, List<Integer> numsList, List<Integer> tempList){
		if(numsList.isEmpty()){
			list.add(new ArrayList(tempList));
		}
		else{
			for(int i=0; i<numsList.size(); i++){
				if(i==0 || numsList.get(i) != numsList.get(i-1)){
					int temp = numsList.get(i);
					tempList.add(temp);
					numsList.remove(i);
					find(list, numsList, tempList);
					tempList.remove(tempList.size()-1);
					numsList.add(i, temp);
				}
			}
		}
	}
}
