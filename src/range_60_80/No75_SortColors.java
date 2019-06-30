package range_60_80;
/* 方法一：先遍历一遍，统计各个颜色的个数，然后第二次遍历，设置顺序的颜色
 * 方法二： 设置首尾指针，0和2计数器即放置0和2的位置指针，碰到0或2时就将它放到相应的位置，当首尾指针碰撞时，排序结束
 * 方法三： 只需设置0，2计数器，然后从头遍历，碰到0和2时就将它放到相应的位置*/

public class No75_SortColors {
    public void sortColors(int[] nums) {
        int[] count = new int[3];
        for(int i : nums){
        	if(i == 0)
        		count[0]++;
        	else if(i == 1)
        		count[1]++;
        	else
        		count[2]++;
        }
        
        for(int i=0; i<nums.length; i++){
        	if(i < count[0])
        		nums[i] = 0;
        	else if(i <count[0] + count[1])
        		nums[i] = 1;
        	else 
        		nums[i] = 2;
        }
    }
    
    
    public void sortColors1(int[] nums){
    	if(nums == null)
    		return ;
    	int i = 0;
    	int j = nums.length - 1;
    	int count0 = 0;
    	int count2 = 0;
    	while(i < j){
    		if(nums[i] == 0){
    			swap(nums, i, count0);
    			count0++;
    			i++;
    		}
    		else if(nums[i] == 2){
    			swap(nums, i, nums.length-count2-1);
    			i++;
    			count2++;
    		}
    		
    		if(nums[j] == 0){
    			swap(nums, j, count0);
    			count0++;
    			j--;
    		}
    		else if(nums[j] == 2){
    			swap(nums, j, nums.length - count2 - 1);
    			count2++;
    			j--;
    		}
    		
    		if(nums[i]==1 && nums[j]==1){
    			i++;
    			j--;
    		}
    	}
    }
    
    public void sortColors2(int[] nums){
    	if(nums == null)
    		return ;
    	int count0 = 0;
    	int count2 = 0;
    	for(int i=0; i<nums.length; i++){
    		if(nums[i] == 0){
    			swap(nums, i, count0);
    			count0++;
    		}
    		else if(nums[i] == 2){
    			swap(nums, i, nums.length-count2-1);
    			count2++;
    			i--;
    		}
    	}
    }
    
    public void swap(int[] nums, int i, int j){
    	nums[i] = nums[i] + nums[j];
    	nums[j] = nums[i] - nums[j];
    	nums[i] = nums[i] - nums[j];
    }
}











