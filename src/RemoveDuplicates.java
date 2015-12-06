import org.junit.Assert;
import org.junit.Test;


public class RemoveDuplicates {
	 public int removeDuplicates(int[] nums) {
	    	if(nums==null ||nums.length==0)
	    		return 0;
	    	if(nums.length==1)
	    		return 1;
	    	int index=1;
	    	for(int i=1;i<nums.length;++i)
	    		if(nums[i]!=nums[i-1])
	    			nums[index++]=nums[i];
	        return index;
	    }
	    @Test
	    public void test(){
	    	int[] nums1=new int[]{1,1,2};
	    	Assert.assertEquals(2,removeDuplicates(nums1));
	    	
	    	int[] nums2=new int[]{1,2,2,3,3,3,3,4};
	    	Assert.assertEquals(4,removeDuplicates(nums2)); 
	    	
	    	int[] nums3=new int[]{1,2,3};
	    	Assert.assertEquals(3,removeDuplicates(nums3));
	    }
}
