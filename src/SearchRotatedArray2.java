

import org.junit.Assert;
import org.junit.Test;

/*
给出[3,4,4,5,7,0,1,2]和target=4，返回 true
*/
public class SearchRotatedArray2 {
    public boolean search(int[] A, int target) {
    	if(A==null ||A.length==0)
    		return false;
    	int low=0;
    	int high=A.length-1;
    	while(low<=high){
    		int mid=(low+high)/2;
        	if(A[mid]==target)
        		return true;
        	if(A[mid]<target){
        		if(A[high]>=target)
        			low=mid+1;
        		else
        			high=mid-1;
        	}else{
        		if(A[low]<=target)
        			high=mid-1;
        		else
        			low=mid+1;
        	}
    	}
        return false;
    }
    @Test
    public void test(){
    	Assert.assertEquals(true,search(new int[]{1, 2, 3},1));
    	Assert.assertEquals(true,search(new int[]{1, 2, 3},2));
    	Assert.assertEquals(true,search(new int[]{1, 2, 3},3));
    	Assert.assertEquals(false,search(new int[]{1, 2, 3},4));
    	Assert.assertEquals(true,search(new int[]{4, 5, 1, 2, 3},1));
    	Assert.assertEquals(true,search(new int[]{3,4,4,5,7,0,1,2},4));
    	Assert.assertEquals(false,search(new int[]{3,4,4,5,7,0,1,2},6));
    }
}