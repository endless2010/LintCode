import java.util.Arrays;

import org.junit.Test;

/*
 * Given an integer n, generate a square matrix filled with elements from 1 to n^2 in spiral order.
Given n = 3,
You should return the following matrix:
[
  [ 1, 2, 3 ],
  [ 8, 9, 4 ],
  [ 7, 6, 5 ]
]
 */
public class GenerateSprialMatrix {
	 public int[][] generateMatrix(int n) {
		int[][] result=new int[n][n];
		int colStart=0,colEnd=n-1;
		int rowStart=0,rowEnd=n-1;
		int value=1;
		while(rowStart<=rowEnd && colStart<=colEnd){
			for(int i=colStart;i<=colEnd;++i)
				result[rowStart][i]=value++;
			for(int i=rowStart+1;i<=rowEnd;++i)
				result[i][rowEnd]=value++;
			for(int i=colEnd-1;i>=colStart;--i)
					result[rowEnd][i]=value++;
			for(int i=rowEnd-1;i>rowStart;--i)
					result[i][rowStart]=value++;
			rowStart++;
			colStart++;
			rowEnd--;
			colEnd--;
		}
		return result;
	 }
	 private void print(int[][] array){
		 for(int i=0;i<array.length;++i)
			 System.out.println(Arrays.toString(array[i])); 
		 System.out.println();
	 }
	 @Test
	 public void test(){
		 int[][] result=generateMatrix(3);
		 print(result);
	 }
}
