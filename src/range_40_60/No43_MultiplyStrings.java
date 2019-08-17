package range_40_60;

/**
 * 字符串，找规律，数学
 */
public class No43_MultiplyStrings {
	public static String multiply(String num1, String num2) {
        if(num1==null || num2==null){
        	return "";
        }
        int len1 = num1.length();
        int len2 = num2.length();
        char[] chArray = new char[len1+len2];
        for(int i=0; i<chArray.length; i++){
        	chArray[i] = '0';
        }
        //String str = new String(chArray);
        for(int i=len1-1; i>-1; i--){
        	int c = 0;
        	int a = num1.charAt(i)-'0';
        	int k = len2+i;
        	for(int j=len2-1; j>-1; j--, k--){
        		int temp = a*(num2.charAt(j)-'0')+c+chArray[k]-'0';
        		chArray[k] = (char) (temp%10+'0');
        		c = temp/10;
        	}
        	chArray[k] = (char) (c+'0');
        }
        int i=0;
        while(i<chArray.length && chArray[i]=='0'){
        	i++;
        }
        
        return i==chArray.length? "0" : new String(chArray).substring(i);
    }
	
	public static void main(String[] args){
		multiply("123", "23");
	}
	
}
