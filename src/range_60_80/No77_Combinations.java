package range_60_80;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No77_Combinations {
    public List<List<Integer>> combine(int n, int k) {
        if (n < k){
            return new ArrayList<>();
        }

        List<List<Integer>>[][] result = new ArrayList[n+1][k+1];

        for (int i = 0; i<= n; i++){
            result[i][0] = new ArrayList<>();
        }

        for (int i = 0; i<= k; i++){
            result[0][i] = new ArrayList<>();
        }

        for (int i=1; i <=n; i++){
            for (int j=1; j<=k; j++){
                if (j > i){
                    result[i][j] = new ArrayList<>();
                    continue;
                }

                result[i][j] = unionList(result[i-1][j], getCombine(i, result[i-1][j-1]));
            }
        }

        return result[n][k];
    }


    private List<List<Integer>> unionList(List<List<Integer>> list1, List<List<Integer>> list2){
        List<List<Integer>> result = new ArrayList<>();
        result.addAll(list1);
        result.addAll(list2);
        return result;
    }

    private List<List<Integer>> getCombine(int n, List<List<Integer>> combineList){
        List<List<Integer>> newCombineList = new ArrayList<>(combineList);
        if (newCombineList.size() == 0){
            newCombineList.add(new ArrayList<>());
            newCombineList.get(0).add(n);
            return newCombineList;
        }

        newCombineList = new ArrayList<>(combineList);
        for (int i = 0; i < newCombineList.size(); i++) {
            List<Integer> combine = new ArrayList<>(newCombineList.get(i));
            combine.add(n);
            newCombineList.set(i, combine);
        }

        return newCombineList;
    }


    public static void main(String[] args) {
        new No77_Combinations().combine(4, 2);
    }
}
