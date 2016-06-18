import org.junit.Assert;
import org.junit.Test;

/**
 * There are a row of n houses, each house can be painted with one of the k colors. 
 * The cost of painting each house with a certain color is different. 
 * You have to paint all the houses such that no two adjacent houses have the same color.
 * 
 * The cost of painting each house with a certain color is represented by a n x k cost matrix. 
 * For example, costs[0][0] is the cost of painting house 0 with color 0; 
 * costs[1][2] is the cost of painting house 1 with color 2, and so on... 
 * Find the minimum cost to paint all houses.
 * 
 * Given n = 3, k = 3, costs = [[14,2,11],[11,14,5],[14,3,10]] return 10
 * house 0 is color 2, house 1 is color 3, house 2 is color 2, 2 + 5 + 3 = 10
 *
 */
public class PaintHouse2 {
	public int minCostII(int[][] costs) {
		if(costs==null || costs.length==0 || costs[0].length==0)
			return 0;
		int[][] price = new int[costs.length][costs[0].length];
		System.arraycopy(costs[0], 0, price[0], 0, costs[0].length);
		for(int i=1;i<price.length;++i){
			for(int k=0;k<price[i].length;++k){
				int minwithoutk=Integer.MAX_VALUE;
				for(int j=0;j<price[i].length;++j)
					if(j!=k && price[i-1][j]<minwithoutk)
						minwithoutk=price[i-1][j];
				price[i][k]=costs[i][k]+minwithoutk;
			}
		}
		int min=price[price.length-1][0];
		for(int i=1;i<price[0].length;++i)
			if(price[price.length-1][i]<min)
				min=price[price.length-1][i];
		return min;
	}
	@Test
	public void test(){
		Assert.assertEquals(10,minCostII(new int[][]{{14,2,11},{11,14,5},{14,3,10}}));
		Assert.assertEquals(13,minCostII(new int[][]{{14,2},{11,5}}));
	}
}
