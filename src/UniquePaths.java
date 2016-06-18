import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any point in time. 
 * The robot is trying to reach the bottom-right corner of the grid 
 * (marked 'Finish' in the diagram below).
 * How many possible unique paths are there?
 * Notice: m and n will be at most 100.
 * 
 * Have you met this question in a real interview? Yes
 * Example
 * 1,1	1,2	1,3	1,4	1,5	1,6	1,7
 * 2,1						2,7
 * 3,1						3,7
 * Above is a 3 x 7 grid. How many possible unique paths are there?
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
    	if(m<=0 || n<=0)
    		return 0;
    	if(m==1 || n==1)
    		return 1;
    	int[][] dp=new int[m][n];
    	Arrays.fill(dp[0], 1);
    	for(int i=0;i<m;++i)
    		dp[i][0]=1;
    	for(int i=1;i<m;++i){
    		for(int j=1;j<n;++j)
    			dp[i][j]=dp[i-1][j]+dp[i][j-1];
    	}
    	return dp[m-1][n-1];
    }
    @Test
    public void test(){
    	Assert.assertEquals(1,uniquePaths(1,1));
    	Assert.assertEquals(1,uniquePaths(1,2));
    	Assert.assertEquals(1,uniquePaths(2,1));
    	Assert.assertEquals(2,uniquePaths(2,2));
    	Assert.assertEquals(3,uniquePaths(3,2));
    }
}
