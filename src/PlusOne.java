import org.junit.Assert;
import org.junit.Test;


public class PlusOne {
    public int[] plusOne(int[] digits) {
    	digits[digits.length-1]++;
    	if(digits[digits.length-1]<10){		
    		return digits;
    	} 	
    	for(int i=digits.length-1;i>0;--i){
    		if(digits[i]==10){
    			digits[i]=0;
    			digits[i-1]++;
    		}
    	}
    	if(digits[0]<10)
    		return digits;
    	int[] array=new int[digits.length+1];
    	array[0]=1;
        return array;
    }
    
    @Test
    public void test(){
    	Assert.assertArrayEquals(new int[]{2},plusOne(new int[]{1}));
    	Assert.assertArrayEquals(new int[]{1,2,4},plusOne(new int[]{1,2,3}));
    	Assert.assertArrayEquals(new int[]{2,0,0},plusOne(new int[]{1,9,9}));
    	Assert.assertArrayEquals(new int[]{1,3,0},plusOne(new int[]{1,2,9}));
    	Assert.assertArrayEquals(new int[]{1,0,0,0},plusOne(new int[]{9,9,9}));
    }
}
