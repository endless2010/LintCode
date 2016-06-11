import org.junit.Assert;
import org.junit.Test;

/*
 * �������е������������ǰ��һ�����ִ��ں�������֣����������������һ������ԡ�
 * ����һ�����飬����������������Ե�������
 * ���������a[i] > a[j] �� i < j�� a[i] �� a[j] ����һ������ԡ�
 * ���� [2, 4, 1, 3, 5] �У��� 3 ������� (2, 1), (4, 1), (4, 3)���򷵻� 3 ��
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
