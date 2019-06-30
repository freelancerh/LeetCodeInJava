
package range_1_20;

public class No11_Container_With_Most_Water {
	// 每个点都循环一遍，以该点为中心，分成两边，从端点找起，一找到比该点高的点就是该点的最大容积
	public static int maxArea(int[] height) {
        int[] MAX = new int[height.length];
        int[] lIndex = new int[height.length];
        int[] rIndex = new int[height.length];
        int left;
        int right;
        for(int i=0; i<height.length; i++){
        	int l = 0;
        	int r = height.length-1;
        	while(l != r){
        		if(r-i > i-l){
        			if(height[r] >= height[i]){
        				MAX[i] = (r-i)*height[i];
        				rIndex[i] = r;
        				lIndex[i] = i;
        				break;
        			}
        			r--;
        		}
        		else{
        			if(height[l] >= height[i]){
        				MAX[i] = (i-l)*height[i];
        				lIndex[i] = l;
        				rIndex[i] = i;
        				break;
        			}
        			l++;
        		}
        	}
        }
        int max = MAX[0];
        int lindex = lIndex[0];
        int rindex = rIndex[0];
        for(int i=0; i<MAX.length; i++){
        	if(MAX[i] > max){
        		lindex= lIndex[i];
        		rindex = rIndex[i];
        		max = MAX[i];
        	}
        }
        System.out.println(lindex + " " + rindex);
        return max;
    }
	
	public static int maxArea2(int[] height) {
        int l = 0;
        int r = height.length-1;
        boolean place = height[l]>height[r] ? true : false;
        int minHeight = place ? height[r] : height[l];
        int max = (r-l)*Math.min(height[l], height[r]);
        if(place){
        	r--;
        }
        else{
        	l++;
        }
        while(l != r){
        	if(place){
        		if(height[r] > minHeight && (r-l)*Math.min(height[l], height[r]) >= max){
        			System.out.println("Max="+max+";L="+l+";R="+r);
        			max = (r-l)*Math.min(height[l], height[r]);
        			while(height[r] == height[l]){
        				r--;
        				l++;
        			}
        			place = height[l]>height[r] ? true : false;
        			minHeight = place ? height[r] : height[l];
        			
        		}
        		else{
        			r--;
        		}
        	}
        	else{
        		if(height[l] > minHeight && (r-l)*Math.min(height[l], height[r]) >= max){
        			System.out.println("Max="+max+";L="+l+";R="+r);
        			max = (r-l)*Math.min(height[l], height[r]);
        			while(height[r] == height[l]){
        				r--;
        				l++;
        			}
        			place = height[l]>height[r] ? true : false;
        			minHeight = place ? height[r] : height[l];
        		}
        		else{
        			l++;
        		}
        	}
        }
        return max;
    }
	
	public static int maxArea3(int[] height){
		return assistant(height, 0, height.length);
	}
	
	public static int maxArea4(int[] height){
		int l=0;
		int r=height.length-1;
		int max = (r-l)*Math.min(height[l], height[r]);
		while(l < r){
			max = Math.max(max, (r-l)*Math.min(height[l], height[r]));
			if(height[l] > height[r]){
				r--;
			}
			else{
				l++;
			}
		}
		return max;
	}
	
	public static int assistant(int[] height, int a, int b){
		int l = a;
		int r = b-1;
		if(b-a == 2){
			return Math.min(height[a], height[a+1]);
		}
		if(b-a == 1){
			return 0;
		}
		int max = Math.max(assistant(height, a, a+(b-a)/2) , assistant(height, a+(b-a)/2, b));
		int[] MAX = new int[b-a];
		for(int i=l; i<a+(b-a)/2; i++){
			int right = b-1;
			while(right >= a+(b-a)/2){
				if(height[i] <= height[right]){
					MAX[i-l] = (right-i)*height[i];
					break;
				}
				else{
					right--;
				}
			}
		}
		int temp = MAX[0];
        for(int i=0; i<MAX.length; i++){
        	if(MAX[i] > temp){
        		temp = MAX[i];
        	}
        }
		for(int i=b-1; i>=a+(b-a)/2; i--){
			int left = a;
			while(left < a+(b-a)/2){
				if(height[i] <= height[left]){
					MAX[i-l] = (i-left)*height[i];
					break;
				}
				else{
					left++;
				}
			}
		}
		for(int i=0; i<MAX.length; i++){
        	if(MAX[i] > temp){
        		temp = MAX[i];
        	}
        }
		return Math.max(temp, max);
	}
	   
	public static void main(String[] args){
		int[] data = {136,114,104,156,183,152,66,189,116,94,90,58,10,131,67,85,183,174,174,135,88,79,19,0,15,28,96,95,35,174,38,171,88,142,80,24,95,146,13,163,192,103,21,154,187,40,40,122,167,166,58,7,46,77,7,13,58,56,109,93,182,99,17,23,194,97,47,89,195,12,4,188,68,26,142,7,18,134,129,185,101,187,144,99,17,104,112,75,160,173,120,142,73,89,165,67,138,164,108,134};
		
		System.out.println(maxArea4(data));
		System.out.println(assistant(data, 0, data.length));
	}
	
}
