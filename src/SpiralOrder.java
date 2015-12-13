import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class SpiralOrder {
	List<Integer> spiralOrder(int[][] matrix){
		List<Integer> result=new ArrayList<Integer>();
		if(matrix==null || matrix.length==0 || matrix[0].length==0)
			return result;
		int colStart=0,colEnd=matrix[0].length-1;
		int rowStart=0,rowEnd=matrix.length-1;
		
		while(rowStart<=rowEnd && colStart<=colEnd){
			for(int i=colStart;i<=colEnd;++i)
				result.add(matrix[rowStart][i]);
			
			for(int i=rowStart+1;i<=rowEnd;++i)
				result.add(matrix[i][colEnd]);
			
			for(int i=colEnd-1;i>=colStart;--i)
				if(rowEnd>rowStart)
				result.add(matrix[rowEnd][i]);
			
			for(int i=rowEnd-1;i>rowStart;--i)
				if(colEnd>colStart)
				result.add(matrix[i][colStart]);
			rowStart++;
			colStart++;
			rowEnd--;
			colEnd--;
		}
		return result;
	}
	@Test
	public void test(){
		int[][] matrix={
				{1,2,3,4},
				{5,6,7,8},
				{9,10,11,12}
		};
		System.out.println(spiralOrder(matrix));
		int[][] matrix2={
				{1,2,3,4,5},
				{6,7,8,9,10},
				{11,12,13,14,15},
				{16,17,18,19,20}
		};
		System.out.println(spiralOrder(matrix2));
	}
}