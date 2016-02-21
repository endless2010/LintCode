import org.junit.Assert;
import org.junit.Test;

/*
 * ����һ������ m x n ��Ԫ�صľ��� (m ��, n ��), ��þ����֮���ͱ�����
 * �������¾���
[
  [1, 2,  3,  4],
  [5, 6,  7,  8],
  [9,10, 11, 12]
]
`  ���� [1, 2, 5, 9, 6, 3, 4, 7, 10, 11, 8, 12]
 * http://blog.csdn.net/wutingyehe/article/details/46629087
 */
public class PrintZMatrix {
	 public int[] printZMatrix(int[][] matrix) {
	        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return null;
	        int count = matrix.length * matrix[0].length;
	        int[] array = new int[count];
	        int r = 0, c = 0;
	        array[0] = matrix[0][0];
	        for (int i = 1; i < count; ) {
	            //б���ߵ���
	            while(i < count && r - 1 >= 0 && c + 1 < matrix[0].length) {
	                array[i++] = matrix[--r][++c];
	            }
	            //������һ�������ɺ�����ʱ������һ��
	            if (i < count && c + 1 < matrix[0].length) {
	                array[i++] = matrix[r][++c];
	            } else if (i < count && r + 1 < matrix.length) {
	                array[i++] = matrix[++r][c];
	            }
	            //б���ߵ���
	            while(i < count && r + 1 < matrix.length && c - 1 >= 0) {
	                array[i++] = matrix[++r][--c];
	            }
	            //������һ��������������ʱ������һ��
	            if (i < count && r + 1 < matrix.length) {
	                array[i++] = matrix[++r][c];
	            } else if (i < count && c + 1 < matrix[0].length) {
	                array[i++] = matrix[r][++c];
	            }
	        }
	        return array;
	    }
	 @Test
	 public void test(){
		 int[][] array=new int[][]{
				 {1, 2,  3,  4},	 
				 {5, 6,  7,  8},
				 {9,10, 11, 12}};
		 int[] result={1, 2, 5, 9, 6, 3, 4, 7, 10, 11, 8, 12};
		 Assert.assertArrayEquals(result,printZMatrix(array));
	 }
}
