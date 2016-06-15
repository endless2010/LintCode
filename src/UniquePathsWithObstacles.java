import org.junit.Assert;
import org.junit.Test;

/**

 * Follow up for "Unique Paths":
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * 
 * For example,
 * There is one obstacle in the middle of a 3x3 grid as illustrated below.
 * [
 * [0,0,0],
 * [0,1,0],
 * [0,0,0]
 * ]
 * The total number of unique paths is 2.
 */
public class UniquePathsWithObstacles {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    	if(obstacleGrid==null || obstacleGrid[0]==null ||obstacleGrid.length<0 ||obstacleGrid[0].length<0)
    		return 0;
    	int m=obstacleGrid.length;
    	int n=obstacleGrid[0].length;
    	
    	int[][] dp=new int[m][n];
    	boolean found=false;
    	for(int i=0;i<n;++i){
    		if(obstacleGrid[0][i]==1)
    			found=true;
    		dp[0][i]=found?-1:1;
    	}
    	found=false;
    	for(int i=0;i<m;++i){
    		if(obstacleGrid[i][0]==1)
    			found=true;
    		dp[i][0]=found?-1:1;
    	}
    	for(int i=1;i<m;++i){
    		for(int j=1;j<n;++j){
    			if(obstacleGrid[i][j]==1){
    				dp[i][j]=-1;
    				continue;
    			}
    			if(dp[i-1][j]!=-1)
    				dp[i][j]+=dp[i-1][j];
    			if(dp[i][j-1]!=-1)
    				dp[i][j]+=dp[i][j-1];
    		}
    	}
    	return dp[m-1][n-1]>0?dp[m-1][n-1]:0;
    }
    @Test
    public void test(){
    	int[][] obstacleGrid;
    	obstacleGrid=new int[][]{{0,0},{0,0}};
    	Assert.assertEquals(2,uniquePathsWithObstacles(obstacleGrid));
    	obstacleGrid=new int[][]{{0,0},{0,0},{0,0}};
    	Assert.assertEquals(3,uniquePathsWithObstacles(obstacleGrid));
    	obstacleGrid=new int[][]{{0,0,0},{0,0,0},{0,0,0}};
    	Assert.assertEquals(6,uniquePathsWithObstacles(obstacleGrid));
    	
    	obstacleGrid=new int[][]{{0,0},{1,0}};
    	Assert.assertEquals(1,uniquePathsWithObstacles(obstacleGrid));
    	obstacleGrid=new int[][]{{0,0},{0,1},{0,0}};
    	Assert.assertEquals(1,uniquePathsWithObstacles(obstacleGrid));
    	obstacleGrid=new int[][]{{0,0,0},{0,1,0},{0,0,0}};
    	Assert.assertEquals(2,uniquePathsWithObstacles(obstacleGrid));
    	obstacleGrid=new int[][]{{0,0},{0,0},{0,0},{1,0},{0,0}};
    	Assert.assertEquals(3,uniquePathsWithObstacles(obstacleGrid));
    }
}
