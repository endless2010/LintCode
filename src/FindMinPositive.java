import org.junit.Assert;
import org.junit.Test;

public class FindMinPositive {
	
	    public int firstMissingPositive(int[] A) {  
		       if (A == null || A.length == 0) return 1;  	          
		       for (int i = 0; i < A.length; i++) {  
		           while (A[i] != i + 1) {  
	               if (A[i] <= 0 || A[i] >= A.length || A[i] == A[A[i] - 1]) break;  
	               		int temp = A[i];  
		                A[i] = A[temp - 1];  
		                A[temp -1]= temp;  
		            }  
		        }  	          
		        for (int i = 0; i < A.length; i++) {  
		           if (A[i] != i + 1) {  
		                return i+1;  
		           }  
		        }  
		        return A.length + 1;          
		    }
	@Test
	public void test(){
		Assert.assertEquals(1,firstMissingPositive(new int[]{}));
		Assert.assertEquals(1,firstMissingPositive(new int[]{-1,-2}));
		Assert.assertEquals(3,firstMissingPositive(new int[]{2,4,-1,1}));
		Assert.assertEquals(4,firstMissingPositive(new int[]{1,2,3}));
		Assert.assertEquals(1,firstMissingPositive(new int[]{-1,-2,3}));
		Assert.assertEquals(1,firstMissingPositive(new int[]{2,4,-1}));
		Assert.assertEquals(5,firstMissingPositive(new int[]{3,6,4,1,2}));
		Assert.assertEquals(1,firstMissingPositive(new int[]{6,7}));
	}
}