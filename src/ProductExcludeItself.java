import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

/*
 * https://leetcode.com/discuss/67323/my-2ms-easy-to-understand-solution-java
 */
public class ProductExcludeItself {
    public ArrayList<Long> productExcludeItself(ArrayList<Integer> A) {
        ArrayList<Long> res = new ArrayList<Long>();
        if(A==null ||A.size()==0)
        	return res;
        res.add(1L);
        for(int i=1; i<A.size(); i++){
            res.add(res.get(i-1)*A.get(i-1));
        }
        long rearProduct = 1;
        for(int j=A.size()-1; j>=0; j--){
            res.set(j, res.get(j) *rearProduct);
            rearProduct *= A.get(j);
        }
        return res;
    }
    @Test
    public void test(){
    	ArrayList<Long> list=productExcludeItself(LintCodeUtils.toArrayList(new int[]{1,2,3,4}));
    	Assert.assertEquals(4,list.size());
    	Assert.assertEquals(24,list.get(0).longValue());
    	Assert.assertEquals(12,list.get(1).longValue());
    	Assert.assertEquals(8,list.get(2).longValue());
    	Assert.assertEquals(6,list.get(3).longValue());
    	
    	ArrayList<Long> list2=productExcludeItself(LintCodeUtils.toArrayList(new int[]{11,22,33,44,55,66,77,88,99}));
    	Assert.assertEquals(4,list.size());
    	Assert.assertEquals(77786550737280L,list2.get(0).longValue());
    	Assert.assertEquals(38893275368640L,list2.get(1).longValue());
    	Assert.assertEquals(25928850245760L,list2.get(2).longValue());
    	Assert.assertEquals(19446637684320L,list2.get(3).longValue());
    	
    }
}
