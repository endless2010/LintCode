import org.junit.Assert;
import org.junit.Test;

/*
 * ����3*n + 1 �������֣�������һ������֮������ÿ�����־��������Σ��ҵ�������֡�
 * ���� [1,1,2,3,3,3,2,2,4,1] ������ 4
 * ��ս:һ�α������������Ķ���ռ临�Ӷ�
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