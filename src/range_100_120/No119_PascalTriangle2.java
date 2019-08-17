package range_100_120;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 链表,数学,找规律
 */
public class No119_PascalTriangle2 {
    public BigDecimal factorial(int n, int r){
        BigDecimal count = new BigDecimal(1);
        while(r>0){
            count = count.multiply(new BigDecimal(n));
            n--;
            r--;
        }
        return count;
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<Integer>();
        int len = 0;
        if(rowIndex%2 == 0){
            len = (rowIndex+1)/2 +1;
        }
        else{
            len = (rowIndex+1)/2;
        }
        int[] arr = new int[len];
        for(int i=0; i<len; i++){
            BigDecimal num = factorial(rowIndex, i).divide(factorial(i, i));
            arr[i] = num.intValue();
            list.add(arr[i]);
        }
        if((rowIndex+1)%2 == 0){
            for(int i=len-1; i>-1; i--){
                list.add(arr[i]);
            }
        }
        else{
            for(int i=len-2; i>-1; i--){
                list.add(arr[i]);
            }
        }
        return list;
    }
}
