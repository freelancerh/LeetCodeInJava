package range_40_60;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 字符串，数组，找规律，数学
 */
public class No49_GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
		if(strs==null || strs.length < 1){
			return null;
		}
        Arrays.sort(strs);
        List<List<String>> list = new ArrayList<List<String>>();
        List<String> innerList = new ArrayList<String>();
        Boolean flag = false;
        innerList.add(strs[0]);
        list.add(innerList);
        for(int i=1; i<strs.length; i++){
        	flag = false;
        	for(List<String> tempList : list){
        		if(isEqual(tempList.get(0), strs[i])){
        			tempList.add(strs[i]);
        			flag = true;
        			break;
        		}
        	}
        	if(!flag){
        		List<String> tempList = new ArrayList<String>();
        		tempList.add(strs[i]);
        		list.add(tempList);
        	}
        }
        return list;
    }
	
	public boolean isEqual(String str1, String str2){
		if(str1.length() != str2.length()){
			return false;
		}
		char[] arr1 = str1.toCharArray();
		char[] arr2 = str2.toCharArray();
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		for(int i=0; i<arr1.length; i++){
			if(arr1[i] != arr2[i]){
				return false;
			}
		}
		return true;
	}
	
	public static List<List<String>> groupAnagrams2(String[] strs){
		if(strs==null || strs.length < 1){
			return null;
		}
		Arrays.sort(strs);
		Map<Integer, String> map = new HashMap();
		for(int i=0; i<strs.length; i++){
			char[] arr = strs[i].toCharArray();
			Arrays.sort(arr);
			map.put(i, new String(arr));
		}
		Map<String, List<Integer>> map2 = new HashMap();
		List<Integer> temp = new ArrayList();
		temp.add(0);
		map2.put(map.get(0), temp);
		for(int i=1; i<strs.length; i++){
			if(map2.containsKey(map.get(i))){
				List<Integer> innerList= map2.get(map.get(i));
				innerList.add(i);
				map2.put(map.get(i), innerList);
			}
			else{
				List<Integer> temp1 = new ArrayList();
				temp1.add(i);
				map2.put(map.get(i), temp1);
			}
		}
		List<List<String>> list = new ArrayList<List<String>>();
		Math.round(123.3);
		for(String key : map2.keySet()){
			List<Integer> tempList = map2.get(key);
			List<String> innerList = new ArrayList<String>();
			for(int i : tempList){
				innerList.add(strs[i]);
			}
			list.add(innerList);
		}
       return list;
	}
	
	public static void main(String[] args){
		groupAnagrams2(new String[]{"and","dan"});
	}
}
