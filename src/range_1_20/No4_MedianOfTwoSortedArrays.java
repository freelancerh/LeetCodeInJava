package range_1_20;

/*
 * �ҵķ�����������������λ������ʵ����Ҫ�������������ֱ�ָ��A��B����ͷ��ָ��ȥ�������飬Ȼ��ͳ��Ԫ�ظ������ɡ�*/
public class No4_MedianOfTwoSortedArrays {
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int[] nums = new int[nums1.length + nums2.length];
		int i=0;
		int j=0;
		int count=0;
		while(i<nums1.length || j<nums2.length){
			if(i<nums1.length && j<nums2.length){
				nums[count++] = nums1[i] > nums2[j]?nums2[j++]:nums1[i++];
			}
			else{
				nums[count++] = i>nums1.length-1?nums2[j++]:nums1[i++];
			}
			
		}
		if(nums.length%2 == 0){
			return (double)(nums[nums.length/2] + nums[nums.length/2 -1])/2;
		}
		else{
			return nums[nums.length/2];
		}
       
    }
	
	public static double findMedianSortedArrays2(int[] nums1, int[] nums2){
		int i=0;
		int j=0;
		int flag = (nums1.length+nums2.length)%2;
		int median = flag==1 ? (nums1.length+nums2.length)/2+1 : (nums1.length+nums2.length)/2;
		int count = 0;
		int nedianNum = 0;
		boolean arrayFlag = nums1.length==0 ? false : true;
		while(i<nums1.length || j<nums2.length){
			
			if(i<nums1.length && j<nums2.length){
				if(nums1[i] > nums2[j]){
					j++;
					arrayFlag = false;
				}
				else{
					i++;
					arrayFlag = true;
				}
			}
			else{
				if(i>nums1.length-1){
					j++;
					arrayFlag = false;
				}
				else{
					i++;
					arrayFlag = true;
				}
			}
			count++;
			if(median <= count){
				if(flag == 1){
					return arrayFlag ? nums1[i-1] : nums2[j-1];
				}
				else{
					nedianNum += arrayFlag ? nums1[i-1]:nums2[j-1];
					if(median+1 == count)
						return (double)nedianNum/2;
				}
			}
		}
		return nedianNum;
	}
	
	public static void main(String[] args){
		int[] a = {};
		int[] b = {1};
		System.out.println((findMedianSortedArrays2(a,b)));
	}
}
