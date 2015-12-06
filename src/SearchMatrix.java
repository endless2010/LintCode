import org.junit.Assert;
import org.junit.Test;

/* 
 * 写出一个高效的算法来搜索m×n矩阵中的值，返回这个值出现的次数。
 * 每行中的整数从左到右是递增的。
 * 每一列的整数从上到下是递增的。
 * 在每一行或每一列中没有重复的整数
 */
//TODO :改善效率
public class SearchMatrix {
	public  int searchMatrix(int[][] matrix, int target) {
		if(matrix==null)
			return 0;
		int count=0;
		for(int i=0;i<matrix.length;++i)
			for(int j=0;j<matrix[i].length;++j)
				if(matrix[i][j]==target)
					count++;
		return count;
    }
	@Test
	public void test(){
		int[][] matrix={
				{1, 3, 5, 7},
				{2, 4, 7, 8},
				{3, 5, 9, 10}
		};
		Assert.assertEquals(2,searchMatrix(matrix,3));
		Assert.assertEquals(2,searchMatrix(matrix,5));
		Assert.assertEquals(1,searchMatrix(matrix,4));
	}
}
