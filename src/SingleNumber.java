import org.junit.Assert;
import org.junit.Test;


public class SingleNumber {
    public int singleNumber(int[] A) {
    	int result=0;
    	for(int i:A)
    		result^=i;
    	return result;
    }   
    @Test
    public void test(){	
    	Assert.assertEquals(1,singleNumber(new int[]{2,2,1}));
    	Assert.assertEquals(3,singleNumber(new int[]{3,2,2}));
    	Assert.assertEquals(2,singleNumber(new int[]{0,0,1,1,2}));
    	Assert.assertEquals(3,singleNumber(new int[]{0,3,2,0,2}));
    }
}
