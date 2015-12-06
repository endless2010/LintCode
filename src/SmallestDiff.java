import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class SmallestDiff {
	
	public int smallestDifference(int[] A,int[] B){
		Arrays.sort(A);
		Arrays.sort(B);
		int i=0,j=0;
		int min=Integer.MAX_VALUE;
		int times=0;
		while((i<A.length || j<B.length)&&times<(A.length+B.length)){
			times++;
			int value1=i<A.length?A[i]:A[A.length-1];
			int value2=j<B.length?B[j]:B[B.length-1];
			if(value1<value2){
				if((value2-value1)<min)
					min=value2-value1;
				i++;
			}else if(value1>value2){
				if((value1-value2)<min)
					min=value1-value2;
				j++;
			}else{
				return 0;
			}
		}
		return min;
	}
	
	@Test
	public void test(){
		Assert.assertEquals(0,smallestDifference(new int[]{1,2},new int[]{1,2}));
		Assert.assertEquals(0,smallestDifference(new int[]{1,2,3,4},new int[]{2,3,4,5}));
		Assert.assertEquals(1,smallestDifference(new int[]{1,2,3,4},new int[]{5,6,7,8}));
		Assert.assertEquals(1,smallestDifference(new int[]{1,3,5},new int[]{4,6,12}));
		Assert.assertEquals(1,smallestDifference(new int[]{1,3,17},new int[]{10,11,12,15,16}));
		Assert.assertEquals(9,smallestDifference(new int[]{1},new int[]{10,12}));
		Assert.assertEquals(3,smallestDifference(new int[]{3},new int[]{10,8,16,19,6}));
	}
}