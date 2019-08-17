package range_1_20;

import java.util.Stack;

/**
 * 栈
 */
public class No20_ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        int len = s.length();
        for(int i=0; i<len; i++){
            char ch = s.charAt(i);
            if(ch=='{' || ch=='[' || ch=='('){
                stack.push(ch);
            }
            else{
                if(stack.isEmpty())
                    return false;
                char top = stack.peek();
                if(ch=='}'){
                    if(top == '{'){
                        stack.pop();
                    }
                    else{
                        return false;
                    }
                }
                else if(ch==']'){
                    if(top == '['){
                        stack.pop();
                    }
                    else{
                        return false;
                    }
                }
                else if(ch==')'){
                    if(top == '('){
                        stack.pop();
                    }
                    else{
                        return false;
                    }
                }
            }
        }
        if(!stack.isEmpty())
            return false;
        return true;
    }
}
