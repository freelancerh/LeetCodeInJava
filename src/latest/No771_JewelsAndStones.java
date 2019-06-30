package latest;

import java.util.HashSet;
import java.util.Set;

public class No771_JewelsAndStones {
    public int numJewelsInStones(String J, String S) {
        if (J == null || J.length() == 0){
            return 0;
        }

        if (S == null || S.length() == 0){
            return 0;
        }

        Set<Character> jewelTypeSet = new HashSet<>();

        for(char jewelType : J.toCharArray()){
            jewelTypeSet.add(jewelType);
        }

        int jewelCount = 0;
        for (char stone : S.toCharArray()){
            if (jewelTypeSet.contains(stone)){
                jewelCount ++;
            }
        }

        return jewelCount;
    }
}
