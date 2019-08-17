package range_80_100;

/**
 * 数组,指针
 */
public class No88_MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int start = 0;
        for(int i=0; i<n; i++){
            int j;
            for(j=start; j<m+i; j++){
                if(nums1[j] > nums2[i]){
                    start = j;
                    break;
                }
            }
            if(j == m+i){
                for(int k=i; k<n; k++){
                    nums1[k+m] = nums2[k];
                }
                break;
            }
            for(int k=m+i-1; k>start-1; k--){
                nums1[k+1] = nums1[k];
            }
            nums1[start] = nums2[i];
        }
    }
}
