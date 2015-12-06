import org.junit.Assert;
import org.junit.Test;

/*
 * 给定一个整数数组（下标从 0 到 n-1， n 表示整个数组的规模），
 * 请找出该数组中的最长上升连续子序列。（最长上升连续子序列可以定义为从右到左或从左到右的序列。）
 */
public class LongestIncreasingContinuousSubsequence {
	
    public int longestIncreasingContinuousSubsequence(int[] A){
		if(A==null || A.length==0)
			return 0;
		int prev=A[0];
		for(int i=1;i<A.length;++i){
			int val=A[i]-prev;
			prev=A[i];
			A[i]=val>0?1:(val<0?-1:0);
		}
		int numsP1=1,maxP1=1;
		int numsN1=1,maxN1=1;
		for(int i=1;i<A.length;++i){
			if(A[i]==1)
				numsP1++;
			else
				numsP1=1;
			if(A[i]==-1)
				numsN1++;
			else
				numsN1=1;
			if(numsP1>maxP1)
				maxP1=numsP1;
			if(numsN1>maxN1)
				maxN1=numsN1;
		}
		return maxN1>maxP1?maxN1:maxP1;
	}
	
	@Test
	public void test(){
		Assert.assertEquals(4,longestIncreasingContinuousSubsequence(new int[]{5,4,2,1,3}));
		Assert.assertEquals(5,longestIncreasingContinuousSubsequence(new int[]{5,4,3,2,1}));
		Assert.assertEquals(4,longestIncreasingContinuousSubsequence(new int[]{5,1,2,3,4}));
		Assert.assertEquals(4,longestIncreasingContinuousSubsequence(new int[]{6,5,3,4,5,6}));
		Assert.assertEquals(4,longestIncreasingContinuousSubsequence(new int[]{6,5,3,4,2,3,4,5}));
		Assert.assertEquals(6,longestIncreasingContinuousSubsequence(new int[]{6,5,3,4,5,6,5,4,3,2,1}));
		Assert.assertEquals(2,longestIncreasingContinuousSubsequence(new int[]{6,5}));
		Assert.assertEquals(1,longestIncreasingContinuousSubsequence(new int[]{6}));
	}
}
