package OneToTwenty;

import java.util.HashSet;

public class Three_lengthOfLongestSubstring {
	public static int lengthOfLongestSubstring(String s) {
		int maxLen = 0;
		HashSet<Character>  hash = new HashSet<Character>();
		for(int i=0; i<s.length(); i++){
			for(int j=i; j<s.length(); j++){
				if(hash.contains(s.charAt(j))){
					break;
				}
				else{
					hash.add(s.charAt(j));
				}
			}
			if(maxLen < hash.size())
				maxLen = hash.size();
			hash.clear();
		}
        return maxLen;
    }
	
	public static int lengthOfLongestSubstring2(String s){
		int maxLen = 0;
		int i=0;
		int j=0;
		HashSet<Character> hash = new HashSet<Character> ();
		while(j < s.length()){
			if(!hash.contains(s.charAt(j))){
				hash.add(s.charAt(j++));
				maxLen = Math.max(maxLen, hash.size());
			}
			else{
				hash.remove(s.charAt(i++));
			}
		}
		return maxLen;
	}
	
	public static void main(String[] args){
		System.out.println(lengthOfLongestSubstring2("abcda"));
	}
}
