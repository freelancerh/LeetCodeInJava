package range_20_40;

import java.util.ArrayList;
import java.util.List;

public class No22_GenerateParentheses {
	public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        generate(n, n, list, "");
        return list;
    }
	
	public void generate(int left, int right, List<String> list, String str){
		if(left==0 && right==0){
			list.add(str);
		}
		if(left > 0){
			generate(left-1, right, list, str+"(");
		}
		if(right>0 && right>left){
			generate(left, right-1, list, str+")");
		}
	}
	
	public static void main(String[] args){
		No22_GenerateParentheses exp = new No22_GenerateParentheses();
		exp.generateParenthesis(3);
	}
}
