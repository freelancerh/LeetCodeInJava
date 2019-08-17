package range_80_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 找规律，回溯
 */
public class No89_GrayCode {
    public List<Integer> grayCode(int n) {
        if (n < 0){
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();
        result.add(0);
        for (int i = 0; i < n; i++){
           for (int j = result.size() - 1; j > -1; j--){
               result.add(1<<i + result.get(j));
           }
        }

        return result;
    }

    public static void main(String[] args) {
        new No89_GrayCode().grayCode(5);
    }
}