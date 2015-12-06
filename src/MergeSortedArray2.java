import org.junit.Assert;
import org.junit.Test;

/*
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional
 * elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively
 */
public class MergeSortedArray2 {
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        if(B==null ||n<=0)
        	return;
        if(A==null ||m<=0){
        	System.arraycopy(B, 0, A, 0,n);
        	return;
        }
        --m;--n;
        while(m>=0 && n>=0)
          if(A[m]>B[n])  
        	  A[m+n+1]=A[m--];
          else                 
        	  A[m+n+1]=B[n--];

        while(n>=0)  
        	A[n]=B[n--]; 
    }
    @Test
    public void test(){
    	int[] nums1={1,3,5,7,0,0,0,0,0,0};
    	int[] nums2={2,4,6,8,0};
    	mergeSortedArray(nums1,4,nums2,4);
    	Assert.assertArrayEquals(new int[]{1,2,3,4,5,6,7,8,0,0},nums1);
    }
}
