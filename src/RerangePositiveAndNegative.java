import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * 给出一个含有正整数和负整数的数组，重新排列成一个正负数交错的数组。 
 * 注意事项 不需要保持正整数或者负整数原来的顺序。 
 * 给出数组[-1, -2, -3, 4, 5, 6]，重新排序之后，变成[-1, 5, -2, 4, -3, 6]或者其他任何满足要求的答案
 */
public class RerangePositiveAndNegative {

	public void rerange(int[] A) {
		if (A == null || A.length == 0)
			return;
		List<Integer> positives = new ArrayList<Integer>();
		List<Integer> negatives = new ArrayList<Integer>();
		
		for(int i=0;i<A.length;++i){
			if(A[i]>0)
				positives.add(A[i]);
			else
				negatives.add(A[i]);
		}
		if(positives.size()>negatives.size()){
			for(int i=0;i<positives.size();i++){
				A[2*i]=positives.get(i);
			}
			for(int i=0;i<negatives.size();i++){
				A[2*i+1]=negatives.get(i);
			}
		}else{
			for(int i=0;i<negatives.size();i++){
				A[2*i]=negatives.get(i);
			}
			for(int i=0;i<positives.size();i++){
				A[2*i+1]=positives.get(i);
			}
		}
	}

	@Test
	public void test() {
		int[] A;
		A = new int[] { 1, 2, 3, -4, -5, -6 };	rerange(A);
		System.out.println(Arrays.toString(A));

		A = new int[] { 1, -2, -3, 4, -5, 6 };	rerange(A);
		System.out.println(Arrays.toString(A));

		A = new int[] { -1, -2, -3, 4, 5, 6 };	rerange(A);
		System.out.println(Arrays.toString(A));

		A = new int[] { -1, 2, -3, 4, 5, -6 };	rerange(A);
		System.out.println(Arrays.toString(A));

		A = new int[] { -13, -8, -12, -15, -14, 35, 7, -1, 11, 27, 10, -7, -12,28, 18 };	rerange(A);
		System.out.println(Arrays.toString(A));

		A = new int[] { 1, 2, 3, -4, -5 }; rerange(A);
		System.out.println(Arrays.toString(A));
	}
}
