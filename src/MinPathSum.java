import org.junit.Assert;
import org.junit.Test;

/*
 * ����һ��ֻ���Ǹ�������m*n�����ҵ�һ�������Ͻǵ����½ǵĿ���ʹ���ֺ���С��·����
 */
public class MinPathSum {
    public int minPathSum(int[][] grid) {
    	if (grid == null || grid.length == 0 || grid[0].length == 0)
    	    return 0;

    	  int[] min = new int[grid[0].length];

    	  for (int i = 0; i < grid.length; i++)
    	    for (int j = 0; j < grid[0].length; j++) {
    	      if (j > 0)
    	        if (i > 0)
    	          min[j] = Math.min(min[j], min[j - 1]);
    	        else
    	          min[j] = min[j - 1];
    	      min[j] += grid[i][j];
    	    }

    	  return min[min.length - 1];
    	}
    
    @Test
    public void test(){
    	int[][] grid={
    			{1,2,3},
    			{4,5,6},
    			{7,8,9}
    	};
    	Assert.assertEquals(21,minPathSum(grid));
    }
}
