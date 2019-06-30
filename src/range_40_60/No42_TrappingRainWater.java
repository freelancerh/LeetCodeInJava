package range_40_60;

public class No42_TrappingRainWater {
	public int trap(int[] height) {
		if(height==null || height.length < 3){
			return 0;
		}
		int len = height.length;
		int total = 0;
		int[] place = new int[2];
        for(int i=1; i<len-1;){
        	if(height[i-1] < height[i] || height[i+1] < height[i]){
        		i++;
        	}
        	else{
        		place[0] = i-1;
        		place[1] = i+1;
        		find(height, i, place);
        		int min = Math.min(height[place[0]], height[place[1]]);
        		for(int j=place[0]+1; j<place[1]; j++){
        			total += (min-height[j]);
        		}
        		i=place[1]+1;
        	}
        }
        return total;
    }
	
	public void find(int[] height, int local, int[] place){
		int i = local-1;
		int j = local+1;
		while(i>0 || j<height.length-1){
			if(i!=0 && height[i-1] > height[i]){
				place[0] = i-1;
				i--;
			}
			else{
				i=0;
			}
			
			if(j!= height.length-1 && height[j+1] > height[j]){
				place[1] = j+1;
				j++;
			}
			else{
				j=height.length-1;
			}		
		}
		if(height[place[0]] > height[place[1]]){
			for(i=place[0];i<local-1;i++){
				if(height[i]>=height[place[1]] && height[i+1]<=height[place[1]]){
					place[0] = i;
					break;
				}
			}
		}
		else{
			for(j=place[1];j>local+1;j--){
				if(height[j]>=height[place[0]] && height[j-1]<=height[place[0]]){
					place[1] = j;
					break;
				}
			}
		}
	}
	
	public int trap2(int[] height){
		if(height==null || height.length<3){
			return 0;
		}
		int len = height.length;
		int max = height[0];
		int maxIndex = 0;
		int total = 0;
		for(int i=1; i<len; i++){
			if(height[i] > max){
				max = height[i];
				maxIndex = i;
			}
		}
		int tempMax = height[0];
		for(int i=1; i<maxIndex; i++){
			if(tempMax > height[i]){
				total += tempMax-height[i];
			}
			else{
				tempMax = height[i];
			}
		}
		tempMax = height[len-1];
		for(int i=len-2; i>maxIndex; i--){
			if(tempMax > height[i]){
				total += tempMax-height[i];
			}
			else{
				tempMax = height[i];
			}
		}
		return total;
	}
}
