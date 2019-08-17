package range_100_120;

import java.util.ArrayList;
import java.util.List;

/**
 * 链表,数学,找规律
 */
public class No118_PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> boss = new ArrayList<List<Integer>>();
        if(numRows < 1)
            return boss;
        List<Integer> tmp = new ArrayList();
        tmp.add(1);
        boss.add(tmp);
        for(int i=1; i<numRows; i++){
            List<Integer> row = new ArrayList();
            row.add(1);
            int prev = tmp.get(0);
            for(int j=1; j<tmp.size(); j++){
                row.add(prev+tmp.get(j));
                prev = tmp.get(j);
            }
            row.add(1);
            boss.add(row);
            tmp = row;
        }
        return boss;
    }
}
