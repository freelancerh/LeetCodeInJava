package range_60_80;

public class No72_EditDistance {
    public int minDistance(String word1, String word2) {
    	if(word1.length() < 1)
    		return word2.length();
    	if(word2.length() < 1)
    		return word1.length();
        int[][] distance = new int[word1.length()+1][word2.length()+1];
        for(int i=1;i<word1.length()+1; i++){
        	distance[i][0] = i;
        }
        for(int j=1; j<word2.length()+1; j++){
        	distance[0][j] = j;
        }
        for(int i=1; i<word1.length()+1; i++){
        	for(int j=1; j<word2.length()+1; j++){
        		if(word1.charAt(i-1) == word2.charAt(j-1)){
        			distance[i][j] = distance[i-1][j-1];
        		}
        		else{
        			distance[i][j] = Math.min(Math.min(distance[i-1][j-1]+1, distance[i-1][j]+1), distance[i][j-1]+1);
        		}
        	}
        }
        return distance[word1.length()][word2.length()];
    }
    
    
    public static void main(String[] args){
    	new No72_EditDistance().minDistance("123","41234123");
    }
    
}
