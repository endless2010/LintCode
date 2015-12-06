import org.junit.Assert;
import org.junit.Test;

/*
 * �����һ����������(sizeΪn)������������ص㣺
����λ�õ������ǲ�ͬ��
A[0] < A[1] ���� A[n - 2] > A[n - 1]
�ٶ�P�Ƿ�ֵ��λ��������A[P] > A[P-1]��A[P] > A[P+1]����������������һ����ֵ��λ�á�
��������[1, 2, 1, 3, 4, 5, 7, 6]����1, ����ֵ 2 ����λ��, ����6, ����ֵ 7 ����λ��.
 */
public class FindPeek {
    public int findPeak(int[] A) {
		for(int i=1;i<A.length-1;++i){
			if(A[i]>A[i-1]&&A[i]>A[i+1])
				return i;
		}
		return -1;
    }
	@Test
	public void test(){
		Assert.assertEquals(1,findPeak(new int[]{1,2,1}));
		Assert.assertEquals(3,findPeak(new int[]{1,2,3,4,3}));
		Assert.assertEquals(4,findPeak(new int[]{1, 3, 4, 5, 7, 6}));
	}
}