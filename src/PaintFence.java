import org.junit.Assert;
import org.junit.Test;

/**
 * There is a fence with n posts, each post can be painted with one of the k colors.
 * You have to paint all the posts such that no more than two adjacent fence posts have the same color.
 * Return the total number of ways you can paint the fence.
 * n = 3, k = 2, return 6
 *      	 post 1,   post 2, post 3
 *      way1    0         0       1 
 *      way2    0         1       0
 *      way3    0         1       1
 *      way4    1         0       0
 *      way5    1         0       1
 *      way6    1         1       0
 */
public class PaintFence {
    public int numWays(int n, int k) {
    	if(n<=0 || k<=0)
    		return 0;
    	if(n==1)
    		return k;
        int[] dp=new int[n];
        dp[0]=k;
        dp[1]=k*k;
        for(int i=2;i<n;++i){
        	dp[i]=(k-1)*dp[i-1]+(k-1)*dp[i-2];
        }
        return dp[n-1];
    }
    @Test
    public void test(){
    	Assert.assertEquals(6,numWays(3,2));
    	Assert.assertEquals(4,numWays(2,2));
    	Assert.assertEquals(2,numWays(1,2));
    }
}
