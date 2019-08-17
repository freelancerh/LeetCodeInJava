package range_1_20;

/**
 * 字符串，找规律
 */
public class No12_intToRoman {
	public static String intToRoman(int num) {
        String str = "";
        String[][] RomanNum = {{"0","I","II","III","IV","V","VI","VII","VIII","IX"},
        						{"0","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"},
        						{"0","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"},
        						{"0","M","MM","MMM"}};
        int divisor = 1000;
        int i = 3;
        int qutient = 0;
        while(i>-1){
        	qutient = num/divisor;
        	if(qutient != 0){
        		str += RomanNum[i][qutient];
        	}
        	num %=divisor;
        	divisor = divisor / 10;
        	i--;
        }
        return str;
    }
	
	public static void main(String[] args){
		System.out.println(intToRoman(93));
	}
}
