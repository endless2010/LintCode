import org.junit.Assert;
import org.junit.Test;

/*
 * 给出3*n + 1 个的数字，除其中一个数字之外其他每个数字均出现三次，找到这个数字。
 * 给出 [1,1,2,3,3,3,2,2,4,1] ，返回 4
 * 挑战:一次遍历，常数级的额外空间复杂度
 */
public class SingleNumber2 {
	public int singleNumberII(int[] A) {  
        if(A == null || A.length == 0) return 0;  
        int[] bits = new int[32];  
        for(int i = 0; i < A.length; i++) {  
            for(int j = 0; j < 32; j++) {  
                if((A[i] & (1 << j)) > 0)  
                    bits[j] +=1;  
            }  
        }  
        int result = 0;  
        for(int i = 0; i < 32; i++) {  
            if(bits[i] > 0)  
                result |= (bits[i]%3 << i);  
        }  
        return result;  
    }
	
	@Test
	public void test(){
		Assert.assertEquals(2,singleNumberII(new int[]{1,1,1,2}));
		Assert.assertEquals(2,singleNumberII(new int[]{1,2,1,1}));
		Assert.assertEquals(2,singleNumberII(new int[]{2,1,1,1}));
		Assert.assertEquals(2,singleNumberII(new int[]{1,1,2,3,3,1,3}));
	}
}