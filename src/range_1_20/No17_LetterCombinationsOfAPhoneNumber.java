package range_1_20;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class No17_LetterCombinationsOfAPhoneNumber {
	static HashMap<Character, String[]> map = new HashMap<Character, String[]>();
	List<String> list = new ArrayList<String>();
	public List<String> letterCombinations(String digits) {
		map = new HashMap<Character, String[]>();
		map.put('2', new String[]{"a","b","c"});
		map.put('3', new String[]{"d","e","f"});
		map.put('4', new String[]{"g","h","i"});
		map.put('5', new String[]{"j","k","l"});
		map.put('6', new String[]{"m","n","o"});
		map.put('7', new String[]{"p","q","r","s"});
		map.put('8', new String[]{"t","u","v"});
		map.put('9', new String[]{"w","x","y","z"});
		if(digits.length() == 0)
			return list;
		combine(digits,"");
		return list;
    }
	
	public void combine(String digits, String combineStr){
		if(digits.length() == 0){
			list.add(combineStr);
			return;
		}
		char temp = digits.charAt(0);
		String[] tempList = map.get(temp);
		for(String str : tempList){
			combine(digits.substring(1, digits.length()), combineStr+str);
		}
	}
	
	public static void main(String[] args){
		No17_LetterCombinationsOfAPhoneNumber obj = new No17_LetterCombinationsOfAPhoneNumber();
		obj.letterCombinations("3");
		for(String str : obj.list){
			System.out.println(str);
		}
	}
	
}
