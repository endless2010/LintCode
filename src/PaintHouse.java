import org.junit.Assert;
import org.junit.Test;

/**
 * There are a row of n houses, each house can be painted with one of the three colors: red, blue or green. 
 * The cost of painting each house with a certain color is different. You have to paint all the houses such that
 *  no two adjacent houses have the same color.
 * The cost of painting each house with a certain color is represented by a n x 3 cost matrix. 
 * For example, costs[0][0] is the cost of painting house 0 with color red; 
 * costs[1][2] is the cost of painting house 1 with color green, and so on... Find the minimum cost to paint all houses.
 * All costs are positive integers.
 * 
 * Given costs = [[14,2,11],[11,14,5],[14,3,10]] return 10
 * house 0 is blue, house 1 is green, house 2 is blue, 2 + 5 + 3 = 10
 */
public class PaintHouse {
	public int minCost(int[][] costs) {
		if(costs==null || costs.length==0 || costs[0].length==0)
			return 0;
		int[][] price = new int[costs.length][3];
		System.arraycopy(costs[0], 0, price[0], 0, costs[0].length);
		for(int i=1;i<price.length;++i){
			price[i][0]=costs[i][0]+Math.min(price[i-1][1],price[i-1][2]);
			price[i][1]=costs[i][1]+Math.min(price[i-1][0],price[i-1][2]);
			price[i][2]=costs[i][2]+Math.min(price[i-1][0],price[i-1][1]);
		}
		int min=Math.min(price[costs.length-1][0], 
				Math.min(price[costs.length-1][1],
						 price[costs.length-1][2]));
		return min;
	}
	@Test
	public void test(){
		Assert.assertEquals(10,minCost(new int[][]{{14,2,11},{11,14,5},{14,3,10}}));
	}
}
