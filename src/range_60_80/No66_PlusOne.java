package range_60_80;

/**
 * 数组,数学,找规律
 */
public class No66_PlusOne {
    public int[] plusOne(int[] digits) {
        boolean flag = false;
        int len = digits.length;
        digits[len-1]++;
        for(int i=len-1; i>-1; i--){
            if(flag)
                digits[i]++;
            if(digits[i] == 10){
                digits[i] = 0;
                flag = true;
            }
            else{
                break;
            }
        }
        if(digits[0]==0){
            int[] newNum = new int[len+1];
            for(int i=len; i>0; i--){
                newNum[i] = digits[i-1];
            }
            newNum[0] = 1;
            return newNum;
        }
        return digits;
    }
}
