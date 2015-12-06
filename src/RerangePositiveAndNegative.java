import java.util.Arrays;

import org.junit.Test;


public class RerangePositiveAndNegative {
	private void swap(int[] array,int i,int j){
		if(i<0 || j>=array.length)
			return;
		int temp=array[i];array[i]=array[j];array[j]=temp;
	}
	public void rerange(int[] A){
		if(A==null || A.length==0)
			return;
		int positiveIndex=0;
		int negativeIndex=A.length-1;
		while(positiveIndex < negativeIndex){
			while(positiveIndex<negativeIndex && A[positiveIndex]>0)
				positiveIndex++;
			while(negativeIndex>positiveIndex && A[negativeIndex]<0)
				negativeIndex--;
			swap(A,positiveIndex,negativeIndex);
		}
		int i=0,j=A.length-2;
		while(i<j){
			swap(A,i,j);
			i+=2;
			j-=1;
		}
	}
	
	@Test
	public void test(){
		int[] A;
		A=new int[]{1,2,3,-4,-5,-6};
		rerange(A);
		System.out.println(Arrays.toString(A));
		
		A=new int[]{1,-2,-3,4,-5,6};
		rerange(A);
		System.out.println(Arrays.toString(A));
		
		A=new int[]{-1,-2,-3,4,5,6};
		rerange(A);
		System.out.println(Arrays.toString(A));
		
		A=new int[]{-1,2,-3,4,5,-6};
		rerange(A);
		System.out.println(Arrays.toString(A));
		
		A=new int[]{-13,-8,-12,-15,-14,35,7,-1,11,27,10,-7,-12,28,18};
		rerange(A);
		System.out.println(Arrays.toString(A));
	}
}
