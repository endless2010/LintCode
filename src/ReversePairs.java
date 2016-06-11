import org.junit.Assert;
import org.junit.Test;

/*
 * 在数组中的两个数字如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 给你一个数组，求出这个数组中逆序对的总数。
 * 概括：如果a[i] > a[j] 且 i < j， a[i] 和 a[j] 构成一个逆序对。
 * 序列 [2, 4, 1, 3, 5] 中，有 3 个逆序对 (2, 1), (4, 1), (4, 3)，则返回 3 。
 */
public class ReversePairs {
    public long reversePairs(int[] A) {
    	if(A==null || A.length==0)
    		return 0;
    	int count=0;
    	for(int i=0;i<A.length;++i){
    		for(int j=i+1;j<A.length;++j){
    			if(A[i]>A[j])
    				count++;
    		}
    	}
    	return count;
    }
    
    @Test
    public void test(){
    	Assert.assertEquals(3,reversePairs(new int[]{2, 4, 1, 3, 5}));
    	Assert.assertEquals(0,reversePairs(new int[]{1, 2, 3, 4, 5}));
    	Assert.assertEquals(10,reversePairs(new int[]{5, 4, 3, 2, 1}));
    }
}
