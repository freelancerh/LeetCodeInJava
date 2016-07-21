package FourtyToSixty;

import java.util.Arrays;
/*
 * 第一种方法，使用nextPermutation方法来求第k个序列，但是所需时间长，会出现Time Limit Exceeded
 * 第二种方法，数学方法，通过k/(n-1)！求得第一位的数字，然后修改原始数组，修改k的值陆续求出后续的数字*/
public class Sixty_getPermutation {
	
	public String getPermutation1(int n, int k){
    	if(n<1 || k<1){
    		return "";
    	}
    	char[] nums = new char[n];
    	int nCount = 1;
    	String str = "";
    	for(int i=0; i<n; i++){
    		nums[i] = (char) ('1'+i);
    		nCount *= (i+1);
    	}
    	k--;
    	for(int i=0; i<n; i++){
    		nCount /= (n-i);
    		int place = k/nCount;
    		if(place > n-1){
    			return "";
    		}
    		str = str+nums[place];
    		for(int j=place; j<n-1; j++){
    			nums[j] = nums[j+1];
    		}
    		k %= nCount;
    	}
    	return str;
	}
	
    public String getPermutation(int n, int k) {
    	if(n<1 || k<1){
    		return "";
    	}
        char[] str = new char[n];
        for(int i=0; i<n; i++){
        	str[i] = (char) ('1'+i);
        }
        while(k>1){
        	str = nextPermutation(str);
        	k--;
        }
        return new String(str);
    }
    
    public char[] nextPermutation(char[] str){
    	int findPlace = -1;
    	for(int i=str.length-1; i>0; i--){
    		if(str[i]<str[i-1]){
    			findPlace = i-1;
    			break;
    		}
    	}
    	if(findPlace == -1)
    		return str;
    	for(int i=findPlace+1; i<str.length; i++){
    		if(str[findPlace]<str[i] && (i==str.length-1 ||str[findPlace]>str[i+1])){
    			char temp = str[findPlace];
    			str[findPlace] = str[i];
    			str[i] = temp;
    		}
    	}
    	int k = (str.length - findPlace + 1)/2;
    	while(k > 0){
			char temp = str[findPlace+k];
			str[findPlace+k] = str[str.length-k];
			str[str.length-k] = temp;
			k--;
    	}
    	return str;
    }
}
