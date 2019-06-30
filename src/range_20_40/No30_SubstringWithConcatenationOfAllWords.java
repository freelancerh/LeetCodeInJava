package range_20_40;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class No30_SubstringWithConcatenationOfAllWords {
	public static List<Integer> findSubstring(String s, String[] words) {
		if(words==null || s==null)
			return null;
		int sublen = words[0].length();
        int len = sublen*words.length;
        List<Integer> list = new ArrayList<Integer>();
        for(int i=0; i<s.length()-len; i++){
        	String str = s.substring(i, i+len);
        	int j=0;
        	for(; j<words.length; j++){
        		if(str.contains(words[j])){
        			int place = str.indexOf(words[j]);
        			str = str.substring(0, place)+str.substring(place+sublen);
        		}
        		else{
        			break;
        		}
        		
        	}
        	if(j == words.length){
        		list.add(i);
        		i=i+len;
        	}
        }
        return list;
    }
	
	public static List<Integer> findSubstring1(String s, String[] words){
		if(words==null || s==null)
			return null;
		int sublen = words[0].length();
		int len = sublen*words.length;
		List<Integer> list = new ArrayList<Integer>();
		Map<String, Integer> map = new HashMap<String, Integer>();
		for(int i=0; i<words.length; i++){
			map.put(words[i], map.containsKey(words[i]) ? map.get(words[i])+1 : 1);
		}
		for(int i=0; i<s.length()-len; i++){
			Map<String, Integer> copy = new HashMap<String, Integer>(map);
			for(int j=0; j<words.length; j++){
				String str = s.substring(i+j*sublen, i+j*sublen+sublen);
				if(copy.containsKey(str)){
					if(copy.get(str) > 1){
						copy.put(str, copy.get(str)-1);
					}
					else{
						copy.remove(str);
					}
					if (copy.isEmpty()) { // matches
						list.add(i);
	                    break;
	                }
				}
				else{
					break;
				}
			}
			/*if(copy.isEmpty()){
				list.add(i);
				i=i+len;
			}*/
		}
		return list;
	}
	
	public static void main(String[] args){
		findSubstring("barfoothefoobarman",new String[]{"foo","bar"});
	}
}
