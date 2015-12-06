import org.junit.Assert;
import org.junit.Test;

/*
 * 你给出一个整数数组(size为n)，其具有以下特点：
相邻位置的数字是不同的
A[0] < A[1] 并且 A[n - 2] > A[n - 1]
假定P是峰值的位置则满足A[P] > A[P-1]且A[P] > A[P+1]，返回数组中任意一个峰值的位置。
给出数组[1, 2, 1, 3, 4, 5, 7, 6]返回1, 即数值 2 所在位置, 或者6, 即数值 7 所在位置.
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