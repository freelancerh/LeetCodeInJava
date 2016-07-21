package SixtyToEighty;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class SeventyOne_SimplifyPath {
	
	public String simplifyPath1(String path){
		if(path == null)
			return null;
		Stack<String> stack = new Stack<String>();
		Set<String> set = new HashSet<String>(Arrays.asList("..",".",""));
		for(String str : path.split("/")){
			if(str.equals("..") && !stack.isEmpty()){
				stack.pop();
			}
			else if(!set.contains(str)){
				stack.push(str);
			}
		}
		String newPath = "";
		for(String str : stack){
			newPath = '/' + str + newPath;
		}
		return newPath.equals("") ? "/" : newPath;
	}
	
    public String simplifyPath(String path) {
        if(path == null)
        	return null;
        Stack<String> stack = new Stack<String>();
        String str = "";
        char ch;
        for(int i=0; i<path.length(); i++){
        	ch = path.charAt(i);
        	if(ch == '/' || i==path.length()-1){
        	   	if(i==path.length()-1  && ch!='/'){
        			str += ch;
        		}
        		if(str.equals("..")  && !stack.isEmpty()){
        			stack.pop();
        		}
        		else if(str.equals("") || str.equals(".") || str.equals("..")&&stack.isEmpty()){
        			str = "";
        			continue;
        		}
        		else{
        			stack.push(str);
        		}
        		str = "";
        	}
        	else{
        		str += ch;
        	}
        }
        str = "";
        if(stack.isEmpty()){
        	return "/";
        }
        while(!stack.isEmpty()){
        	str = '/' + stack.pop()+str;
        }
        return str;
    }
    
    
    public static void main(String[] args){
    	new SeventyOne_SimplifyPath().simplifyPath("/home/../../..");
    }
}
