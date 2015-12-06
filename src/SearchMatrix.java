import org.junit.Assert;
import org.junit.Test;

/* 
 * д��һ����Ч���㷨������m��n�����е�ֵ���������ֵ���ֵĴ�����
 * ÿ���е������������ǵ����ġ�
 * ÿһ�е��������ϵ����ǵ����ġ�
 * ��ÿһ�л�ÿһ����û���ظ�������
 */
//TODO :����Ч��
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
